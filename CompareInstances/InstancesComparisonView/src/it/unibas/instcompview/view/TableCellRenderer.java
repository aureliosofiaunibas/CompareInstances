package it.unibas.instcompview.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aurelio.sofia
 */
public class TableCellRenderer extends DefaultTableCellRenderer  {
    
    private TableDataModel model;
    
    public TableCellRenderer(TableDataModel model){
        this.model = model;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(model.getRowColor(row));
        if(isSelected){
            c.setBackground(Color.lightGray);
        }
        return this;
    }
    
    
}
