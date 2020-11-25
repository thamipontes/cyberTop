/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.CadastroAluno;

/**
 *
 * @author thamires
 */
public class AlunosDAO {
    
    private final Connection connection;

    public AlunosDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Aluno aluno) throws SQLException{
       
            String sql = "insert into aluno (nome, cpf, data_nascimento, telefone, endereco, genero, CEP, cor_raca, id_turma, email, curso) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCPF());
            statement.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
            statement.setString(4, aluno.getTelefone());
            statement.setString(5, aluno.getEndereco());
            statement.setString(6, String.valueOf(aluno.getGenero()));
            statement.setString(7, aluno.getCEP());
            statement.setString(8, aluno.getCorRaca());
            statement.setInt(9, aluno.getTurmaId());
            statement.setString(10, aluno.getEmail());
            statement.setString(11, aluno.getCurso());

            
            statement.execute();            
            connection.close();         
       
    }

    
    public void update(Aluno aluno){    
    
    
    }
    
}
