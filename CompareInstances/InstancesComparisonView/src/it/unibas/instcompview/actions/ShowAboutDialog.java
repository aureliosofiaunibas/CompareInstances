/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.instcompview.actions;

import it.unibas.instcompview.view.AboutDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Help",
        id = "it.unibas.instcompview.actions.ShowAboutDialog"
)
@ActionRegistration(
        displayName = "#CTL_ShowAboutDialog"
)
@ActionReference(path = "Menu/Help", position = 1600)
@Messages("CTL_ShowAboutDialog=About")
/**
 *
 * @author aurelio.sofia
 */
public final class ShowAboutDialog implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame mainFrame = (JFrame) WindowManager.getDefault().getMainWindow();
        AboutDialog dialog = new AboutDialog(mainFrame, true);
        dialog.showDialog();
    }
}
