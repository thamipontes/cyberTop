
package controller;

import dao.Conexao;
import dao.ProfessorDAO;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Professor;
import model.Universidade;
import telas.GerenciarProfessor;

public class GerenciarProfessorController {
    private final GerenciarProfessor view;
    
    public GerenciarProfessorController(GerenciarProfessor view){
        this.view = view;
    }
    
    //Insere todas as universidades na tabela
    public void inserirDadosProfessorTabela() throws SQLException, ParseException{
        ArrayList<Professor> professorBanco = carregarDadosProfessor();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Matéria", "Turma"}, 0);
        
        
        professorBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getMateria(), e.getNomeTurma()};
            modelo.addRow(linha);        
        });
        
        view.getTblProfessor().setModel(modelo);
        
    } 
    
    public ArrayList<Professor> carregarDadosProfessor() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        ProfessorDAO professorDAO = new ProfessorDAO(conexao);
        
        ArrayList<Professor> professorBanco = professorDAO.findAll();
        
        return professorBanco;
        
    }
    
    
}
