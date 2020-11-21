/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cursinho.Alunos;
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
       
            String sql = "insert into aluno (nome, cpf, data_nascimento, telefone, endereco) values ('"+aluno.getNome()+"', '"+aluno.getCpf()+"', '"+aluno.getData_nascimento().getTime()+"', '"+aluno.getTelefone()+"', '"+aluno.getEndereco()+"');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();            
            connection.close();            
       
    }
    
    
}
