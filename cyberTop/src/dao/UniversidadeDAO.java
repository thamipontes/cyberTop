package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Turmas;
import model.Universidade;

/*Classe de conexão do banco com a tabela universidade*/
public class UniversidadeDAO {
    //Atributo que recebe a conexão
    private final Connection connection;
    //Construtor
    public UniversidadeDAO(Connection connection) {
        this.connection = connection;
    }
    
    /*
        Método: insert
        Parâmetros: classe universidade
        Descrição: insere os dados coletado do sistema no banco de dados   
    */ 
    public void insert(Universidade universidade) throws SQLException{
            //comando sql que será executado no banco de dados
            String sql = "insert into universidade (nome, estado, campus) values (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
            statement.setString(1, universidade.getNome());
            statement.setString(2, universidade.getEstado());
            statement.setString(3, universidade.getCampus());
            
            //Executa o comando sql
            statement.execute();                     
       
    }
    
    /*
        Método: remove
        Parâmetros: classe universidade
        Descrição: deleta os dados coletado do sistema no banco de dados   
    */ 
    public  void remove(Universidade universidade) throws SQLException{
        String sql = "delete from universidade where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,universidade.getId());
        statement.execute();
    }
    
    /*
        Método: findAll
        Parâmetros: vazio
        Descrição: retorna uma lista com todos os dados da tabela
    */
    public ArrayList<Universidade> findAll() throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "select * from universidade";
        PreparedStatement statement = connection.prepareStatement(sql); 
        
        return pesquisar(statement);        
    
    }
    

    /*
        Método: pesquisar
        Parâmetros: PreparedStament
        Descrição: retorna uma lista com todos os dados da tabela
    */
    private ArrayList<Universidade> pesquisar(PreparedStatement statement) throws SQLException {
        //Cria uma lista vazia de universidades
        ArrayList<Universidade> universidades = new ArrayList<>();
        //Executa o comando sql
        statement.execute();
        //Armazena o resultado da pesquisa sql na variável
        ResultSet resultSet = statement.getResultSet();
        
        //Enquanto tiver uma próxima linha, seta os dados do banco de acordo com o campo na variável
        while(resultSet.next()){
            int id = resultSet.getInt("id"); //nome na coluna
            String nome = resultSet.getString("nome");
            String estado = resultSet.getString("estado");
            String campus = resultSet.getString("campus");
            
            //Instancia o objeto de acordo com os dados trazidos do banco
            Universidade universidadesBanco = new Universidade(id, nome, estado, campus);
            //Adiciona o objeto instanciado na lista
            universidades.add(universidadesBanco);         
        }
        //Retorna a lista 
        return universidades;
    }
    
    public void update(Universidade universidade) throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "update universidade set nome = ?, campus = ?, estado = ? where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        JOptionPane.showMessageDialog(null, universidade.toString());
        //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
        statement.setString(1, universidade.getNome());
        statement.setString(2, universidade.getCampus());
        statement.setString(3, universidade.getEstado());
        statement.setInt(4, universidade.getId());
        
        //Executa o comando sql
        statement.execute(); 
    
    }

    public Universidade findById(int id) throws SQLException {
        String sql = "select * from universidade where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        //JOptionPane.showMessageDialog(null, pesquisar(statement).get(0));
        return pesquisar(statement).get(0);
    }
       
    
}
