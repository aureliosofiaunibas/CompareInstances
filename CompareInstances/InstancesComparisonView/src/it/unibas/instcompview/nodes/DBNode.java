package it.unibas.instcompview.nodes;

import it.unibas.instcompview.Scenario;
import it.unibas.instcompview.resources.Resources;
import java.io.Serializable;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import speedy.model.database.IDatabase;

/**
 *
 * @author aurelio.sofia
 */
public class DBNode extends AbstractNode implements Serializable{
    
    private InstanceContent instanceContent = new InstanceContent();
    
    public DBNode(IDatabase db, Scenario scenario, String whatDB){
        this(db, scenario, whatDB, new InstanceContent());
        setName(db.getName());
        setDisplayName(whatDB + ": " + db.getName());
        setIconBaseWithExtension(Resources.NODES_ICONS_BASE + "database.png");
    }
    
    private DBNode(IDatabase db,Scenario scenario, String whatDB, InstanceContent ic){
        super(Children.create(new DBTableChildFactory(db, scenario, whatDB), true), 
                new AbstractLookup(ic));
        ic.add(db);
        ic.add(scenario);
        ic.add(whatDB);
        this.instanceContent = ic;
    }
}
