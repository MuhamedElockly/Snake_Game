package snakeproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        //  drawPanel1.setScorePanel(this.scorePanel1);
       // this.pack();
           this.setPreferredSize(new Dimension(1920, 1080));
        drawPanel2.addPropertyChangeListener(scorePanel2);
        getContentPane().setBackground(Color.YELLOW);
//      drawPanel1.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
//       drawPanel1.setAlignmentX(JComponent.TOP_ALIGNMENT);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new snakeproject.BackgroundPanel();
        drawPanel2 = new snakeproject.DrawPanel();
        scorePanel2 = new snakeproject.ScorePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        drawPanel2.setPreferredSize(new java.awt.Dimension(1650, 800));

        javax.swing.GroupLayout drawPanel2Layout = new javax.swing.GroupLayout(drawPanel2);
        drawPanel2.setLayout(drawPanel2Layout);
        drawPanel2Layout.setHorizontalGroup(
            drawPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1650, Short.MAX_VALUE)
        );
        drawPanel2Layout.setVerticalGroup(
            drawPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        scorePanel2.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scorePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(drawPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addComponent(scorePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(drawPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private snakeproject.BackgroundPanel backgroundPanel1;
    private snakeproject.DrawPanel drawPanel2;
    private snakeproject.ScorePanel scorePanel2;
    // End of variables declaration//GEN-END:variables

    public snakeproject.DrawPanel getDrawPanel1() {
        return drawPanel2;
    }

    public void setDrawPanel1(snakeproject.DrawPanel drawPanel1) {
        this.drawPanel2 = drawPanel1;
    }
}
