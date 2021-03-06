package it.unibas.instcompview.view;

import bart.comparison.InstanceMatchTask;
import it.unibas.instcompview.Scenario;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;
import org.openide.windows.TopComponent;

/**
 *
 * @author aurelio.sofia
 */
@MultiViewElement.Registration(
        displayName = "#LBL_KeyValueMappingMVE",
        mimeType = "application/x-comparison",
        persistenceType = TopComponent.PERSISTENCE_NEVER,
        preferredID = "KeyValueMappingMVE",
        position = 30)
@NbBundle.Messages("LBL_KeyValueMappingMVE=Value Mappings")
public class KeyValueMappingMVE extends javax.swing.JPanel implements MultiViewElement {
    
    private MultiViewElementCallback callback = null;
    private final InstanceMatchTask result;
    private final Scenario scenario;
    
    /**
     * Creates new form KeyValueMappingMVE
     */
    public KeyValueMappingMVE(Lookup lookup) {
        this.scenario = lookup.lookup(Scenario.class);
        this.result = scenario.getResult();
        initComponents();
    }
    
    private void initVMDKeyValueGraph(){
        VMDKeyValueMappingGraph vmd = new VMDKeyValueMappingGraph(result.getTupleMapping().getLeftToRightValueMapping(), 
                result.getTupleMapping().getRightToLeftValueMapping());
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(vmd.createView());
        this.keyValueTabbedPane.add("Mapping Graph", jsp);
        vmd.invokeLayout();
    }
    
    private void initKeyValueMappingPanel(){
        KeyValueMappingPanel panel = new KeyValueMappingPanel(result.getTupleMapping().getValueMappings());
        this.keyValueTabbedPane.add("Mapping Table", panel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keyValueTabbedPane = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(keyValueTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(keyValueTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    @Override
    public JComponent getToolbarRepresentation() {
        JToolBar jtb = new JToolBar();
        jtb.setFloatable(false);
        return jtb;
    }

    @Override
    public Action[] getActions() {
        if(callback != null)   {
            return callback.createDefaultActions();
        }
        Action[] a = {};
        return a;
    }

    @Override
    public Lookup getLookup() {
        return Lookups.singleton(scenario);
    }

     @Override
    public void componentOpened() {
        initKeyValueMappingPanel();
        try{
        initVMDKeyValueGraph();
        } catch(Exception e){
            Exceptions.printStackTrace(e);
        }
    }

    @Override
    public void componentClosed() {}

    @Override
    public void componentShowing() {}

    @Override
    public void componentHidden() {}

    @Override
    public void componentActivated() {
    }

    @Override
    public void componentDeactivated() {}

    @Override
    public UndoRedo getUndoRedo() {
        return UndoRedo.NONE;
    }

    @Override
    public void setMultiViewCallback(MultiViewElementCallback callback) {
        this.callback = callback;
    }

    @Override
    public CloseOperationState canCloseElement() {
        return CloseOperationState.STATE_OK;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane keyValueTabbedPane;
    // End of variables declaration//GEN-END:variables
}
