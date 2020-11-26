/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Aluno;
import model.Professor;

/**
 *
 * @author thamires
 */
public class ProfessorDAO {
    
    private final Connection connection;

    public ProfessorDAO(Connection connection) {
        this.connection = connection;
    }
    
  
    public void insert(Professor professor) throws SQLException{
       
            String sql = "insert into professor (nome, cpf, data_nascimento, telefone, endereco, genero, materia, turma) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getCPF());
            statement.setDate(3, new java.sql.Date(professor.getDataNascimento().getTimeInMillis()));
            statement.setString(4, professor.getTelefone());
            statement.setString(5, professor.getEndereco());
            statement.setString(6, String.valueOf(professor.getGenero()));
            statement.setString(7, professor.getMateria());
            statement.setString(8, professor.getNomeTurma());     

            
            statement.execute();            
            connection.close();         
       
    }
    
    
    
}
