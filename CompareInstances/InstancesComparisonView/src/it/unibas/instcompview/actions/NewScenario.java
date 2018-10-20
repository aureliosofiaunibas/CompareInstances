package it.unibas.instcompview.actions;

import it.unibas.instcompview.resources.Resources;
import it.unibas.instcompview.view.NewScenarioDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
        category = "File",
        id = "it.unibas.instcompview.actions.NewScenario"
)
@ActionRegistration(
        iconBase = Resources.RESOURCES_ICONS_BASE + "new_scenario.png",
        displayName = "#CTL_NewScenario"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 2577),
    @ActionReference(path = "Toolbars/File", position = 450) 
})
@Messages("CTL_NewScenario=New Scenario")
/**
 *
 * @author aurelio.sofia
 */
public final class NewScenario implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame mainFrame = (JFrame) WindowManager.getDefault().getMainWindow();
        NewScenarioDialog dialog = new NewScenarioDialog(mainFrame, true);
        dialog.showDialog();
    }
}
