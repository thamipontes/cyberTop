/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Alunos;
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

    public void insert(Alunos aluno) throws SQLException{
       
            String sql = "insert into aluno (nome, cpf, data_nascimento, telefone, endereco, genero, CEP, cor_raca) values (?, ?, '"+aluno.getDataNascimento().getTime()+"', ?, ?, "
                    + "'"+aluno.getGenero()+"', ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCPF());
//            statement.setDate(3, aluno.getDataNascimento());
            statement.setString(3, aluno.getTelefone());
            statement.setString(4, aluno.getEndereco());
//            statement.setCharacterStream(5, aluno.getGenero());
            statement.setString(5, aluno.getCEP());
            statement.setString(6, aluno.getCorRaca());
            
            statement.execute();            
            connection.close();           
       
    }    
    
}
