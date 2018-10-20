package it.unibas.instcompview.nodes;

import it.unibas.centrallookup.CentralLookup;
import it.unibas.instcompview.resources.Resources;
import it.unibas.instcompview.Scenario;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.Action;
import org.openide.actions.DeleteAction;
import org.openide.actions.PropertiesAction;
import org.openide.awt.Actions;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author aurelio.sofia
 */
public class ScenarioNode extends BeanNode<Scenario> implements Serializable{
    
    public ScenarioNode(Scenario bean) throws IntrospectionException {
        super(bean, Children.create(new DBChildFactory(bean), true), Lookups.singleton(bean));
        setDisplayName(bean.getScenario());
        setIconBaseWithExtension(Resources.NODES_ICONS_BASE + "scenario.png");
    }
    

    @Override
    public Action[] getActions(boolean context) {
        return new Action[]{
            SystemAction.get(DeleteAction.class),
            SystemAction.get(PropertiesAction.class)
        };
    }
    
    
    @Override
    public Action getPreferredAction() {
        return Actions.forID("File", "it.unibas.instcompview.actions.CompareInstances");
    }
    
    @Override
    public boolean canDestroy() {
        return true;
    }
    
    @Override
    public void destroy() throws IOException {
        CentralLookup.getDefault().remove(this.getBean());
        fireNodeDestroyed();
    }
}
