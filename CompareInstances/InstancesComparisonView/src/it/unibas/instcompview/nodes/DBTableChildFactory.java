package it.unibas.instcompview.nodes;

import it.unibas.instcompview.resources.Resources;
import it.unibas.instcompview.Scenario;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import speedy.model.database.IDatabase;
import speedy.model.database.ITable;

/**
 *
 * @author aurelio.sofia
 */
public class DBTableChildFactory extends ChildFactory.Detachable<ITable>{
    
    private final IDatabase database;
    private Scenario scenario;
    private String whatDB;

    public DBTableChildFactory(IDatabase database, Scenario scenario, String whatDB) {
        this.database = database;
        this.scenario = scenario;
        this.whatDB = whatDB;
    }
    
    @Override
    protected boolean createKeys(List<ITable> toPopulate) {
        for(String tableName : database.getTableNames()){
            toPopulate.add(database.getTable(tableName));
        }
        return true;
    }
    
    @Override
    protected Node createWaitNode() {
        AbstractNode waitNode = new AbstractNode(Children.LEAF);
        waitNode.setDisplayName("Loading...");
        waitNode.setIconBaseWithExtension(Resources.RESOURCES_ICONS_BASE + "loading.png");
        return waitNode;
    }

    @Override
    protected Node createNodeForKey(ITable key) {
        TableNode node = new TableNode(key, scenario, whatDB);
        return node;
    }
    
    
    
}
