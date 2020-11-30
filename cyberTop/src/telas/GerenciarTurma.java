
package telas;

import controller.GerenciarTurmaController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GerenciarTurma extends javax.swing.JFrame {
    GerenciarTurmaController controller;
    
    public GerenciarTurma() throws SQLException {
        initComponents();
        // Instancia uma variavel para realizar as operações com metodos da controller
        controller = new GerenciarTurmaController(this);
        
        // Carrega as turmas no banco de dados e insere na tabela da tela
        controller.inserirDadosTurmaTabela();
        
        //Carrega a lista de universidades do banco e insere na combo box universidades
        controller.inserirDadosUniversidadeCmb();
        
        // Seta as regras dos botoes
        controller.configuracaoInicialBotoes();
        //Desativa os campos de dados
        controller.desativarCampos();
        
        // Centraliza a tela no centro do monitor
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bntVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurma = new javax.swing.JTable();
        lblEditar = new javax.swing.JLabel();
        lblCadastrar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorTitulo = new javax.swing.JLabel();
        lblSalvarEditar = new javax.swing.JLabel();
        lblSalvarCadastro = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
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
        background1 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cyber Top - Turma");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntVoltar.setBackground(new java.awt.Color(255, 255, 255));
        bntVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        bntVoltar.setText("Voltar");
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(bntVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Turmas"));

        tblTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tipo", "Periodo", "Horario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurmaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTurma);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 520, 220));

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lapis.png"))); // NOI18N
        lblEditar.setText("Editar");
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarMouseClicked(evt);
            }
        });
        jPanel1.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        lblCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        lblCadastrar.setText("Cadastrar");
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        lblBuscar.setText("Buscar");
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/eraser.png"))); // NOI18N
        lblRemover.setText("Descadastrar");
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoverMouseClicked(evt);
            }
        });
        jPanel1.add(lblRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        pnlTitulo.setBackground(new java.awt.Color(255, 153, 0));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Gerenciar Turma");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        lblCorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/grey.png"))); // NOI18N
        lblCorTitulo.setText("jLabel6");
        pnlTitulo.add(lblCorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 60));

        jPanel1.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblSalvarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        lblSalvarEditar.setText("Salvar");
        lblSalvarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarEditarMouseClicked(evt);
            }
        });
        jPanel1.add(lblSalvarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 40));

        lblSalvarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        lblSalvarCadastro.setText("Salvar");
        lblSalvarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarCadastroMouseClicked(evt);
            }
        });
        jPanel1.add(lblSalvarCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 40));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        pnlInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        pnlInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da nova turma"));
        pnlInformacoes.setToolTipText("");
        pnlInformacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomeTurma.setText("Nome:");
        pnlInformacoes.add(lblNomeTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, -1));
        pnlInformacoes.add(txtNomeTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 36, 210, -1));

        lblUniversidade.setText("Universidade:");
        pnlInformacoes.add(lblUniversidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 16, -1, -1));

        lblTipo.setText("Tipo:");
        pnlInformacoes.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 16, -1, -1));

        lblPeriodo.setText("Período:");
        pnlInformacoes.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 16, -1, -1));

        rdbEnem.setBackground(new java.awt.Color(255, 255, 255));
        rdbEnem.setText("Enem");
        rdbEnem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEnemActionPerformed(evt);
            }
        });
        pnlInformacoes.add(rdbEnem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 35, -1, -1));

        rdbVestibular.setBackground(new java.awt.Color(255, 255, 255));
        rdbVestibular.setText("Vestibular");
        rdbVestibular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVestibularActionPerformed(evt);
            }
        });
        pnlInformacoes.add(rdbVestibular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 58, -1, -1));

        lblHorario.setText("Horários:");
        pnlInformacoes.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 77, -1, -1));

        rdbSemestral.setBackground(new java.awt.Color(255, 255, 255));
        rdbSemestral.setText("Semestral");
        rdbSemestral.setToolTipText("");
        rdbSemestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSemestralActionPerformed(evt);
            }
        });
        pnlInformacoes.add(rdbSemestral, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 58, -1, -1));

        rdbAnual.setBackground(new java.awt.Color(255, 255, 255));
        rdbAnual.setText("Anual");
        rdbAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAnualActionPerformed(evt);
            }
        });
        pnlInformacoes.add(rdbAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 35, -1, -1));

        cmbUniversidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Universidade de Brasília" }));
        cmbUniversidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUniversidadeActionPerformed(evt);
            }
        });
        pnlInformacoes.add(cmbUniversidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 36, -1, -1));

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Matutino", "Vespertino", "Noturno" }));
        pnlInformacoes.add(cmbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 97, -1, -1));

        jPanel1.add(pnlInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 660, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 590));

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background-2.png"))); // NOI18N
        background1.setText("jLabel1");
        getContentPane().add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 690, 420));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background-2.png"))); // NOI18N
        background2.setText("jLabel1");
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void tblTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmaMouseClicked
        
        
        try {
            // TODO add your handling code here:

            controller.inserirCampos();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_tblTurmaMouseClicked

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        
        //Chamar metodo editar
        controller.botaoEditarCadastro();
        

    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        try {


            controller.botaoCadastrar();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        
        try {
            controller.buscarCadastro();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void lblRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMouseClicked
        
        // TODO add your handling code here:
        controller.removerCadastro();
        
    }//GEN-LAST:event_lblRemoverMouseClicked

    private void lblSalvarEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarEditarMouseClicked
        
        controller.editarCadastro();
        

    }//GEN-LAST:event_lblSalvarEditarMouseClicked

    private void lblSalvarCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarCadastroMouseClicked
        
        // TODO add your handling code here:
        controller.salvarCadastro();
        
    }//GEN-LAST:event_lblSalvarCadastroMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        
        try {
            controller.cancelar();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void rdbEnemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEnemActionPerformed
        controller.selecionarTipoEnem();
    }//GEN-LAST:event_rdbEnemActionPerformed

    private void rdbVestibularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVestibularActionPerformed
        controller.selecionarTipoVestibular();
    }//GEN-LAST:event_rdbVestibularActionPerformed

    private void rdbSemestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSemestralActionPerformed
        controller.selecionarPeriodoSemestral();
    }//GEN-LAST:event_rdbSemestralActionPerformed

    private void rdbAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAnualActionPerformed
        controller.selecionarPeriodoAnual();
    }//GEN-LAST:event_rdbAnualActionPerformed

    private void cmbUniversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUniversidadeActionPerformed

    }//GEN-LAST:event_cmbUniversidadeActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GerenciarTurma().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background2;
    private javax.swing.JButton bntVoltar;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbUniversidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblCorTitulo;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblSalvarCadastro;
    private javax.swing.JLabel lblSalvarEditar;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUniversidade;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JRadioButton rdbAnual;
    private javax.swing.JRadioButton rdbEnem;
    private javax.swing.JRadioButton rdbSemestral;
    private javax.swing.JRadioButton rdbVestibular;
    private javax.swing.JTable tblTurma;
    private javax.swing.JTextField txtNomeTurma;
    // End of variables declaration//GEN-END:variables
  //Getters e Setters dos campos de inserção
    public JTable getTblTurma(){
        return tblTurma;
    }
    
    public JTextField getTxtNome(){
        return txtNomeTurma;
    }
    
    
    public JComboBox getCampoHorario(){
        return cmbHorario;
    }
    

    public JRadioButton getRdbEnem(){
        return rdbEnem;
    }
    
    public JRadioButton getRdbVestibular(){
        return rdbVestibular;
    }
    
    public JRadioButton getRdbAnual(){
        return rdbAnual;
    }
    
    public JRadioButton getRdbSemestral(){
        return rdbSemestral;
    }
    
    public JComboBox<String> getCampoUniversidade(){
        return cmbUniversidade;
    }
    
    //Getters dos botoes gerenciar alunos
    public JLabel getLblEditar(){
        return lblEditar;
    }
    public JLabel getLblRemover(){
        return lblRemover;
    }
    
    public JLabel getLblBuscar(){
        return lblBuscar;
    }
    
    public JLabel getLblCancelar(){
        return lblCancelar;
    }
    
    public JLabel getLblSalvarEditar(){
        return lblSalvarEditar;
    }
    
    public JLabel getLblSalvarCadastro(){
        return lblSalvarCadastro;
    }
    
    public JLabel getLblCadastrar(){
        return lblCadastrar;
    }
    
    

}
