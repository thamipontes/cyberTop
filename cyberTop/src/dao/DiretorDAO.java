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
import model.Diretor;

/**
 *
 * @author thamires
 */

public class DiretorDAO {
    
    private final Connection connection;

    public DiretorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean autenticarUsuario(Diretor diretor) throws SQLException{
    
        String sql = "select * from diretor where login = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, diretor.getLogin());
        statement.setString(2, diretor.getSenha());
        statement.execute();            
        //Resultando do select no banco de dados
        ResultSet resultSet = statement.getResultSet();
        
        return resultSet.next(); //Se tem proxima linha
        
    }
    
    
    
}
