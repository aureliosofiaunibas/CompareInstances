package it.unibas.instcompview.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import speedy.model.database.TupleWithTable;

/**
 *
 * @author aurelio.sofia
 */
public class MappingTableModel extends AbstractTableModel{
    
    private List<TupleWithTable> list = new ArrayList<>();
    
    public MappingTableModel(List<TupleWithTable> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        if(list == null || list.isEmpty()){
            return 0;
        }
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        if(list.get(0).getTuple().getCells() == null){
            return 0;
        }
        return list.get(0).getTuple().getCells().size();
    }

    @Override
    public String getColumnName(int column) {
        return list.get(0).getTuple().getCells().get(column).getAttribute();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TupleWithTable twt = list.get(rowIndex);
        if(twt.getTuple().getCells().get(columnIndex).getAttribute().equalsIgnoreCase("oid")){
            return twt.getTuple().getOid().getNumericalValue();
        }
        return twt.getTuple().getCells().get(columnIndex).getValue();
    }
    
}
