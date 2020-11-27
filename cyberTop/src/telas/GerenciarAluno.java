/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.GerenciarAlunoController;
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
public class GerenciarAluno extends javax.swing.JFrame {

    private final GerenciarAlunoController controller;
    /**
     * Creates new form GerenciarAluno
     */
    
    
    
    
    public GerenciarAluno() {
        initComponents();
        
        controller = new GerenciarAlunoController(this);
        
        setLocationRelativeTo(null);
        
        controller.desativarCampos();
        lblRemover.setEnabled(false);
        lblEditar.setEnabled(false);
        lblCancelar.setVisible(false);
        lblSalvar.setVisible(false);
        
        
        try {
            controller.inserirDadosAlunoTabela();
            //controller.inserirDadosTurmaBox();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        bntVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAluno = new javax.swing.JTable();
        lblEditar = new javax.swing.JLabel();
        lblCadastrar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorTitulo = new javax.swing.JLabel();
        pnlDadosAluno = new javax.swing.JPanel();
        lblNomeAluno = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCorRaca = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        lblCEP = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblTurma = new javax.swing.JLabel();
        txtIdTurma = new javax.swing.JTextField();
        lblCancelar = new javax.swing.JLabel();
        lblSalvar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jPanel1.add(bntVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alunos matriculados"));

        tblAluno.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAluno);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 520, 220));

        lblEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lapis.png"))); // NOI18N
        lblEditar.setText("Editar");
        lblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarMouseClicked(evt);
            }
        });
        jPanel1.add(lblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        lblCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        lblCadastrar.setText("Cadastrar");
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        lblBuscar.setText("Buscar");
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        lblRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/eraser.png"))); // NOI18N
        lblRemover.setText("Descadastrar");
        lblRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoverMouseClicked(evt);
            }
        });
        jPanel1.add(lblRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        pnlTitulo.setBackground(new java.awt.Color(255, 153, 0));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Gerenciar Aluno");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        lblCorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/grey.png"))); // NOI18N
        lblCorTitulo.setText("jLabel6");
        pnlTitulo.add(lblCorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 60));

        jPanel1.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        pnlDadosAluno.setBackground(new java.awt.Color(255, 255, 255));
        pnlDadosAluno.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        lblNomeAluno.setText("Nome:");

        txtNome.setToolTipText("Insira o nome do aluno");

        jLabel4.setText("Gênero:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Não informar", "Masculino", "Feminino", "Outros" }));
        cmbGenero.setToolTipText("Selecione o gênero do aluno");
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });

        lblCPF.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setToolTipText("Insira o CPF do aluno");
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de nascimento:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setToolTipText("Insira a da6a de nascimento do aluno");

        jLabel6.setText("Telefone:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("Insira o telefone do estudante");
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel7.setText("Cor/Raça");

        cmbCorRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Não declarar", "Preta", "Parda", "Indígena", "Amarela", "Branca" }));
        cmbCorRaca.setToolTipText("Selecione a cor/raca do aluno");
        cmbCorRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCorRacaActionPerformed(evt);
            }
        });

        lblEmail.setText("E-mail:");

        lblCurso.setText("Curso:");
        lblCurso.setToolTipText("");

        txtCurso.setToolTipText("Insira do curso do estudante");

        lblCEP.setText("CEP:");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.setToolTipText("Insira o CEP do estudante");

        lblLogradouro.setText("Endereço:");

        txtLogradouro.setToolTipText("Insira o endereço do estudante");

        lblTurma.setText("Id da turma:");

        javax.swing.GroupLayout pnlDadosAlunoLayout = new javax.swing.GroupLayout(pnlDadosAluno);
        pnlDadosAluno.setLayout(pnlDadosAlunoLayout);
        pnlDadosAlunoLayout.setHorizontalGroup(
            pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                        .addComponent(lblCurso)
                        .addGap(101, 101, 101)
                        .addComponent(lblCEP)
                        .addGap(81, 81, 81)
                        .addComponent(lblLogradouro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosAlunoLayout.createSequentialGroup()
                        .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLogradouro))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosAlunoLayout.createSequentialGroup()
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCorRaca, 0, 1, Short.MAX_VALUE)
                                    .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosAlunoLayout.createSequentialGroup()
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNomeAluno)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCPF)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(19, 19, 19))
                                    .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(21, 21, 21))
                    .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                        .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurma)
                            .addComponent(txtIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlDadosAlunoLayout.setVerticalGroup(
            pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosAlunoLayout.createSequentialGroup()
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAluno)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblEmail)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCorRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(lblCEP)
                    .addComponent(lblLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDadosAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 650, 230));

        lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        lblCancelar.setText("Cancelar");
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        lblSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        lblSalvar.setText("Salvar");
        lblSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarMouseClicked(evt);
            }
        });
        jPanel1.add(lblSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 630));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/background-2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarMouseClicked
        try {
            //Chamar metodo editar
            controller.editar();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblEditarMouseClicked

    private void lblRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoverMouseClicked
       
        
        try {
            // TODO add your handling code here:
            controller.removerLinhaAluno();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblRemoverMouseClicked

    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        // TODO add your handling code here:
        new CadastroAluno().setVisible(true);
        
        
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        // TODO add your handling code here:
        //controller.
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void cmbCorRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCorRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCorRacaActionPerformed

    private void tblAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunoMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            controller.inserirCampos();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblAlunoMouseClicked

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        try {
            // TODO add your handling code here:
            controller.cancelarEditar();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void lblSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseClicked
        try {
            // TODO add your handling code here:
            controller.salvarEditar();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblSalvarMouseClicked

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
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    private javax.swing.JComboBox<String> cmbCorRaca;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblCorTitulo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNomeAluno;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblSalvar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel pnlDadosAluno;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTable tblAluno;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdTurma;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    public JTable getTblAluno(){
        return tblAluno;
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
    
    public JLabel getLblSalvar(){
        return lblSalvar;
    }
    
    public JLabel getLblCadastrar(){
        return lblCadastrar;
    }
    
    
    
    
    
    
    
    //Getters dos campos da tela cadastro aluno
    public JComboBox<String> getCmbCorRaca() {
        return cmbCorRaca;
    }

    public JComboBox<String> getCmbGenero() {
        return cmbGenero;
    }

    public JFormattedTextField getTxtCEP() {
        return txtCEP;
    }

    public JFormattedTextField getTxtCPF() {
        return txtCPF;
    }

    public JFormattedTextField getTxtDataNascimento() {
        return txtDataNascimento;
    }

    public JTextField getTxtLogradouro() {
        return txtLogradouro;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }
    
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JFormattedTextField getTxtTelefone() {
        return txtTelefone;
    }
    
    public JTextField getTxtCurso(){
        return txtCurso;
    }
    
    public JTextField getTxtIdTurma(){
        return txtIdTurma;
    }
    
    
}
