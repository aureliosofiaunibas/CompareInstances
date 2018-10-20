package it.unibas.instcompview.actions;

import it.unibas.instcompview.AppConstants;
import it.unibas.instcompview.api.ILoadScenario;
import it.unibas.instcompview.view.NewScenarioDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.AbstractAction;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author aurelio.sofia
 */
public class CreateScenarioAction extends AbstractAction{
    
    private NewScenarioDialog dialog;

    public CreateScenarioAction(NewScenarioDialog dialog) {
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Properties scenarioProperties = getProperties(dialog);
                
        File home = new File(System.getProperty("user.home"));
        File file = new File(home, scenarioProperties
                .getProperty(AppConstants.SCENARIO) + ".properties");
        
        FileWriter fileWriter;
        
        try {
            fileWriter = new FileWriter(file);
            scenarioProperties.store(fileWriter, null);
            fileWriter.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return;
        }
        
        System.out.println("Create Scenario" + file.toPath());
        System.out.println("Create Scenario" + file.toString());
        
        ILoadScenario load = Lookup.getDefault().lookup(ILoadScenario.class);
        load.load(FileUtil.toFileObject(file));
        
        dialog.setVisible(false);
    }
    
    private Properties getProperties(NewScenarioDialog dialog){
        String scenario = dialog.getScenarioName();
        String leftDB = dialog.getLeftFolder();
        String rightDB = dialog.getRighttFolder();
        String strategy = "";
        if(dialog.isSignature()){
            strategy = AppConstants.STRATEGY_SIGNATURE;
        } else {
            strategy = AppConstants.STRATEGY_BRUTEFORCE;
        }
        boolean functional = dialog.isFunctional();
        boolean injective = dialog.isInjective();
        boolean stopIfNonMatchingTuples = dialog.doesItStop();
        boolean twoWayValueMapping = dialog.isTwoWay();
        boolean forceExaustiveSearch = dialog.forceExaustiveSearch();
        boolean convertSkolemInHash = dialog.convertSkolem();
        String K = dialog.getK();
        String bestScoreThreshold = dialog.getBestScoreThreshold();
        
        Properties scenarioProperties = new Properties();
        scenarioProperties.put(AppConstants.SCENARIO, scenario);
        scenarioProperties.put(AppConstants.LEFT_DB, leftDB);
        scenarioProperties.put(AppConstants.RIGHT_DB, rightDB);
        scenarioProperties.put(AppConstants.STRATEGY, strategy);
        scenarioProperties.put(AppConstants.FUNCTIONAL, 
                Boolean.toString(functional));
        scenarioProperties.put(AppConstants.INJECTIVE, 
                Boolean.toString(injective));
        scenarioProperties.put(AppConstants.STOP_IF_NON_MATCHING_TUPLES, 
                Boolean.toString(stopIfNonMatchingTuples));
        scenarioProperties.put(AppConstants.K, K);
        scenarioProperties.put(AppConstants.BEST_SCORE_THRESHOLD, bestScoreThreshold);
        scenarioProperties.put(AppConstants.TWO_WAY_VALUE_MAPPING, 
                Boolean.toString(twoWayValueMapping));
        scenarioProperties.put(AppConstants.CONVERT_SKOLEM_IN_HASH,
                Boolean.toString(convertSkolemInHash));
        scenarioProperties.put(AppConstants.FORCE_EXAUSTIVE_SEARCH, 
                Boolean.toString(forceExaustiveSearch));
        return scenarioProperties;
    }
    
}
