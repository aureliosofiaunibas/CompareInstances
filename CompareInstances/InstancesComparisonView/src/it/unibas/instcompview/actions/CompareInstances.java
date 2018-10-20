package it.unibas.instcompview.actions;

import bart.comparison.ComparisonConfiguration;
import bart.comparison.InstanceMatchTask;
import bart.comparison.operators.ComputeInstanceSimilarityBruteForceCompatibility;
import bart.comparison.operators.ComputeInstanceSimilarityHashing;
import bart.comparison.operators.IComputeInstanceSimilarity;
import it.unibas.instcompview.AppConstants;
import it.unibas.instcompview.Scenario;
import it.unibas.instcompview.nodes.ScenarioNode;
import it.unibas.instcompview.resources.Resources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.AbstractAction;
import org.netbeans.api.progress.*;
import org.netbeans.core.api.multiview.MultiViews;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.StatusDisplayer;
import org.openide.util.NbBundle.Messages;
import org.openide.util.RequestProcessor;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ActionID(
        category = "File",
        id = "it.unibas.instcompview.actions.CompareInstances"
)
@ActionRegistration(
        iconBase = Resources.RESOURCES_ICONS_BASE + "compareInstances.png",
        displayName = "#CTL_CompareInstances"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 2587),
    @ActionReference(path = "Toolbars/File", position = 500)
})
@Messages("CTL_CompareInstances=&Compare Instances")
/**
 *
 * @author aurelio.sofia
 */
public final class CompareInstances extends AbstractAction implements 
        ActionListener, Runnable {
    
    private static Logger log = LoggerFactory.getLogger(CompareInstances.class);
    private static final RequestProcessor THREAD_POOL = 
            new RequestProcessor("Comparison processor", 1);
    private final RequestProcessor.Task task = THREAD_POOL.create(this);
    
    private ScenarioNode scenarioNode;
    private Scenario context;

    public CompareInstances(ScenarioNode node) {
        this.scenarioNode = node;
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        this.context = scenarioNode.getLookup().lookup(Scenario.class);
        
        TopComponent tc = findTopComponent();
        if(findTopComponent() != null){
              tc.close();
        }
        loadComparisonConfiguration();
        
        BaseProgressUtils.showProgressDialogAndRun(task, "Comparing instances...");
        
        openMultiView(tc);
    }
    
    private void loadComparisonConfiguration(){
        ComparisonConfiguration.setForceExaustiveSearch(context.isForceExaustiveSearch());
        ComparisonConfiguration.setFunctional(context.isFunctional());
        ComparisonConfiguration.setInjective(context.isInjective());
        ComparisonConfiguration.setK(context.getK());
        ComparisonConfiguration.setConvertSkolemInHash(context.isConvertSkolemInHash());
        ComparisonConfiguration.
                setStopIfNonMatchingTuples(context.isStopIfNonMatchingTuples());
        ComparisonConfiguration.setTwoWayValueMapping(context.isTwoWayValueMapping());
    }
    
    private void openMultiView(TopComponent tc){
        tc = MultiViews.createMultiView("application/x-comparison", scenarioNode);
        tc.open();
        tc.requestActive();
    }
    
    private TopComponent findTopComponent() {
        Set<TopComponent> openTopComponents =
                WindowManager.getDefault().getRegistry().getOpened();
        for (TopComponent tc : openTopComponents) {
            if(!tc.getName().equals("ScenarioExplorer Window")){
                if (tc.getLookup().lookup(Scenario.class) == context) {
                    return tc;
                }
            }
        }
        return null;
    }

    @Override
    public void run() {
        IComputeInstanceSimilarity similarityChecker = null;
        if(context.getStrategy().equalsIgnoreCase(AppConstants.STRATEGY_BRUTEFORCE)){
            similarityChecker = new ComputeInstanceSimilarityBruteForceCompatibility();
        } else if(context.getStrategy().equalsIgnoreCase(AppConstants.STRATEGY_SIGNATURE)){
            similarityChecker = new ComputeInstanceSimilarityHashing();
        }
        InstanceMatchTask taskResult = similarityChecker.compare(context.getLeftDB(),
                context.getRightDB());
        StatusDisplayer.getDefault().setStatusText("COMPARISON DONE!");
        context.setResult(taskResult);
    }
    
}
