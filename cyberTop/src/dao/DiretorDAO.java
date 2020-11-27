package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Diretor;

/*Classe de conexão do banco com a tabela Diretor*/
public class DiretorDAO {
    
    //Atributo que recebe a conexão
    private final Connection connection;
    
    //Construtor
    public DiretorDAO(Connection connection) {
        this.connection = connection;
    }
    
    /*
        Método: autenticarUsuario
        Parâmetros: classe Diretor
        Descrição: compara os dados coletado do sistema com o do banco de dados e retorna verdadeiro
        ou falso.
    */
    public boolean autenticarUsuario(Diretor diretor) throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "select * from diretor where login = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
        statement.setString(1, diretor.getLogin());
        statement.setString(2, diretor.getSenha());
        
        //Executa o comando sql
        statement.execute();
        
        //Resultando do select no banco de dados
        ResultSet resultSet = statement.getResultSet();
        
        //Retorna verdadeiro se tiver próxima linha, ou seja, achou o dado no banco
        return resultSet.next(); 
        
    }
    
    
    
}
