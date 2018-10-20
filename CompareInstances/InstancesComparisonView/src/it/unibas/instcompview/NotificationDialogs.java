package it.unibas.instcompview;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author aurelio.sofia
 */
public class NotificationDialogs {
    
    
    
    public static void notifyError(String msg){
        NotifyDescriptor nd = new NotifyDescriptor(msg, "Attention",
                NotifyDescriptor.DEFAULT_OPTION, NotifyDescriptor.ERROR_MESSAGE, 
                null, null);
        DialogDisplayer.getDefault().notify(nd);
    }
    
}
