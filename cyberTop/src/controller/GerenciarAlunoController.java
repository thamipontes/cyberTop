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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Turmas;
import telas.CadastroAluno;
import telas.CadastroTurma;
import telas.GerenciarAluno;


public class GerenciarAlunoController {
    private final GerenciarAluno view;
    
    public GerenciarAlunoController(GerenciarAluno view){
        this.view = view;
    }
    // Metodo que vai setar as informações do aluno selecionado na tabela para o campo de dados
    public void editar() throws SQLException, ParseException{
        if(view.getTblAluno().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione algum aluno para poder editar.");
        }else{
        
            ArrayList<Aluno> alunoBanco = carregarDadosAluno();
            int linha = view.getTblAluno().getSelectedRow();

            if(linha >= 0 && linha < alunoBanco.size()){
                Aluno aluno = alunoBanco.get(linha);
                
                view.getTxtNome().setText(aluno.getNome());
                view.getTxtCPF().setText(aluno.getCPF());
                view.getTxtEmail().setText(aluno.getEmail());
                view.getTxtTelefone().setText(aluno.getTelefone());
                view.getTxtCEP().setText(aluno.getCEP());
                view.getTxtLogradouro().setText(aluno.getEndereco());
                view.getTxtCurso().setText(aluno.getCurso());
                view.getCmbGenero().setSelectedItem(tratarGenero(aluno));
                view.getCmbCorRaca().setSelectedItem(tratarCorRaca(aluno));
                
                
                view.getTxtDataNascimento().setText("00/00/0000");
                
                
                
            

            }
        }
   }
    //Limpas todos os campos de texto
    public void limparCampos(){
        view.getTxtNome().setText("");
        view.getTxtCPF().setText("");
        view.getTxtEmail().setText("");
        view.getTxtTelefone().setText("(  )      -    ");
        view.getTxtCEP().setText("     -   ");
        view.getTxtLogradouro().setText("");
        view.getTxtCurso().setText("");
        view.getCmbGenero().setSelectedItem("Selecione");
        view.getCmbCorRaca().setSelectedItem("Selecione");
        view.getTxtDataNascimento().setText("  /  /    ");
    }
    
    
    //Tratar Dados para inserir nos campos 
    public String tratarCorRaca(Aluno alun){
        if(alun.getCorRaca().equals("Não declarar")) return alun.getCorRaca();
        if(alun.getCorRaca().equals("Preta")) return alun.getCorRaca();
        if(alun.getCorRaca().equals("Parda")) return alun.getCorRaca();
        if(alun.getCorRaca().equals("Indígena")) return alun.getCorRaca();
        if(alun.getCorRaca().equals("Amarela")) return alun.getCorRaca();
        if(alun.getCorRaca().equals("Branca")) return alun.getCorRaca();
        return "Selecione";
    }
    
    
    public String tratarGenero(Aluno alun){
        if(alun.getGenero() == 'I') return "Prefiro não informar";
        if(alun.getGenero() == 'M')return "Masculino";
        if(alun.getGenero() == 'F') return "Feminino";
        if(alun.getGenero() == 'O') return "Outros";
        return "Selecione";
    }
    
    
    public static ArrayList<Aluno> carregarDadosAluno() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        
        ArrayList<Aluno> alunoBanco = alunoDAO.findAll();
        
        return alunoBanco;
    }
    
    public static ArrayList<Turmas> carregarDadosTurma() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        
        ArrayList<Turmas> turmaBanco = turmaDAO.findAll();
        
        return turmaBanco;
    }
    
    public void inserirDadosAlunoTabela() throws SQLException, ParseException{
        ArrayList<Aluno> alunosBanco = carregarDadosAluno();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Turma"}, 0);
        
        
        alunosBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getTurmaId()};
            modelo.addRow(linha);        
        });
        
        view.getTblAluno().setModel(modelo);
        
    }
    
    public  void removerLinhaAluno() throws SQLException, ParseException{
        
        
        if(view.getTblAluno().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione algum aluno para poder remover.");
        }else{
        
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
        limparCampos();
        desativarCampos();
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
    
    
    // ativar e desativar os campos de texto na tela
    public void ativarCampos(){
        view.getTxtNome().setEnabled(true);
        view.getTxtCPF().setEnabled(true);
        view.getTxtCEP().setEnabled(true);
        view.getTxtDataNascimento().setEnabled(true);
        view.getTxtLogradouro().setEnabled(true);
        view.getTxtCurso().setEnabled(true);
        view.getCmbGenero().setEnabled(true);
        view.getCmbCorRaca().setEnabled(true);
        view.getTxtEmail().setEnabled(true);
        view.getTxtTelefone().setEnabled(true);

    }
    
    public void desativarCampos(){
        view.getTxtNome().setEnabled(false);
        view.getTxtCPF().setEnabled(false);
        view.getTxtCEP().setEnabled(false);
        view.getTxtDataNascimento().setEnabled(false);
        view.getTxtLogradouro().setEnabled(false);
        view.getTxtCurso().setEnabled(false);
        view.getCmbGenero().setEnabled(false);
        view.getCmbCorRaca().setEnabled(false);
        view.getTxtEmail().setEnabled(false);
        view.getTxtTelefone().setEnabled(false);
    }
    
    
    
    /*
    public void buscarAlunoPorId() throws SQLException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
        Turmas turma = alunoDAO.findById(Integer.parseInt(view.getTxtTurma().getText())); 
            
        return turma; 
        
    }
    */
}
