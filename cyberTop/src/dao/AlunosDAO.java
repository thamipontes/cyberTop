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
import java.util.Date;

/*Classe de conexão do banco com a tabela alunos*/
public class AlunosDAO {
    //Atributo que recebe a conexão
    private final Connection connection;
    //Construtor
    public AlunosDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**/
    public  void remove(Aluno aluno) throws SQLException{
        String sql = "delete from aluno where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,aluno.getId());
        statement.execute();
    }

    /*
        Método: insert
        Parâmetros: classe turmas
        Descrição: insere os dados coletado do sistema no banco de dados   
    */
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
    
     /*
        Método: findAll
        Parâmetros: vazio
        Descrição: retorna uma lista com todos os dados da tabela
    */
    public ArrayList<Aluno> findAll() throws SQLException, ParseException{
        //comando sql que será executado no banco de dados
        String sql = "select id, nome, CPF, data_nascimento, telefone, endereco, genero, cep, cor_raca, id_turma, email, curso from aluno";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisar(statement);
        
    }
    
    // Revisar funcao especialmente o data de nascimento
    
    public ArrayList<Aluno> pesquisar(PreparedStatement statement) throws SQLException, ParseException{
        ArrayList<Aluno> alunos = new ArrayList<>();;
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
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
    
    

    // Tipo data
    public void update(Aluno aluno) throws SQLException{    
        String sql = "update aluno set nome = ?, CPF = ?, " /*data_nascimento = ?,*/+ " telefone = ?, endereco = ?, genero = ?,"
                + " cep = ?, cor_raca = ?, id_turma = ?, email = ?, curso = ? where  id = ?; ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, aluno.getNome());
        statement.setString(2, aluno.getCPF());
        //statement.setString(3, );
        statement.setString(3, aluno.getTelefone());
        statement.setString(4, aluno.getEndereco());
        statement.setString(5, Character.toString(aluno.getGenero()));
        statement.setString(6, aluno.getCEP());
        statement.setString(7, aluno.getCorRaca());
        statement.setInt(8, aluno.getTurmaId());
        statement.setString(9, aluno.getEmail());
        statement.setString(10, aluno.getCurso());
        statement.setInt(11, aluno.getId());
        statement.execute();
    }
    
    public Aluno findById(int idAluno) throws SQLException, ParseException{
    
        String sql = "select * from aluno where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idAluno);        
        return pesquisar(statement).get(0);     
    
    }
    
}
