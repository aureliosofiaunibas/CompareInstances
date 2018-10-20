package it.unibas.instcompview.view;

import it.unibas.instcompview.NotificationDialogs;
import it.unibas.instcompview.actions.CreateScenarioAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

/**
 *
 * @author aurelio.sofia
 */
public class NewScenarioDialog extends javax.swing.JDialog {
    
    private List<JTextField> fields = new ArrayList<>();
    private TextValidator textValidator = new TextValidator();
    
    /**
     * Creates new form NewScenarioDialog
     */
    public NewScenarioDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initButtons();
        initButtonEnabling();
        initValidation();
    }
    
    private void initButtonEnabling(){
        fields.add(scenarioTextField);
        fields.add(kField);
        fields.add(bestScoreField);
        fields.add(leftFolderField);
        fields.add(rightFolderField);
        for(JTextField tf : fields){
            tf.getDocument().addDocumentListener(textValidator);
        }
    }
    
    private void initValidation(){
        ValidationPanel panel = new ValidationPanel();
        panel.setInnerComponent(containerPanel);
        ValidationGroup group = panel.getValidationGroup();
        group.add(scenarioTextField, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(kField, StringValidators.REQUIRE_NON_EMPTY_STRING,
                StringValidators.REQUIRE_VALID_NUMBER);
        group.add(bestScoreField, StringValidators.REQUIRE_NON_EMPTY_STRING,
                StringValidators.REQUIRE_VALID_NUMBER);
        this.setContentPane(panel);
    }
    
    public void showDialog() {
        this.pack();
        setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }
    
    public String getLeftFolder(){
        return this.leftFolderField.getText();
    }
    
    public String getRighttFolder(){
        return this.rightFolderField.getText();
    }
    
    public String getScenarioName(){
        String s = "";
        try{
        s = this.scenarioTextField.getText();
        } catch(NullPointerException npe) {
            return "";
        }
        return s;
    }
    
    public boolean isSignature(){
        return this.isSignatureRadio.isSelected();
    }
    
    public boolean isFunctional(){
        return this.functionalCheck.isSelected();
    }
    
    public boolean isInjective(){
        return this.injectiveCheck.isSelected();
    }
    
    public boolean doesItStop(){
        return this.stopCheck.isSelected();
    }
    
    public boolean isTwoWay(){
        return this.twoWayCheck.isSelected();
    }
    
    public String getK(){
        return this.kField.getText();
    }
    
    public String getBestScoreThreshold(){
        return this.bestScoreField.getText();
    }
    
    public boolean convertSkolem(){
        return this.skolemCheck.isSelected();
    }
    
    public boolean forceExaustiveSearch(){
        return this.exaustiveSearchCheck.isSelected();
    }
    
    private void initButtons(){
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(isSignatureRadio);
        buttonGroup.add(isBruteforceRadio);
        isSignatureRadio.setSelected(true);
        
        functionalCheck.setSelected(true);
        injectiveCheck.setSelected(true);
        twoWayCheck.setSelected(true);
        
        this.selectFolderL.setAction(setButtonAction(leftFolderField));
        this.selectFolderL.setText("Select Folder");
        this.selectFolderR.setAction(setButtonAction(rightFolderField));
        this.selectFolderR.setText("Select Folder");
        this.createButton.setAction(new CreateScenarioAction(this));
        this.createButton.setText("Create Scenario");
        this.createButton.setEnabled(false);
    }
     
    private Action setButtonAction(final JTextField field){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String folder = getFolder();
                if(folder.isEmpty()){
                    NotificationDialogs.notifyError("You need to select a folder");
                    return;
                }
                field.setText(folder);
            }
        };
    }
    
    private String getFolder(){
        File home = new File(System.getProperty("user.home"));
        FileChooserBuilder chooser = new FileChooserBuilder("DB_FOLDER_LOADER");
        chooser.setDefaultWorkingDirectory(home);
        chooser.setTitle("Load folder")
               .setApproveText("Load")
               .setDirectoriesOnly(true)
               .setAcceptAllFileFilterUsed(false);
        
        File selected = chooser.showOpenDialog();
        
        if(selected == null){
            return "";
        }
        String folder = "";
        try {
            folder = FileUtil.toFileObject(selected).getPath();
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            folder = "";
        }
        
        return folder;
    }
    
    private class TextValidator implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            boolean isEnabled = true;
            for(JTextField tf : fields){
                if(tf.getText().isEmpty() || tf.getText().equalsIgnoreCase("no folder selected")){
                    isEnabled = false;
                }
            }
            
            createButton.setEnabled(isEnabled);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        containerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scenarioTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        selectFolderL = new javax.swing.JButton();
        jlabel = new javax.swing.JLabel();
        selectFolderR = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        isSignatureRadio = new javax.swing.JRadioButton();
        isBruteforceRadio = new javax.swing.JRadioButton();
        functionalCheck = new javax.swing.JCheckBox();
        injectiveCheck = new javax.swing.JCheckBox();
        twoWayCheck = new javax.swing.JCheckBox();
        stopCheck = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        kField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bestScoreField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        leftFolderField = new javax.swing.JTextField();
        rightFolderField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        skolemCheck = new javax.swing.JCheckBox();
        exaustiveSearchCheck = new javax.swing.JCheckBox();

        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.title")); // NOI18N
        setModal(true);
        setName("newScenario"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel1.text")); // NOI18N

        scenarioTextField.setText(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.scenarioTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(selectFolderL, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.selectFolderL.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jlabel, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jlabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(selectFolderR, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.selectFolderR.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(isSignatureRadio, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.isSignatureRadio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(isBruteforceRadio, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.isBruteforceRadio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(functionalCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.functionalCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(injectiveCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.injectiveCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(twoWayCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.twoWayCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(stopCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.stopCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel4.text")); // NOI18N

        kField.setText(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.kField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel5.text")); // NOI18N

        bestScoreField.setText(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.bestScoreField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createButton, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.createButton.text")); // NOI18N

        leftFolderField.setText(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.leftFolderField.text")); // NOI18N

        rightFolderField.setText(org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.rightFolderField.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 116, 0));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(skolemCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.skolemCheck.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(exaustiveSearchCheck, org.openide.util.NbBundle.getMessage(NewScenarioDialog.class, "NewScenarioDialog.exaustiveSearchCheck.text")); // NOI18N

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bestScoreField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createButton))
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jlabel))
                        .addGap(20, 20, 20)
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leftFolderField, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(rightFolderField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFolderL)
                            .addComponent(selectFolderR)))
                    .addComponent(jLabel6)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scenarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(isSignatureRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isBruteforceRadio))
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skolemCheck)
                            .addComponent(functionalCheck))
                        .addGap(18, 18, 18)
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(injectiveCheck)
                            .addComponent(stopCheck))
                        .addGap(18, 18, 18)
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exaustiveSearchCheck)
                            .addComponent(twoWayCheck))))
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(scenarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftFolderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(selectFolderL))
                .addGap(18, 18, 18)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel)
                    .addComponent(selectFolderR)
                    .addComponent(rightFolderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(isSignatureRadio)
                    .addComponent(isBruteforceRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(functionalCheck)
                    .addComponent(injectiveCheck)
                    .addComponent(twoWayCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skolemCheck)
                    .addComponent(exaustiveSearchCheck)
                    .addComponent(stopCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bestScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewScenarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewScenarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewScenarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewScenarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewScenarioDialog dialog = new NewScenarioDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bestScoreField;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JCheckBox exaustiveSearchCheck;
    private javax.swing.JCheckBox functionalCheck;
    private javax.swing.JCheckBox injectiveCheck;
    private javax.swing.JRadioButton isBruteforceRadio;
    private javax.swing.JRadioButton isSignatureRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField kField;
    private javax.swing.JTextField leftFolderField;
    private javax.swing.JTextField rightFolderField;
    private javax.swing.JTextField scenarioTextField;
    private javax.swing.JButton selectFolderL;
    private javax.swing.JButton selectFolderR;
    private javax.swing.JCheckBox skolemCheck;
    private javax.swing.JCheckBox stopCheck;
    private javax.swing.JCheckBox twoWayCheck;
    // End of variables declaration//GEN-END:variables
}
