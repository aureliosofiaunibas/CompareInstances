package it.unibas.instcompview.nodes;

import it.unibas.centrallookup.CentralLookup;
import it.unibas.instcompview.Scenario;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.nodes.NodeEvent;
import org.openide.nodes.NodeListener;
import org.openide.nodes.NodeMemberEvent;
import org.openide.nodes.NodeReorderEvent;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author aurelio.sofia
 */
public class ScenarioChildFactory extends ChildFactory.Detachable<Scenario>
        implements LookupListener, NodeListener {

    Lookup.Result<Scenario> scenarioResult;
    
    @Override
    protected boolean createKeys(List<Scenario> toPopulate) {
        toPopulate.addAll(scenarioResult.allInstances());
        return true;
    }

    @Override
    protected Node createNodeForKey(Scenario key) {
        ScenarioNode node = null;
        try{
            node = new ScenarioNode(key);
            node.addNodeListener(this);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return node;
    }

    @Override
    public void resultChanged(LookupEvent ev) {
        refresh(true);
    }

    @Override
    protected void removeNotify() {
        scenarioResult.removeLookupListener(this);
    }

    @Override
    protected void addNotify() {
        scenarioResult = CentralLookup.getDefault().lookupResult(Scenario.class);
        scenarioResult.addLookupListener(this);
    }

    @Override
    public void nodeDestroyed(NodeEvent ev) {
        refresh(true);
    }

    @Override public void childrenAdded(NodeMemberEvent nme) {}
    @Override public void childrenRemoved(NodeMemberEvent nme) {
        refresh(true);
    }
    @Override public void childrenReordered(NodeReorderEvent nre) {}
    @Override public void propertyChange(PropertyChangeEvent evt) {} 
    
}
