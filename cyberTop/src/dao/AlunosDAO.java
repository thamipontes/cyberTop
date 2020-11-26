/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public ArrayList<Aluno> findAll() throws SQLException, ParseException{
        String sql = "select id, nome, CPF, data_nascimento telefone, endereco, genero, cep, cor_raca, id_turma from aluno";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisar(statement);
        
    }
    
    public ArrayList<Aluno> pesquisar(PreparedStatement statement) throws SQLException, ParseException{
        ArrayList<Aluno> alunos = new ArrayList<>();;
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            //String dataNascimento = resultSet.getString("data_nascimento");
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(sdf.parse("23/07/2000"));
            
            //resultSet.getDate("data_nascimento", dataNascimento);
                    
                    
            String telefone = resultSet.getString("telefone");
            String endereco = resultSet.getString("endereco");
            String genero1 = resultSet.getString("genero");
            char genero = genero1.charAt(0);
            
            String CEP = resultSet.getString("CEP");
            String corRaca = resultSet.getString("cor_raca");
            int turmaId = resultSet.getInt("id_turma");
            String email = resultSet.getString("email");
            String curso = resultSet.getString("curso");
            
            Aluno alunoBanco = new Aluno(id, nome, cpf, dataNascimento, telefone, endereco, genero, turmaId, CEP, corRaca, email, curso);
            
            alunos.add(alunoBanco);
            
        }
        return alunos;
    }
    
    

    
    public void update(Aluno aluno){    
    
    
    }
    
}
