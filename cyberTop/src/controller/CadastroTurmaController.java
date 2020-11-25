/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.TurmaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Turmas;
import telas.CadastroAluno;
import telas.CadastroTurma;

/**
 *
 * @author thamires
 */
public class CadastroTurmaController {
    
    private CadastroTurma view;

    public CadastroTurmaController(CadastroTurma view) {
        this.view = view;
    }    

    public void salvaTurma(){   
        
        
        String nome = view.getCampoNomeTurma().getText();  
        String horario = view.getCampoHorario().getSelectedItem().toString();        
        Boolean tipo = view.getCampoTipoEnem().isSelected();      
        Boolean periodo = view.getCampoPeriodoAnual().isSelected();    
 
        Turmas turma = new Turmas(nome, horario, tipo , periodo, 60);
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            turmaDAO.insert(turma);
            
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao criar turma!");
        }
    }

    
    
    
}