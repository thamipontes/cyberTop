/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Aluno;
import model.Turmas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public class TurmaDAO {
    
    private final Connection connection;

    public TurmaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Turmas turma) throws SQLException{
       
            String sql = "insert into turma (nome, horario, tipo, periodo, vagas) values ('"+turma.getNome()+"', '"+turma.getHorario()+"', '"+turma.getTipo()+"', '"+turma.getPeriodo()+"', '"+turma.getVagas()+"');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();            
            connection.close();            
       
    }
    
    
    public void update(Turmas turma) throws SQLException{
    
        String sql = "update turma set nome = ?, horario = ?, tipo = ?, periodo = ?, vagas = ? where id = ?; ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, turma.getNome());
        statement.setString(2, turma.getHorario());
        statement.setBoolean(3, turma.getTipo());
        statement.setBoolean(4, turma.getPeriodo());
        statement.setInt(5, turma.getVagas());
        statement.execute(); 
    
    }
    
    public void delete(Turmas turma) throws SQLException{    
        String sql = "delete from turma where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, turma.getId());
        statement.execute();    
    }
    
    
    public ArrayList<Turmas> findAll() throws SQLException{
    
        String sql = "select * from turma";
        PreparedStatement statement = connection.prepareStatement(sql); 
        
        return pesquisar(statement);        
    
    }

    private ArrayList<Turmas> pesquisar(PreparedStatement statement) throws SQLException {
        ArrayList<Turmas> turmas = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id"); //nome na coluna
            String nome = resultSet.getString("nome");
            String horario = resultSet.getString("horario");
            boolean tipo = resultSet.getBoolean("tipo");
            boolean periodo = resultSet.getBoolean("periodo");
            int vagas = resultSet.getInt("vagas");
            
            Turmas turmaBanco = new Turmas(id, nome, horario, tipo, periodo, vagas);
            turmas.add(turmaBanco);         
        }
        
        return turmas;
    }
    
    
    public Turmas findById(Turmas turma) throws SQLException{
    
        String sql = "select * from turma where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, turma.getId());        
        return pesquisar(statement).get(0);    
    
    }
    
    
    
}
