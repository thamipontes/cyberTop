package telas;


import controller.CadastroTurmaController;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroTurma extends javax.swing.JFrame {
    
    private final CadastroTurmaController controller;
    
    
    public CadastroTurma() {
        initComponents();
        controller = new CadastroTurmaController(this);       
         
        
        setLocationRelativeTo(null);
        //Insere os dados da universidade na combo box
        try {
            controller.inserirDadosUniversidadeCmb();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
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

        pnlCentral = new javax.swing.JPanel();
        pnlInformacoes = new javax.swing.JPanel();
        lblNomeTurma = new javax.swing.JLabel();
        txtNomeTurma = new javax.swing.JTextField();
        lblUniversidade = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        rdbEnem = new javax.swing.JRadioButton();
        rdbVestibular = new javax.swing.JRadioButton();
        lblHorario = new javax.swing.JLabel();
        rdbSemestral = new javax.swing.JRadioButton();
        rdbAnual = new javax.swing.JRadioButton();
        cmbUniversidade = new javax.swing.JComboBox<>();
        cmbHorario = new javax.swing.JComboBox<>();
        bntLimpar = new javax.swing.JButton();
        bntSalvar = new javax.swing.JButton();
        bntVoltar3 = new javax.swing.JButton();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Turma");
        setPreferredSize(new java.awt.Dimension(680, 543));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCentral.setBackground(new java.awt.Color(255, 255, 255));

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        pnlInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da nova turma"));
        pnlInformacoes.setToolTipText("");

        lblNomeTurma.setText("Nome:");

        lblUniversidade.setText("Universidade:");

        lblTipo.setText("Tipo:");

        lblPeriodo.setText("Período:");

        rdbEnem.setBackground(new java.awt.Color(255, 255, 255));
        rdbEnem.setText("Enem");
        rdbEnem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEnemActionPerformed(evt);
            }
        });

        rdbVestibular.setBackground(new java.awt.Color(255, 255, 255));
        rdbVestibular.setText("Vestibular");
        rdbVestibular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVestibularActionPerformed(evt);
            }
        });

        lblHorario.setText("Horários:");

        rdbSemestral.setBackground(new java.awt.Color(255, 255, 255));
        rdbSemestral.setText("Semestral");
        rdbSemestral.setToolTipText("");
        rdbSemestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSemestralActionPerformed(evt);
            }
        });

        rdbAnual.setBackground(new java.awt.Color(255, 255, 255));
        rdbAnual.setText("Anual");
        rdbAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAnualActionPerformed(evt);
            }
        });

        cmbUniversidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Universidade de Brasília" }));
        cmbUniversidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUniversidadeActionPerformed(evt);
            }
        });

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Matutino", "Vespertino", "Noturno" }));

        javax.swing.GroupLayout pnlInformacoesLayout = new javax.swing.GroupLayout(pnlInformacoes);
        pnlInformacoes.setLayout(pnlInformacoesLayout);
        pnlInformacoesLayout.setHorizontalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeTurma)
                            .addComponent(txtNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHorario))
                        .addGap(11, 11, 11)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbVestibular)
                            .addComponent(lblTipo)
                            .addComponent(rdbEnem))
                        .addGap(0, 0, 0)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbSemestral)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPeriodo)
                                    .addComponent(rdbAnual))
                                .addGap(64, 64, 64)
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUniversidade)
                                    .addComponent(cmbUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlInformacoesLayout.setVerticalGroup(
            pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeTurma)
                    .addComponent(lblTipo)
                    .addComponent(lblPeriodo)
                    .addComponent(lblUniversidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbEnem)
                    .addComponent(rdbAnual)
                    .addComponent(cmbUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbVestibular)
                            .addComponent(rdbSemestral)))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblHorario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        bntLimpar.setBackground(new java.awt.Color(255, 255, 255));
        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar .png"))); // NOI18N
        bntLimpar.setText("Limpar");
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        bntSalvar.setBackground(new java.awt.Color(255, 255, 255));
        bntSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        bntVoltar3.setBackground(new java.awt.Color(255, 255, 255));
        bntVoltar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        bntVoltar3.setText("Voltar");
        bntVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltar3ActionPerformed(evt);
            }
        });

        pnlTitulo.setBackground(new java.awt.Color(255, 153, 0));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Cadastro de Turma");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 12, -1, -1));

        lblCorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/grey.png"))); // NOI18N
        lblCorTitulo.setText("jLabel6");
        pnlTitulo.add(lblCorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(bntSalvar)
                .addGap(101, 101, 101)
                .addComponent(bntLimpar)
                .addGap(81, 81, 81)
                .addComponent(bntVoltar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntLimpar)
                    .addComponent(bntSalvar)
                    .addComponent(bntVoltar3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 700, 320));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background-2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 350));

        setSize(new java.awt.Dimension(739, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbEnemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEnemActionPerformed
        controller.selecionarTipoEnem();        
    }//GEN-LAST:event_rdbEnemActionPerformed

    private void rdbVestibularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVestibularActionPerformed
        controller.selecionarTipoVestibular();
    }//GEN-LAST:event_rdbVestibularActionPerformed

    private void rdbAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAnualActionPerformed
       
        controller.selecionarPeriodoAnual();
    }//GEN-LAST:event_rdbAnualActionPerformed

    private void rdbSemestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSemestralActionPerformed
        controller.selecionarPeriodoSemestral();        
    }//GEN-LAST:event_rdbSemestralActionPerformed

    private void cmbUniversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUniversidadeActionPerformed
        
    }//GEN-LAST:event_cmbUniversidadeActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        // Exibe alerta caso algum campo do formulario esteja vazio
        if(!(controller.exibirAlertarCampos())){           
            //Salva os dados no banco de dados                   
            controller.salvarCadastro();
        }
    }//GEN-LAST:event_bntSalvarActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        controller.limparCampos();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void bntVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltar3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bntVoltar3ActionPerformed
    
    
       
    //Getter e Setters dos campos    
    
    public JTextField getCampoNomeTurma(){
        return txtNomeTurma;
    }
    
    public JComboBox getCampoHorario(){
        return cmbHorario;
    }
    

    public JRadioButton getCampoTipoEnem(){
        return rdbEnem;
    }
    
    public JRadioButton getCampoTipoVestibular(){
        return rdbVestibular;
    }
    
    public JRadioButton getCampoPeriodoAnual(){
        return rdbAnual;
    }
    
    public JRadioButton getCampoPeriodoSemestral(){
        return rdbSemestral;
    }
    
    public JComboBox<String> getCampoUniversidade(){
        return cmbUniversidade;
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
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTurma().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntSalvar;
    private javax.swing.JButton bntVoltar3;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbUniversidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCorTitulo;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUniversidade;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JRadioButton rdbAnual;
    private javax.swing.JRadioButton rdbEnem;
    private javax.swing.JRadioButton rdbSemestral;
    private javax.swing.JRadioButton rdbVestibular;
    private javax.swing.JTextField txtNomeTurma;
    // End of variables declaration//GEN-END:variables

 

}
