package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    
    
}
