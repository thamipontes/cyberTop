package controller;

import dao.AlunosDAO;
import dao.Conexao;
import dao.TurmaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Turmas;
import telas.CadastroTurma;
import telas.GerenciarAluno;

/**
 *
 * @author Jhonatan Borges
 */
public class GerenciarAlunoController {
    private final GerenciarAluno view;
    
    public GerenciarAlunoController(GerenciarAluno view){
        this.view = view;
    }
    
    public static ArrayList<Aluno> carregarDadosAluno() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        
        ArrayList<Aluno> alunoBanco = alunoDAO.findAll();
        
        return alunoBanco;
    }
    
    public void inserirDadosAlunoTabela() throws SQLException, ParseException{
        ArrayList<Aluno> alunosBanco = carregarDadosAluno();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Data de Nascimento"}, 0);
        
        
        alunosBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getDataNascimento()};
            modelo.addRow(linha);        
        });
        
        view.getTblAluno().setModel(modelo);
        
    }
    
    public  void removerLinhaAluno() throws SQLException, ParseException{
        ArrayList<Aluno> alunoBanco = carregarDadosAluno();
        int linha = view.getTblAluno().getSelectedRow();
        
        if(linha >= 0 && linha < alunoBanco.size()){
            Aluno aluno = alunoBanco.get(linha);
            /*Conexão com o banco de dados para salvar os dados do aluno na tabela aluno*/
        Connection conexao;        
        try {
            //Faz a conexão com o banco
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe AlunosDAO que possui o CRUD
            AlunosDAO alunoDAO = new AlunosDAO(conexao);
            //Chama o método de inserção            
            alunoDAO.remove(aluno);
            //Mensagem de aluno cadastrado com sucesso
            JOptionPane.showMessageDialog(null, "Aluno descadastrado com sucesso");
            inserirDadosAlunoTabela();
            
            aumentarVagasTurma(aluno.getTurmaId());
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            //Caso dê erro mostra essa tela
            JOptionPane.showMessageDialog(null, "Falha ao descadastrar dado no banco");
        }  
            
        }
        
        
    }
    
    
    
    
    public void aumentarVagasTurma(int idTurma) throws SQLException{
    
        Turmas turma = pesquisarTurmaPorId(idTurma);
        
        int vagasAtual = turma.getVagas(); 
        turma.setVagas(vagasAtual +1);     
        
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
            
        turmaDAO.update(turma);
 
    }
    
    public Turmas pesquisarTurmaPorId(int idTurma) throws SQLException{               
            //Faz a conexão com o banco 
            Connection conexao;
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe TurmaDAO para realizar o CRUD
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
            Turmas turma = turmaDAO.findById(idTurma); 
            
            return turma; 
    }
    
    
}
