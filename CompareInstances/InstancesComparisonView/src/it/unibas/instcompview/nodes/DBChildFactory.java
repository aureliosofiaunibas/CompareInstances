package it.unibas.instcompview.nodes;

import it.unibas.instcompview.DBinfo;
import it.unibas.instcompview.AppConstants;
import it.unibas.instcompview.resources.Resources;
import it.unibas.instcompview.NotificationDialogs;
import it.unibas.instcompview.Scenario;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import speedy.model.database.IDatabase;
import speedy.model.database.dbms.DBMSDB;
import speedy.model.database.mainmemory.MainMemoryDB;
import speedy.persistence.DAODBMSDatabase;
import speedy.persistence.DAOMainMemoryDatabase;

/**
 *
 * @author aurelio.sofia
 */
public class DBChildFactory extends ChildFactory<IDatabase>{
    
    private final Scenario scenario;
    private boolean isLeft = true;
    
    public DBChildFactory(Scenario bean) {
        this.scenario = bean;
        try{
            connectToDBs();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
    
    private void connectToDBs(){
        IDatabase dbLeft = null;
        IDatabase dbRight = null;
        if(scenario.getDbType().equals(AppConstants.DBTYPE_MAIN_MEMORY_CVS)){
            try{
            dbLeft = loadMainMemory(scenario.getLeftDBRetrieveInfo(), "LEFT");
            }catch(Exception e){
                Exceptions.printStackTrace(e);
                NotificationDialogs.notifyError("Left DB url is invalid\n" + e);
                return;
            }
            try{
            dbRight = loadMainMemory(scenario.getRightDBRetrieveInfo(), "RIGHT");
            }catch(Exception ex){
                Exceptions.printStackTrace(ex);
                NotificationDialogs.notifyError("Right DB url is invalid\n" + ex);
                return;
            }
        }
        if(scenario.getDbType().equals(AppConstants.DBTYPE_DB)){
            dbLeft  = loadDB(scenario.getLeftDBRetrieveInfo());
            dbRight  = loadDB(scenario.getRightDBRetrieveInfo());
        }
        
        scenario.setLeftDB(dbLeft);
        scenario.setRightDB(dbRight);
    }
    
    @Override
    protected boolean createKeys(List<IDatabase> toPopulate) {
        toPopulate.add(scenario.getLeftDB());
        toPopulate.add(scenario.getRightDB());
        return true;
    }

    @Override
    protected Node createNodeForKey(IDatabase key) {
        DBNode node = null;
        try {
            if(isLeft){
                node = new DBNode(key, scenario, "LEFT");
            } else {
                node = new DBNode(key, scenario, "RIGHT");
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        
        isLeft = false;
        return node;
    }
    
    @Override
    protected Node createWaitNode() {
        AbstractNode waitNode = new AbstractNode(Children.LEAF);
        waitNode.setDisplayName("Loading...");
        waitNode.setIconBaseWithExtension(Resources.RESOURCES_ICONS_BASE + "loading.png");
        return waitNode;
    }
    
    
    
    private IDatabase loadMainMemory(DBinfo info, String string){
        DAOMainMemoryDatabase daoDatabase = new DAOMainMemoryDatabase();
        MainMemoryDB database = daoDatabase.loadCSVDatabase(info.getInstancePath(),
                info.getSeparator(), null, info.isConvertSkolemInHash(), true);
        database.getDataSource().getSchema().setLabel(database.getName());
        return database;
    }
    
    private IDatabase loadDB(DBinfo info){
        DAODBMSDatabase daoDatabase = new DAODBMSDatabase();
        DBMSDB database = daoDatabase.loadDatabase(info.getDriver(),
                info.getUri(), info.getSchemaName(), info.getUsername(),
                info.getPassword());
        return database;
    }
}
