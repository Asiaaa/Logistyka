/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class Start extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    public Start() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        LOGIN_FIELD = new javax.swing.JTextField();
        PASSWORD_FIELD = new javax.swing.JTextField();
        LOGIN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        LOGIN_FIELD.setText("EMAIL");
        LOGIN_FIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN_FIELDActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN_FIELD);
        LOGIN_FIELD.setBounds(130, 90, 190, 30);

        PASSWORD_FIELD.setText("HASŁO");
        jPanel2.add(PASSWORD_FIELD);
        PASSWORD_FIELD.setBounds(130, 130, 190, 30);

        LOGIN.setText("ZALOGUJ SIĘ!");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN);
        LOGIN.setBounds(191, 180, 130, 30);
        LOGIN.getAccessibleContext().setAccessibleName("ZALOGUJ SIĘ!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 480, 310);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
       // showERROR();
    }//GEN-LAST:event_LOGINActionPerformed

    private void LOGIN_FIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN_FIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOGIN_FIELDActionPerformed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }
    
    public String getPassword()
    {
        return PASSWORD_FIELD.getText();
    }
    
    public String getLogin()
    {
        return LOGIN_FIELD.getText();
    }
    
    public void showERROR()
    {
        JOptionPane.showMessageDialog(this, "BŁĘDNY LOGIN LUB HASŁO");
    }
    
    public void addLOGINListener(ActionListener IN_LOGIN)
    {
        LOGIN.addActionListener(IN_LOGIN);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LOGIN;
    private javax.swing.JTextField LOGIN_FIELD;
    private javax.swing.JTextField PASSWORD_FIELD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
