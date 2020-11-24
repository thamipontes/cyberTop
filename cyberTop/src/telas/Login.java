/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.LoginController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jhonatan Borges
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private final LoginController controller;
    
    public Login() {
        
        controller = new LoginController(this);        
        initComponents();
        
        setLocationRelativeTo(null);
        txtUsuario.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSeuUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        bntEntrar = new javax.swing.JButton();
        lblSuaSenha = new javax.swing.JLabel();
        bntLimpar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        mnbLogin = new javax.swing.JMenuBar();
        mnAjuda = new javax.swing.JMenu();
        mnSobre = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();
        mntSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(204, 204, 255));

        pnlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlLogin.setForeground(new java.awt.Color(255, 153, 153));
        pnlLogin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/do-utilizador (3) (1).png"))); // NOI18N
        lblLogin.setText("Login");

        lblSeuUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSeuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/id-card (2).png"))); // NOI18N
        lblSeuUsuario.setText("Seu usuário:");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        bntEntrar.setBackground(new java.awt.Color(51, 153, 0));
        bntEntrar.setText("Entrar");
        bntEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEntrarActionPerformed(evt);
            }
        });

        lblSuaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSuaSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeado.png"))); // NOI18N
        lblSuaSenha.setText("Sua senha:");

        bntLimpar.setBackground(new java.awt.Color(204, 0, 0));
        bntLimpar.setText("Limpar");
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(bntEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(lblSuaSenha)
                        .addGap(26, 26, 26)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(lblSeuUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeuUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSuaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntEntrar)
                    .addComponent(bntLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnAjuda.setText("Ajuda");
        mnbLogin.add(mnAjuda);

        mnSobre.setText("Sobre");
        mnbLogin.add(mnSobre);

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });

        mntSair.setText("Desejo realmente sair!");
        mntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntSairActionPerformed(evt);
            }
        });
        mnSair.add(mntSair);

        mnbLogin.add(mnSair);

        setJMenuBar(mnbLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void bntEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEntrarActionPerformed
        
        try {
            // Verificar se o usuario e senha estao corretos
            controller.autenticar();
            
            
            // Se está tudo okay a janela X sera chamada
            // CadastroAluno();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_bntEntrarActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        // Limpar areas de texto
        txtUsuario.setText("");
        txtSenha.setText("");
        
        // Deixar o primeiro txt em foco(cursor piscando)
        txtUsuario.requestFocus();
        
    }//GEN-LAST:event_bntLimparActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
   
    }//GEN-LAST:event_mnSairActionPerformed

    private void mntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntSairActionPerformed
        // Encerra a execução
        System.exit(0);
    }//GEN-LAST:event_mntSairActionPerformed

    //Getters    
    
    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }
    
    
    
    
    
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEntrar;
    private javax.swing.JButton bntLimpar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSeuUsuario;
    private javax.swing.JLabel lblSuaSenha;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenu mnSobre;
    private javax.swing.JMenuBar mnbLogin;
    private javax.swing.JMenuItem mntSair;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
