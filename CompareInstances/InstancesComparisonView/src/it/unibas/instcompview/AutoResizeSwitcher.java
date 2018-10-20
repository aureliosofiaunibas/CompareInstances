package it.unibas.instcompview;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTable;

/**
 *
 * @author aurelio.sofia
 */
public class AutoResizeSwitcher {
    
    private JTable jTable;

    public AutoResizeSwitcher(JTable jTable) {
        this.jTable = jTable;
    }
    
    public static void autoResizeSwitcher(final JTable jTable){
        jTable.getParent().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                if (jTable.getPreferredSize().width < jTable.getParent().getWidth()) {
                    jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                } else {
                    jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                }
            }
        });
    }
    
}
