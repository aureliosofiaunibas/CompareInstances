package it.unibas.instcompview.view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import speedy.model.database.Tuple;
import speedy.model.database.TupleWithTable;

/**
 *
 * @author aurelio.sofia
 */
public class NonMatchingTableModel extends AbstractTableModel{
    
    private List<TupleWithTable> nonMatchingTuples;
    
    public NonMatchingTableModel(List<TupleWithTable> nonMatchingTuples) {
        this.nonMatchingTuples = nonMatchingTuples;
    }
    
    
    @Override
    public int getRowCount() {
        if(nonMatchingTuples == null || nonMatchingTuples.isEmpty()) return 0;
        return nonMatchingTuples.size();
    }

    @Override
    public int getColumnCount() {
        if(nonMatchingTuples == null || nonMatchingTuples.isEmpty()) return 0;
        return nonMatchingTuples.get(0).getTuple().getCells().size();
    }
    
    @Override
    public String getColumnName(int column) {
        if(nonMatchingTuples == null)return null;
        return nonMatchingTuples.get(0).getTuple().getCells().get(column).getAttribute();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tuple tuple = nonMatchingTuples.get(rowIndex).getTuple();
        if(tuple.getCells().get(columnIndex).getAttribute().equalsIgnoreCase("oid")){
                return tuple.getCells().get(columnIndex).getTupleOID().getNumericalValue();
        }
        return tuple.getCells().get(columnIndex).getValue();
    }
    
    public void updateContent(){
        fireTableDataChanged();
    }
}
