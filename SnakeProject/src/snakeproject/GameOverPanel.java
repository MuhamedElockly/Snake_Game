package snakeproject;

public class GameOverPanel extends javax.swing.JPanel {
    
    private DrawPanel drawPanel;
    
    public GameOverPanel() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButtonTryAgain = new javax.swing.JToggleButton();
        jToggleButtonHome = new javax.swing.JToggleButton();

        jToggleButtonTryAgain.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jToggleButtonTryAgain.setText("Try Again");
        jToggleButtonTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonTryAgainActionPerformed(evt);
            }
        });

        jToggleButtonHome.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jToggleButtonHome.setText("Home");
        jToggleButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(jToggleButtonTryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(jToggleButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(710, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(jToggleButtonTryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(281, Short.MAX_VALUE)
                    .addComponent(jToggleButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(240, 240, 240)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonTryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonTryAgainActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.getDrawPanel1().startGame(drawPanel.getLevel());
    }//GEN-LAST:event_jToggleButtonTryAgainActionPerformed

    private void jToggleButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonHomeActionPerformed
        LevelFrame levelFrame = new LevelFrame();
        levelFrame.setVisible(true);
    }//GEN-LAST:event_jToggleButtonHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jToggleButtonHome;
    private javax.swing.JToggleButton jToggleButtonTryAgain;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the drawPanel
     */
    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    /**
     * @param drawPanel the drawPanel to set
     */
    public void setDrawPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }
}
