/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Alunos;
import model.Turmas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    
    
}
