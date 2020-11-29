/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.GerenciarProfessorController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jhonatan Borges
 */
public class GerenciarProfessor extends javax.swing.JFrame {
    public final GerenciarProfessorController controller;
    /**
     * Creates new form GerenciarProfessor
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public GerenciarProfessor() throws SQLException, ParseException {
        initComponents();
        
        // instancia um objto para lidar diretamente com a funções da tela
        controller = new GerenciarProfessorController(this);
        
        // Centraliza a janela do programa no centro do monitor
        setLocationRelativeTo(null);
        
        // Carrega a lista de professores
        controller.inserirDadosProfessorTabela();
        // Insere os dados no campo da combobox
        controller.inserirDadosProfessorCmB();
        // Desativa os campos
        controller.desativarCampos();
        // seta o padrão de botões para inicio da tela   
        controller.configuracaoInicialBotoes();
        
        
        
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
        bntVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
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
        pnlDadosPessoais4 = new javax.swing.JPanel();
        lblNomeAluno4 = new javax.swing.JLabel();
        txtNomeProfessor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbGeneroProfessor = new javax.swing.JComboBox<>();
        lblCPF = new javax.swing.JLabel();
        txtCPFProfessor = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataNascimentoProfessor = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefoneProfessor = new javax.swing.JFormattedTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouroProfessor = new javax.swing.JTextField();
        lblMateria = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        cmbTurmaProfessor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        background1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CyberTop - Professor");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCentral.setBackground(new java.awt.Color(255, 255, 255));
        pnlCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntVoltar.setBackground(new java.awt.Color(255, 255, 255));
        bntVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        bntVoltar.setText("Voltar");
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });
        pnlCentral.add(bntVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Universidades"));

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Turma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProfessor);

        pnlCentral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 520, 220));

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lapis.png"))); // NOI18N
        lblEditar.setText("Editar");
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarMouseClicked(evt);
            }
        });
        pnlCentral.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        lblCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        lblCadastrar.setText("Cadastrar");
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        pnlCentral.add(lblCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        lblBuscar.setText("Buscar");
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        pnlCentral.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/eraser.png"))); // NOI18N
        lblRemover.setText("Descadastrar");
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoverMouseClicked(evt);
            }
        });
        pnlCentral.add(lblRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        pnlTitulo.setBackground(new java.awt.Color(255, 153, 0));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Gerenciar Professor");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        lblCorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/grey.png"))); // NOI18N
        lblCorTitulo.setText("jLabel6");
        pnlTitulo.add(lblCorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 60));

        pnlCentral.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblSalvarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        lblSalvarEditar.setText("Salvar");
        lblSalvarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarEditarMouseClicked(evt);
            }
        });
        pnlCentral.add(lblSalvarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 20));

        lblSalvarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        lblSalvarCadastro.setText("Salvar");
        lblSalvarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarCadastroMouseClicked(evt);
            }
        });
        pnlCentral.add(lblSalvarCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 40));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        pnlCentral.add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        pnlDadosPessoais4.setBackground(new java.awt.Color(255, 255, 255));
        pnlDadosPessoais4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Professor"));

        lblNomeAluno4.setText("Nome:");

        txtNomeProfessor.setToolTipText("Insira o nome do aluno");

        jLabel8.setText("Gênero:");

        cmbGeneroProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Não informar", "Masculino", "Feminino", "Outros" }));
        cmbGeneroProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroProfessorActionPerformed(evt);
            }
        });

        lblCPF.setText("CPF:");

        try {
            txtCPFProfessor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFProfessor.setToolTipText("Insira o CPF do aluno");
        txtCPFProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFProfessorActionPerformed(evt);
            }
        });

        jLabel2.setText("Data de nascimento:");

        try {
            txtDataNascimentoProfessor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimentoProfessor.setToolTipText("Insira a da6a de nascimento do aluno");

        jLabel3.setText("Telefone:");

        try {
            txtTelefoneProfessor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneProfessor.setToolTipText("Insira o telefone do estudante");
        txtTelefoneProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneProfessorActionPerformed(evt);
            }
        });

        lblLogradouro.setText("Endereço:");

        txtLogradouroProfessor.setToolTipText("Insira o endereço do estudante");

        lblMateria.setText("Matéria que leciona:");

        cmbTurmaProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", " " }));
        cmbTurmaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTurmaProfessorActionPerformed(evt);
            }
        });

        jLabel1.setText("Turma que administra:");

        javax.swing.GroupLayout pnlDadosPessoais4Layout = new javax.swing.GroupLayout(pnlDadosPessoais4);
        pnlDadosPessoais4.setLayout(pnlDadosPessoais4Layout);
        pnlDadosPessoais4Layout.setHorizontalGroup(
            pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoais4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosPessoais4Layout.createSequentialGroup()
                        .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMateria)
                            .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTurmaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosPessoais4Layout.createSequentialGroup()
                        .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDadosPessoais4Layout.createSequentialGroup()
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTelefoneProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbGeneroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogradouro)
                                    .addComponent(txtLogradouroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosPessoais4Layout.createSequentialGroup()
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNomeAluno4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCPF)
                                    .addComponent(txtCPFProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtDataNascimentoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))))
        );
        pnlDadosPessoais4Layout.setVerticalGroup(
            pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoais4Layout.createSequentialGroup()
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAluno4)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPFProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimentoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(lblLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGeneroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogradouroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMateria)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosPessoais4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTurmaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        pnlCentral.add(pnlDadosPessoais4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 670, 250));

        getContentPane().add(pnlCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 700));

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background-2.png"))); // NOI18N
        background1.setText("jLabel1");
        getContentPane().add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void tblProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfessorMouseClicked
        
        try {
            // TODO add your handling code here:

            controller.inserirCampos();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUniversidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tblProfessorMouseClicked

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        
        //Chamar metodo editar
        controller.botaoEditarCadastro();
        
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        // TODO add your handling code here:
        //new CadastroUniversidade().setVisible(true);
/*
        controller.botaoSalvarCadastro();
        */
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        
        try {
            controller.buscarCadastro();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarUniversidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void lblRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMouseClicked
        
        try {
            controller.removerCadastro();
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblRemoverMouseClicked

    private void lblSalvarEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarEditarMouseClicked
        
        try {
            controller.editarCadastro();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_lblSalvarEditarMouseClicked

    private void lblSalvarCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarCadastroMouseClicked
        /*
        try {
            // TODO add your handling code here:
            controller.salvarCadastro();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUniversidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_lblSalvarCadastroMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        
        try {
            controller.cancelar();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUniversidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void cmbGeneroProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroProfessorActionPerformed

    private void txtCPFProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFProfessorActionPerformed

    private void txtTelefoneProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneProfessorActionPerformed

    private void cmbTurmaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTurmaProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTurmaProfessorActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GerenciarProfessor().setVisible(true);
                } catch (SQLException | ParseException ex) {
                    Logger.getLogger(GerenciarProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background1;
    private javax.swing.JButton bntVoltar;
    private javax.swing.JComboBox<String> cmbGeneroProfessor;
    private javax.swing.JComboBox<String> cmbTurmaProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblCorTitulo;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblNomeAluno4;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblSalvarCadastro;
    private javax.swing.JLabel lblSalvarEditar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlDadosPessoais4;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JFormattedTextField txtCPFProfessor;
    private javax.swing.JFormattedTextField txtDataNascimentoProfessor;
    private javax.swing.JTextField txtLogradouroProfessor;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtNomeProfessor;
    private javax.swing.JFormattedTextField txtTelefoneProfessor;
    // End of variables declaration//GEN-END:variables
    
    //Getters e dos elementos de ação(tabela, campos, box)
    public JTable getTblProfessor(){
        return tblProfessor;
    }
    
   //Getters dos campos da tela cadastro aluno
    

    public JComboBox<String> getCmbGenero() {
        return cmbGeneroProfessor;
    }

    public JFormattedTextField getTxtCPF() {
        return txtCPFProfessor;
    }

    public JFormattedTextField getTxtDataNascimento() {
        return txtDataNascimentoProfessor;
    }

    public JTextField getTxtLogradouro() {
        return txtLogradouroProfessor;
    }

    public JTextField getTxtNome() {
        return txtNomeProfessor;
    }

    public JFormattedTextField getTxtTelefone() {
        return txtTelefoneProfessor;
    }
    
    public JTextField getTxtMateria(){
        return txtMateria;
    }

    public JComboBox<String> getCmbTurmaProfessor() {
        return cmbTurmaProfessor;
    }

    public void setCmbTurmaProfessor(JComboBox<String> cmbTurmaProfessor) {
        this.cmbTurmaProfessor = cmbTurmaProfessor;
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
