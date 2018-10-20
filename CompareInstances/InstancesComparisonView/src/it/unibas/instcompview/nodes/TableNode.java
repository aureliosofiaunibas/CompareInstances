package it.unibas.instcompview.nodes;

import it.unibas.instcompview.Scenario;
import it.unibas.instcompview.resources.Resources;
import it.unibas.instcompview.view.TableMVEDescription;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.core.api.multiview.MultiViewHandler;
import org.netbeans.core.api.multiview.MultiViewPerspective;
import org.netbeans.core.api.multiview.MultiViews;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.Exceptions;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import speedy.model.database.IDatabase;
import speedy.model.database.ITable;

/**
 *
 * @author aurelio.sofia
 */
public class TableNode extends AbstractNode implements Serializable{
    
    private InstanceContent ic = new InstanceContent();
    
    public TableNode(ITable table, Scenario scenario, String whatDB) {
        this(table, scenario, whatDB, new InstanceContent());
        setDisplayName(table.getName());
        setIconBaseWithExtension(Resources.NODES_ICONS_BASE + "table.png");
    }
    
    private TableNode(ITable table, Scenario scenario, String whatDB, InstanceContent ic){
        super(Children.LEAF, new AbstractLookup(ic));
        ic.add(table);
        ic.add(scenario);
        ic.add(whatDB);
        this.ic = ic;
    }
    
    @Override
    public Action getPreferredAction() {
        return new AbstractAction("Open"){
            @Override
            public void actionPerformed(ActionEvent e){
                ITable table = getLookup().lookup(ITable.class);
                TopComponent tc = findTopComponent();
                ProxyLookup merge = new ProxyLookup(getLookup(), getParentNode().getLookup());
                if(tc == null){
                    tc = MultiViews.createMultiView("application/x-dbntables", 
                            (DBNode) getParentNode());
                    
                    MultiViewHandler mvh = MultiViews.findMultiViewHandler(tc);
                    mvh.addMultiViewDescription(new TableMVEDescription("TableMVE", 
                            getDisplayName(), merge), 20);
               
                    tc.setName(getParentNode().getDisplayName());
                    tc.setDisplayName(getParentNode().getDisplayName());
                    
                    tc.open();
                } else {
                    try{
                        MultiViewHandler mvh = MultiViews.findMultiViewHandler(tc);
                        MultiViewPerspective[] mvps = mvh.getPerspectives();
                        for(MultiViewPerspective mvp : mvps){
                            if(mvp.getDisplayName().equals(table.getName())){
                                tc.requestActive();
                                return;
                            }
                        }
                        TableMVEDescription tmd = new TableMVEDescription(
                                "TableMVE", getDisplayName(), merge);
                        mvh.addMultiViewDescription(tmd, 40);
                    }catch(NullPointerException npe){
                        Exceptions.printStackTrace(npe);
                    }
                }
                tc.requestActive();
            }
        };
    }
    
    private TopComponent findTopComponent() {
        Set<TopComponent> openTopComponents
                = WindowManager.getDefault().getRegistry().getOpened();
        String whatDB = getLookup().lookup(String.class);
        for (TopComponent tc : openTopComponents) {
            if (!tc.getName().equals("ScenarioExplorer Window")) {
                if (tc.getLookup().lookup(IDatabase.class) == 
                        getParentNode().getLookup().lookup(IDatabase.class)){
                    return tc;
                }
            }
        }
        return null;
    }
    
}
