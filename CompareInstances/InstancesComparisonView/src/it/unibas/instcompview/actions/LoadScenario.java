package it.unibas.instcompview.actions;

import it.unibas.instcompview.AppConstants;
import it.unibas.instcompview.NotificationDialogs;
import it.unibas.instcompview.api.ILoadScenario;
import it.unibas.instcompview.resources.Resources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ActionID(
        category = "File",
        id = "it.unibas.instcompview.actions.LoadScenario"
)
@ActionRegistration(
        iconBase = Resources.RESOURCES_ICONS_BASE + "load_scenario.png",
        displayName = "#CTL_LoadScenario"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 2550, separatorAfter = 2575),
    @ActionReference(path = "Toolbars/File", position = 400)
})
@Messages("CTL_LoadScenario=&Load Scenario...")
/**
 *
 * @author aurelio.sofia
 */
public final class LoadScenario implements ActionListener {
    
    private static Logger log = LoggerFactory.getLogger(LoadScenario.class);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        File home = new File(System.getProperty("user.home"));
        FileChooserBuilder chooser = new FileChooserBuilder("SCENARIO_LOADER");
        chooser.setDefaultWorkingDirectory(home);
        chooser.setTitle("Load Scenario")
               .setApproveText("Load")
               .setFilesOnly(true)
               .setAcceptAllFileFilterUsed(false)
               .addFileFilter(new FileNameExtensionFilter("Properties file (*.properties)", 
                       "properties"));
        
        File selected = chooser.showOpenDialog();
        
        if(selected == null){
            return;
        }
        
        if(FileUtil.toFileObject(selected).isFolder()){
            NotificationDialogs.notifyError("Select a file");
        }
        
        if(!validFile(selected)){
            String msg = "The selected .properties file needs to have at least "
                    + "the following properties:\n"
                + "scenario\nleftDB\nrightDB\nstrategy\nfunctional\ninjective\nK";
            NotificationDialogs.notifyError(msg);
            return;
        }
        
        ILoadScenario load = Lookup.getDefault().lookup(ILoadScenario.class);
        
        try{
            load.load(FileUtil.toFileObject(selected));
        } catch (Exception ex){
            Exceptions.printStackTrace(ex);
        }
    }
    
    private boolean validFile(File file){
        boolean valid = false;
        
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            if(properties.getProperty(AppConstants.SCENARIO).isEmpty()
               || properties.getProperty(AppConstants.LEFT_DB).isEmpty()
               || properties.getProperty(AppConstants.RIGHT_DB).isEmpty()
               || properties.getProperty(AppConstants.STRATEGY).isEmpty()
               || properties.getProperty(AppConstants.FUNCTIONAL).isEmpty()
               || properties.getProperty(AppConstants.INJECTIVE).isEmpty()
               || properties.getProperty(AppConstants.K).isEmpty()){
                valid = false;
            } else {
                valid = true;
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return valid;
    }
}
