package dao;

import model.Turmas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*Classe de conexão do banco com a tabela turma*/
public class TurmaDAO {
    //Atributo que recebe a conexão
    private final Connection connection;
    //Construtor
    public TurmaDAO(Connection connection) {
        this.connection = connection;
    }
    
    /*
        Método: insert
        Parâmetros: classe turmas
        Descrição: insere os dados coletado do sistema no banco de dados   
    */
    public void insert(Turmas turma) throws SQLException{
            //comando sql que será executado no banco de dados
            String sql = "insert into turma (nome, horario, tipo, periodo, vagas, universidade) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
            statement.setString(1, turma.getNome());
            statement.setString(2, turma.getHorario());
            statement.setBoolean(3, turma.getTipo());
            statement.setBoolean(4, turma.getPeriodo());
            statement.setInt(5, turma.getVagas());
            statement.setString(6, turma.getNomeUniversidade());
            
            //Executa o comando sql
            statement.execute();           
            connection.close();            
       
    }
    
        
    /*
        Método: update
        Parâmetros: classe turmas
        Descrição: atualiza os dados no banco de dados  
    */
    public void update(Turmas turma) throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "update turma set nome = ?, horario = ?, tipo = ?, periodo = ?, vagas = ?, universidade = ? where id = ?; ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
        statement.setString(1, turma.getNome());
        statement.setString(2, turma.getHorario());
        statement.setBoolean(3, turma.getTipo());
        statement.setBoolean(4, turma.getPeriodo());
        statement.setInt(5, turma.getVagas());
        statement.setString(6, turma.getNomeUniversidade());
        statement.setInt(7, turma.getId());
        
        //Executa o comando sql
        statement.execute(); 
    
    }
    
    
    /*
        Método: delete
        Parâmetros: classe turmas
        Descrição: deleta um dado no banco de dados de acordo com o id
    */
    public void delete(Turmas turma) throws SQLException{
        
        //comando sql que será executado no banco de dados
        String sql = "delete from turma where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
        statement.setInt(1, turma.getId());
        
        //Executa o comando sql
        statement.execute();    
    }
    
    /*
        Método: findAll
        Parâmetros: vazio
        Descrição: retorna uma lista com todos os dados da tabela
    */
    public ArrayList<Turmas> findAll() throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "select id, nome, horario, tipo, periodo, vagas, universidade from turma";
        
        PreparedStatement statement = connection.prepareStatement(sql); 
        
        return pesquisar(statement);        
    
    }
    
    
    /*
        Método: pesquisar
        Parâmetros: PreparedStament
        Descrição: retorna uma lista com todos os dados da tabela
    */
    private ArrayList<Turmas> pesquisar(PreparedStatement statement) throws SQLException {
        //Cria uma lista vazia de turmas
        ArrayList<Turmas> turmas = new ArrayList<>();
        //Executa o comando sql
        statement.execute();
        //Armazena o resultado da pesquisa sql na variável
        ResultSet resultSet = statement.getResultSet();
        
        //Enquanto tiver uma próxima linha, seta os dados do banco de acordo com o campo na variável
        while(resultSet.next()){
            int id = resultSet.getInt("id"); //nome na coluna
            String nome = resultSet.getString("nome");
            String horario = resultSet.getString("horario");
            boolean tipo = resultSet.getBoolean("tipo");
            boolean periodo = resultSet.getBoolean("periodo");
            int vagas = resultSet.getInt("vagas");
            String nomeUniversidade = resultSet.getString("universidade");
            
            //Instancia o objeto de acordo com os dados trazidos do banco
            Turmas turmaBanco = new Turmas(id, nome, horario, tipo, periodo, vagas, nomeUniversidade);
            //Adiciona o objeto instanciado na lista
            turmas.add(turmaBanco);         
        }
        //Retorna a lista
        return turmas;
    }
    
    /*
        Método: finfById
        Parâmetros: inteiro
        Descrição: procura e retorna uma turma conforme o id no banco
    */
    public Turmas findById(int idTurma) throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "select * from turma where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //Substitui a interrogação pelo id da turma
        statement.setInt(1, idTurma);        
        return pesquisar(statement).get(0); //retorna a primeira linha do resultado    
    
    }   
    
    
}
