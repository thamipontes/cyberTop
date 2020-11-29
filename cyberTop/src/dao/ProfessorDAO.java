package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Professor;

/*Classe de conexão do banco com a tabela professor*/
public class ProfessorDAO {
    //Atributo que recebe a conexão
    private final Connection connection;
    //Construtor
    public ProfessorDAO(Connection connection) {
        this.connection = connection;
    }
    
    /*
        Método: insert
        Parâmetros: classe professor
        Descrição: insere os dados coletado do sistema no banco de dados   
    */ 
    public void insert(Professor professor) throws SQLException{
            //comando sql que será executado no banco de dados
            String sql = "insert into professor (nome, cpf, data_nascimento, telefone, endereco, genero, materia, turma) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //Substitui cada interrogação, na ordem, pelo valor capturado do sistema (getters)
            statement.setString(1, professor.getNome());
            statement.setString(2, professor.getCPF());
            statement.setDate(3, new java.sql.Date(professor.getDataNascimento().getTimeInMillis()));
            statement.setString(4, professor.getTelefone());
            statement.setString(5, professor.getEndereco());
            statement.setString(6, String.valueOf(professor.getGenero()));
            statement.setString(7, professor.getMateria());
            statement.setString(8, professor.getNomeTurma());
            
            //Executa o comando sql
            statement.execute();            
            connection.close();         
       
    }
    
    /*
        Método: insert
        Parâmetros: classe Professor
        Descrição: deleta os dados coletado do sistema no banco de dados   
    */ 
    public  void remove(Professor professor) throws SQLException{
        String sql = "delete from professor where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,professor.getId());
        statement.execute();
    }

    
    public ArrayList<Professor> findAll() throws SQLException, ParseException{
        String sql = "select id, nome, cpf, data_nascimento, telefone, endereco, genero, materia, turma from professor;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisar(statement);
                
    }
    
    
    /*
        Método: update
        Parâmetros: classe professor
        Descrição: atualiza os dados no banco de dados  
    */
    public void update(Professor professor) throws SQLException{
        //comando sql que será executado no banco de dados
        String sql = "update professor set nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, endereco = ?, genero = ?, materia = ?, turma = ? where id = ?; ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, professor.getNome()); 
        statement.setString(2, professor.getCPF());
        statement.setDate(3, new java.sql.Date(professor.getDataNascimento().getTimeInMillis()));
        statement.setString(4, professor.getTelefone());
        statement.setString(5, professor.getEndereco());
        statement.setString(6, Character.toString(professor.getGenero()));
        statement.setString(7, professor.getMateria());
        statement.setString(8, professor.getNomeTurma());
        
        statement.setInt(9, professor.getId());
        // Executa o comando no banco de dados
        statement.execute();
    
    }
    
    
    
    public ArrayList<Professor> pesquisar(PreparedStatement statement) throws SQLException, ParseException{
        //Cria uma lista vazia de universidades
        ArrayList<Professor> professor = new ArrayList<>();
        //Executa o comando sql
        statement.execute();
        //Armazena o resultado da pesquisa sql na variável
        ResultSet resultSet = statement.getResultSet();
        //Enquanto tiver uma próxima linha, seta os dados do banco de acordo com o campo na variável
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            Date dataNascimentoBanco = resultSet.getDate("data_nascimento");
            Calendar dataNascimento = Calendar.getInstance();             
            dataNascimento.setTime(dataNascimentoBanco); 
            
            String telefone = resultSet.getString("telefone");
            String endereco = resultSet.getString("endereco");
            String genero1 = resultSet.getString("genero");
            char genero = genero1.charAt(0);
   
            String materia = resultSet.getString("materia");
            String turma = resultSet.getString("turma");
            //Instancia o objeto de acordo com os dados trazidos do banco
            Professor professorBanco = new Professor(id, nome, cpf, dataNascimento, telefone, endereco, genero, materia, turma);
            //Adiciona o objeto instanciado na lista
            professor.add(professorBanco);
            
        }
        //Retorna a lista 
        return professor;
    }
    
    
    public Professor findById(int id) throws SQLException, ParseException{
    
        String sql = "select * from professor where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        //JOptionPane.showMessageDialog(null, pesquisar(statement).get(0));
        return pesquisar(statement).get(0);     
    
    }
}
