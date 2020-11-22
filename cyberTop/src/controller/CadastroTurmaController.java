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
import telas.CadastroTurma2;

/**
 *
 * @author thamires
 */
public class CadastroTurmaController {
    
    private CadastroTurma2 view;

    public CadastroTurmaController(CadastroTurma2 view) {
        this.view = view;
    }    

    public void salvaTurma(){    
        
        
        String nome = view.getCampoNome().getText();
        String horario = view.getCampoHorario().getText();
        Boolean tipo = Boolean.parseBoolean(view.getCampoTipo().getText());
        Boolean periodo = Boolean.parseBoolean(view.getCampoPeriodo().getText());
        Integer vagas = Integer.parseInt(view.getCampoVagas().getText());
       
        
        Turmas turma = new Turmas(nome, horario, tipo , periodo, vagas);
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            turmaDAO.insert(turma);
            
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
