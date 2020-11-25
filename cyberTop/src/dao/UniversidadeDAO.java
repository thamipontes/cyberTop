/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;
import model.Turmas;
import model.Universidade;

/**
 *
 * @author thamires
 */
public class UniversidadeDAO {
    
    private final Connection connection;

    public UniversidadeDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    public void insert(Universidade universidade) throws SQLException{
       
            String sql = "insert into universidade (nome, estado, campus) values (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, universidade.getNome());
            statement.setString(2, universidade.getEstado());
            statement.setString(3, universidade.getCampus());
            
            statement.execute();                     
       
    }
    
    
    public ArrayList<Universidade> findAll() throws SQLException{
    
        String sql = "select * from universidade";
        PreparedStatement statement = connection.prepareStatement(sql); 
        
        return pesquisar(statement);        
    
    }

    private ArrayList<Universidade> pesquisar(PreparedStatement statement) throws SQLException {
        ArrayList<Universidade> universidades = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id"); //nome na coluna
            String nome = resultSet.getString("nome");
            String estado = resultSet.getString("estado");
            String campus = resultSet.getString("campus");
            
            Universidade universidadesBanco = new Universidade(id, nome, estado, campus);
            universidades.add(universidadesBanco);         
        }
        
        return universidades;
    }
    
    
       
    
}
