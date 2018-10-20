package it.unibas.instcompview.view;

import bart.comparison.ValueMapping;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import speedy.model.database.IValue;

/**
 *
 * @author aurelio.sofia
 */
public class KeyValueMappingTableModel extends AbstractTableModel{
    
    private ValueMapping keyValueMap;
    private List<IValue> keys;
    private List<IValue> values;

    public KeyValueMappingTableModel(ValueMapping keyValueMap) {
        this.keyValueMap = keyValueMap;
        keys = new ArrayList<>(this.keyValueMap.getKeys());
        values = new ArrayList<>(this.keyValueMap.getValues());
    }
    
    @Override
    public int getRowCount() {
        if(keyValueMap == null || keyValueMap.isEmpty()) return 0;
        return this.keyValueMap.getKeys().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0){
            return "KEY";
        }
            return "VALUE";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return keys.get(rowIndex);
        }
        return values.get(rowIndex); 
    }
    
    public void updateTable(){
        this.fireTableDataChanged();
    }
}
