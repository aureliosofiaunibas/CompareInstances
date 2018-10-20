package it.unibas.instcompview.view;

import java.awt.Image;
import java.io.Serializable;
import org.netbeans.core.spi.multiview.MultiViewDescription;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;

/**
 *
 * @author aurelio.sofia
 */
public class TableMVEDescription implements MultiViewDescription, Serializable{
    
    private String ID;
    private String displayName;
    private Lookup lookup;

    public TableMVEDescription(String ID, String displayName, Lookup lookup) {
        this.ID = ID;
        this.displayName = displayName;
        this.lookup = lookup;
    }
    
    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }
    @Override
    public String getDisplayName() {
        return this.displayName;
    }
    @Override
    public Image getIcon() {
        return null;
    }
    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    @Override
    public String preferredID() {
        return this.ID;
    }

    @Override
    public MultiViewElement createElement() {
        return new TableMVE(lookup);
    }
    
    
}
