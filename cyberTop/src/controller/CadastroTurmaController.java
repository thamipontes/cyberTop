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
        
        String horario;
        if(view.getCampoHorario().getSelectedItem() == "Matutino"){
            horario = "Matutino";
        }else if(view.getCampoHorario().getSelectedItem() == "Vespertino"){
            horario = "Vespertino";
        }else{
            horario = "Noturno";
        }
        
        Boolean tipo;
        if(view.getCampoTipoEnem().isSelected()){
            tipo = true;
        }else{
            tipo = false;
        }
        
        
        Boolean periodo;
        if(view.getCampoPeriodoAnual().isSelected()){
            periodo = true;
        }else{
            periodo = false;
        }
        
        
       
        
        Turmas turma = new Turmas(nome, horario, tipo , periodo, 60);
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            turmaDAO.insert(turma);
            
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
