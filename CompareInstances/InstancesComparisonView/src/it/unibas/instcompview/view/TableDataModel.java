package it.unibas.instcompview.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import speedy.model.database.Tuple;
import speedy.model.database.TupleWithTable;

/**
 *
 * @author aurelio.sofia
 */
public class TableDataModel extends AbstractTableModel{
    private static Logger log = LoggerFactory.getLogger(TableDataModel.class);
    private List<Tuple> tuples;
    private List<TupleWithTable> nonMatchingTuples;
    private List<Integer> oidPosition = new ArrayList<>();
    
    public TableDataModel(List<Tuple> tuples, List<TupleWithTable> nonMatchingTuples) {
        this.tuples = tuples;
        this.nonMatchingTuples = nonMatchingTuples;
    }
    
    public Color getRowColor(int i){
        if(oidPosition.contains(i)){
            return Color.ORANGE;
        }
        return null;
    }
    
    private void isNonMatching(){
        for(TupleWithTable twt : nonMatchingTuples){
            for(int i = 0; i < tuples.size(); i++){
                if(Objects.equals(twt.getTuple().getOid().getNumericalValue(), tuples.get(i).getOid().getNumericalValue())){
                    oidPosition.add(i);
                    break;
                }
            }
        }
    }
    
    public void setNonMatchingTuples(List<TupleWithTable> nonMatchingTuples){
        this.nonMatchingTuples = nonMatchingTuples;
        isNonMatching();
    }
    
    public List<Integer> getOidPosition(){
        if(nonMatchingTuples == null) return null;
        if(oidPosition != null){
            return oidPosition;
        }
        isNonMatching();
        return oidPosition;
    }
    
    @Override
    public int getRowCount() {
        if(tuples == null) return 0;
        return tuples.size();
    }

    @Override
    public int getColumnCount() {
        if(tuples == null) return 0;
        return tuples.get(0).getCells().size();
    }

    @Override
    public String getColumnName(int column) {
        if(tuples == null)return null;
        //return table.getAttributes().get(column).getName();
        return tuples.get(0).getCells().get(column).getAttribute();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tuple tuple = tuples.get(rowIndex);
        if(tuple.getCells().get(columnIndex).getAttribute().equalsIgnoreCase("oid")){
                return tuple.getCells().get(columnIndex).getTupleOID().getNumericalValue();
        }
        return tuple.getCells().get(columnIndex).getValue();
    }
    
    public void updateContent(){
        fireTableDataChanged();
    }
}
