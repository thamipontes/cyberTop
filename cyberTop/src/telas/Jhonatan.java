package telas;

public class Jhonatan extends javax.swing.JFrame {

    public Jhonatan() {
        initComponents();
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

        pnlInformacoes = new javax.swing.JPanel();
        lblNomeTurma = new javax.swing.JLabel();
        txtNomeTurma = new javax.swing.JTextField();
        lblUniversidade = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        rdbEnem = new javax.swing.JRadioButton();
        rdbVestibular = new javax.swing.JRadioButton();
        rdbSemestral = new javax.swing.JRadioButton();
        rdbAnual = new javax.swing.JRadioButton();
        cmbUniversidade = new javax.swing.JComboBox<>();
        cmbHorario = new javax.swing.JComboBox<>();
        bntSalvar = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        bntVoltar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Turma");
        setPreferredSize(new java.awt.Dimension(680, 543));

        pnlInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da nova turma"));
        pnlInformacoes.setToolTipText("");

        lblNomeTurma.setText("Nome:");

        lblUniversidade.setText("Universidade:");

        lblHorario.setText("Horários:");

        lblTipo.setText("Tipo:");

        lblPeriodo.setText("Período:");

        rdbEnem.setText("Enem");
        rdbEnem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEnemActionPerformed(evt);
            }
        });

        rdbVestibular.setText("Vestibular");
        rdbVestibular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVestibularActionPerformed(evt);
            }
        });

        rdbSemestral.setText("Semestral");
        rdbSemestral.setToolTipText("");
        rdbSemestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSemestralActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeTurma)
                            .addComponent(txtNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHorario))
                        .addGap(11, 11, 11)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(rdbEnem)
                            .addComponent(rdbVestibular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbSemestral)
                            .addGroup(pnlInformacoesLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPeriodo)
                                    .addComponent(rdbAnual))
                                .addGap(64, 64, 64)
                                .addGroup(pnlInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUniversidade)
                                    .addComponent(cmbUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlInformacoesLayout.createSequentialGroup()
                        .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bntSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar .png"))); // NOI18N
        bntLimpar.setText("Limpar");
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        bntVoltar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        bntVoltar3.setText("Voltar");
        bntVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(bntSalvar)
                .addGap(76, 76, 76)
                .addComponent(bntLimpar)
                .addGap(68, 68, 68)
                .addComponent(bntVoltar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSalvar)
                    .addComponent(bntLimpar)
                    .addComponent(bntVoltar3))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(663, 290));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbEnemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEnemActionPerformed
        // TODO add your handling code here:
        rdbVestibular.setSelected(false);
        
        // Desativa a opção de inserção do nome da Universidade e limpa o campo
        cmbUniversidade.setEnabled(false);
        cmbUniversidade.setSelectedItem("Selecione");
        
        // 
        rdbAnual.setSelected(true);
        rdbSemestral.setSelected(false);
        
        
    }//GEN-LAST:event_rdbEnemActionPerformed

    private void rdbVestibularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVestibularActionPerformed
        // TODO add your handling code here:
        rdbEnem.setSelected(false);
        
        //Ativa o campo para inserção do nome da Universidade
        cmbUniversidade.setEnabled(true);
        
        
    }//GEN-LAST:event_rdbVestibularActionPerformed

    private void rdbAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAnualActionPerformed
        // TODO add your handling code here:
        rdbSemestral.setSelected(false);
    }//GEN-LAST:event_rdbAnualActionPerformed

    private void rdbSemestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSemestralActionPerformed
        // TODO add your handling code here:
        
        rdbAnual.setSelected(false);
        //Desativar rdb enem
        rdbEnem.setSelected(false);
    }//GEN-LAST:event_rdbSemestralActionPerformed

    private void cmbUniversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUniversidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUniversidadeActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        // Exibe alerta caso algum campo do formulario esteja vazio
        

    }//GEN-LAST:event_bntSalvarActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        //Insere o cursor no txtNome e o deixa em foco
        txtNomeTurma.requestFocus();

        // Limpa todos os campos
        txtNomeTurma.setText("");
        rdbEnem.setSelected(false);
        rdbVestibular.setSelected(false);
        rdbAnual.setSelected(false);
        rdbSemestral.setSelected(false);
        cmbUniversidade.setSelectedItem("Selecione");
        cmbHorario.setSelectedItem("Selecione");
    }//GEN-LAST:event_bntLimparActionPerformed

    private void bntVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltar3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bntVoltar3ActionPerformed

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
            java.util.logging.Logger.getLogger(Jhonatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jhonatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jhonatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jhonatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jhonatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntSalvar;
    private javax.swing.JButton bntVoltar;
    private javax.swing.JButton bntVoltar1;
    private javax.swing.JButton bntVoltar2;
    private javax.swing.JButton bntVoltar3;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbUniversidade;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUniversidade;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JRadioButton rdbAnual;
    private javax.swing.JRadioButton rdbEnem;
    private javax.swing.JRadioButton rdbSemestral;
    private javax.swing.JRadioButton rdbVestibular;
    private javax.swing.JTextField txtNomeTurma;
    // End of variables declaration//GEN-END:variables
}
