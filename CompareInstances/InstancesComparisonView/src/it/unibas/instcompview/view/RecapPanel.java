package it.unibas.instcompview.view;

import javax.swing.JLabel;

/**
 *
 * @author aurelio.sofia
 */
public class RecapPanel extends javax.swing.JPanel {

    /**
     * Creates new form RecapPanel
     */
    public RecapPanel() {
        initComponents();
        this.changeLabel.setVisible(false);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public JLabel getStrategyLabel() {
        return strategyLabel;
    }

    public void setStrategyLabel(JLabel strategyLabel) {
        this.strategyLabel = strategyLabel;
    }

    public void setConvertSkolemLabelText(String s) {
        this.convertSkolemLabel.setText(s);
    }

    public void setForceLabelText(String s) {
        this.forceLabel.setText(s);
    }

    public void setFunctionalLabelText(String s) {
        this.functionalLabel.setText(s);
    }

    public void setInjectiveLabelText(String s) {
        this.injectiveLabel.setText(s);
    }

    public void setkLabelText(String s) {
        this.kLabel.setText(s);
    }

    public void setNullPrefixesLabelText(String s) {
        this.nullPrefixesLabel.setText(s);
    }

    public void setStopLabelText(String s) {
        this.stopLabel.setText(s);
    }

    public void setTwoWayLabelText(String s) {
        this.twoWayLabel.setText(s);
    }

    public JLabel getNmNumberLeftLabel() {
        return nmNumberLeftLabel;
    }

    public void setNmNumberLeftLabelText(String s) {
        this.nmNumberLeftLabel.setText(s);
    }

    public JLabel getNmNumberlRightLabel() {
        return nmNumberRightLabel;
    }

    public void setNmNumberRightLabelText(String s) {
        this.nmNumberRightLabel.setText(s);
    }

    public JLabel getChangeLabel() {
        return changeLabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelF = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        strategyLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        functionalLabel = new javax.swing.JLabel();
        injectiveLabel = new javax.swing.JLabel();
        kLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nullPrefixesLabel = new javax.swing.JLabel();
        forceLabel = new javax.swing.JLabel();
        stopLabel = new javax.swing.JLabel();
        twoWayLabel = new javax.swing.JLabel();
        convertSkolemLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nmNumberRightLabel = new javax.swing.JLabel();
        nmNumberLeftLabel = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));

        jLabelF.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabelF, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabelF.text")); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel2.text")); // NOI18N

        jLabel5.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel5.text")); // NOI18N

        jLabel7.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel7.text")); // NOI18N

        jLabel10.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel10.text")); // NOI18N

        jLabel9.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel9.text")); // NOI18N

        jLabel11.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel11.text")); // NOI18N

        jLabel12.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel12.text")); // NOI18N

        jLabel6.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel6.text")); // NOI18N

        strategyLabel.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(strategyLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.strategyLabel.text")); // NOI18N

        jLabel4.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel4.text")); // NOI18N

        scoreLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(scoreLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.scoreLabel.text")); // NOI18N
        scoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        functionalLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        functionalLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(functionalLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.functionalLabel.text")); // NOI18N

        injectiveLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        injectiveLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(injectiveLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.injectiveLabel.text")); // NOI18N

        kLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(kLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.kLabel.text")); // NOI18N

        jLabel8.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel8.text")); // NOI18N

        nullPrefixesLabel.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(nullPrefixesLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.nullPrefixesLabel.text")); // NOI18N

        forceLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        forceLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(forceLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.forceLabel.text")); // NOI18N

        stopLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        stopLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(stopLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.stopLabel.text")); // NOI18N

        twoWayLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        twoWayLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(twoWayLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.twoWayLabel.text")); // NOI18N

        convertSkolemLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        convertSkolemLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(convertSkolemLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.convertSkolemLabel.text")); // NOI18N

        jLabel13.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel13.text")); // NOI18N

        jLabel14.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel14.text")); // NOI18N

        jLabel15.setForeground(new java.awt.Color(0, 128, 128));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.jLabel15.text")); // NOI18N

        nmNumberRightLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(nmNumberRightLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.nmNumberRightLabel.text")); // NOI18N

        nmNumberLeftLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(nmNumberLeftLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.nmNumberLeftLabel.text")); // NOI18N

        changeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        changeLabel.setForeground(new java.awt.Color(255, 165, 0));
        org.openide.awt.Mnemonics.setLocalizedText(changeLabel, org.openide.util.NbBundle.getMessage(RecapPanel.class, "RecapPanel.changeLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(60, 60, 60)
                                .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nullPrefixesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(nmNumberLeftLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nmNumberRightLabel))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabelF)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(injectiveLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(functionalLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(strategyLabel)
                                    .addComponent(kLabel))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(convertSkolemLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(stopLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(twoWayLabel))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(forceLabel))))))
                            .addComponent(jSeparator1)
                            .addComponent(jLabel13)
                            .addComponent(jSeparator3)
                            .addComponent(changeLabel))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelF)
                    .addComponent(jLabel10)
                    .addComponent(functionalLabel)
                    .addComponent(forceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(injectiveLabel)
                    .addComponent(twoWayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(kLabel)
                    .addComponent(stopLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(convertSkolemLabel)
                    .addComponent(strategyLabel)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nullPrefixesLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(nmNumberLeftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nmNumberRightLabel))
                .addGap(18, 18, 18)
                .addComponent(changeLabel)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeLabel;
    private javax.swing.JLabel convertSkolemLabel;
    private javax.swing.JLabel forceLabel;
    private javax.swing.JLabel functionalLabel;
    private javax.swing.JLabel injectiveLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelF;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel kLabel;
    private javax.swing.JLabel nmNumberLeftLabel;
    private javax.swing.JLabel nmNumberRightLabel;
    private javax.swing.JLabel nullPrefixesLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel stopLabel;
    private javax.swing.JLabel strategyLabel;
    private javax.swing.JLabel twoWayLabel;
    // End of variables declaration//GEN-END:variables
}
