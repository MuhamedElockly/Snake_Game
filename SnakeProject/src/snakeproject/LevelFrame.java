package snakeproject;

import java.awt.Color;

public class LevelFrame extends javax.swing.JFrame {

    public LevelFrame() {
        initComponents();

        setResizable(false);
        jToggleButtonMedium.setBackground(Color.red);
        jToggleButtonEasy.setBackground(Color.red);
        jToggleButtonHard.setBackground(Color.red);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jToggleButtonHard = new javax.swing.JToggleButton();
        jToggleButtonEasy = new javax.swing.JToggleButton();
        jToggleButtonMedium = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jToggleButtonHard.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jToggleButtonHard.setText("Hard");
        jToggleButtonHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonHardActionPerformed(evt);
            }
        });

        jToggleButtonEasy.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jToggleButtonEasy.setText("Easy");
        jToggleButtonEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEasyActionPerformed(evt);
            }
        });

        jToggleButtonMedium.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jToggleButtonMedium.setText("Medium");
        jToggleButtonMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonMediumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonHard, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jToggleButtonEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jToggleButtonMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jToggleButtonHard, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEasyActionPerformed

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.getDrawPanel1().startGame(1);
        this.dispose();
    }//GEN-LAST:event_jToggleButtonEasyActionPerformed

    private void jToggleButtonMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonMediumActionPerformed

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.getDrawPanel1().startGame(2);
        this.dispose();
    }//GEN-LAST:event_jToggleButtonMediumActionPerformed

    private void jToggleButtonHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonHardActionPerformed

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.getDrawPanel1().startGame(3);
        this.dispose();
    }//GEN-LAST:event_jToggleButtonHardActionPerformed

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
            java.util.logging.Logger.getLogger(LevelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LevelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LevelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LevelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LevelFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButtonEasy;
    private javax.swing.JToggleButton jToggleButtonHard;
    private javax.swing.JToggleButton jToggleButtonMedium;
    // End of variables declaration//GEN-END:variables

}
