package it.unibas.instcompview.view;

import bart.comparison.InstanceMatchTask;
import it.unibas.instcompview.AutoResizeSwitcher;
import it.unibas.instcompview.Scenario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableCellRenderer;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.Utilities;
import org.openide.util.lookup.Lookups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import speedy.model.algebra.operators.ITupleIterator;
import speedy.model.database.IDatabase;
import speedy.model.database.ITable;
import speedy.model.database.Tuple;
import speedy.model.database.TupleWithTable;

/**
 *
 * @author aurelio.sofia
 */
public class TableMVE extends javax.swing.JPanel implements  MultiViewElement {
    
    private static Logger log = LoggerFactory.getLogger(TableMVE.class);
    private MultiViewElementCallback callback = null;
    private ITable table;
    private List<Tuple> tuples;
    private InstanceMatchTask result;
    private Scenario scenario;
    private String whatDB;
    private ButtonGroup buttonGroup;
    private TableDataModel tableModel;
    private JToolBar toolBar;
    private IDatabase db;
    private Lookup tableLookup;
    
    private final Listener listener = new Listener();
    private Lookup.Result<Scenario> lookupResult;
    
    /**
     * Creates new form TableView
     */
    public TableMVE(Lookup lookup) {
        tableLookup = lookup;
        this.db = lookup.lookup(IDatabase.class);
        this.toolBar = new JToolBar();
        this.table = lookup.lookup(ITable.class);
        this.scenario = lookup.lookup(Scenario.class);
        this.whatDB = lookup.lookup(String.class);
        result = scenario.getResult();
        initComponents();
        this.highlightRadio.setEnabled(false);
        this.nonMatchingRadio.setEnabled(false);
        
        this.highlightRadio.setText("highlight");
        this.nonMatchingRadio.setText("non matching only");
        initDataTable();
        initNormalRadio();
        initButtonGroup();
    }
    
    private void initDataTable(){
        ITupleIterator iterator = table.getTupleIterator();
        if(iterator == null) return;
        if(tuples == null){
            tuples = new ArrayList<>();
        }
        while(iterator.hasNext()){
            tuples.add(iterator.next());
        }
        iterator.close();
        tableModel = new TableDataModel(tuples, null);
        this.dataTable.setModel(tableModel);
        AutoResizeSwitcher.autoResizeSwitcher(dataTable);
    }
    
    private void initButtonGroup(){
        buttonGroup = new ButtonGroup();
        buttonGroup.add(this.normalRadio);
        buttonGroup.add(this.highlightRadio);
        buttonGroup.add(this.nonMatchingRadio);
    }
    
    private void initNormalRadio(){
        this.normalRadio.setSelected(true);
        this.normalRadio.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTable.setModel(tableModel);
                dataTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
                tableModel.updateContent();
            }
        });
        this.normalRadio.setText("normal");
    }

    private void initHighLightRadio(){
        this.highlightRadio.setEnabled(true);
        this.highlightRadio.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTable.setModel(tableModel);
                List<TupleWithTable> twtList = filterTuples();
                tableModel.setNonMatchingTuples(twtList);
                dataTable.setDefaultRenderer(Object.class, new TableCellRenderer(tableModel));
                tableModel.updateContent();
            }
        });
        this.highlightRadio.setText("highlight");
    }
    
    private void initNonMatchingRadio(){
        this.nonMatchingRadio.setEnabled(true);
        this.nonMatchingRadio.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TupleWithTable> twtList = filterTuples();
                dataTable.setModel(new NonMatchingTableModel(twtList));
                dataTable.updateUI();
            }
        });
        this.nonMatchingRadio.setText("non matching only");
    }
    private List<TupleWithTable> filterTuples(){
        List<TupleWithTable> twtList = new ArrayList<>();
        List<TupleWithTable> selectedList;
        if(whatDB.equalsIgnoreCase("LEFT")){
            selectedList = result.getTupleMapping().getLeftNonMatchingTuples();
        } else {
            selectedList = result.getTupleMapping().getRightNonMatchingTuples();
        }
        String tableName = this.table.getName();
        for(TupleWithTable twt : selectedList){
            if(twt.getTable().equalsIgnoreCase(tableName)){
                twtList.add(twt);
            }
        }
        
        return twtList;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        normalRadio = new javax.swing.JRadioButton();
        highlightRadio = new javax.swing.JRadioButton();
        nonMatchingRadio = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        org.openide.awt.Mnemonics.setLocalizedText(normalRadio, org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.normalRadio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(highlightRadio, org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.highlightRadio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nonMatchingRadio, org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.nonMatchingRadio.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(normalRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highlightRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nonMatchingRadio)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(normalRadio))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(highlightRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nonMatchingRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dataTable);
        if (dataTable.getColumnModel().getColumnCount() > 0) {
            dataTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.dataTable.columnModel.title0")); // NOI18N
            dataTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.dataTable.columnModel.title1")); // NOI18N
            dataTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.dataTable.columnModel.title2")); // NOI18N
            dataTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(TableMVE.class, "TableMVE.dataTable.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    @Override
    public JComponent getToolbarRepresentation() {
//        JToolBar jtb = new JToolBar();
//        jtb.setFloatable(false);
//        return jtb;
        return toolBar;
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
        //Every MVC of the same TC must return the same lookup to avoid exceptions
        return Lookups.singleton(db);
    }

    @Override
    public void componentOpened() {
        lookupResult = Utilities.actionsGlobalContext().lookupResult(Scenario.class);
        lookupResult.addLookupListener(listener);
    }

    @Override
    public void componentClosed() {
        lookupResult.removeLookupListener(listener);
    }

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
    
    private class Listener implements LookupListener {
        
        @Override
        public void resultChanged(LookupEvent ev) {
            scenario = tableLookup.lookup(Scenario.class);
            result = scenario.getResult();
            if(result != null){
                initHighLightRadio();
                initNonMatchingRadio();
            }
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JRadioButton highlightRadio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nonMatchingRadio;
    private javax.swing.JRadioButton normalRadio;
    // End of variables declaration//GEN-END:variables
}
