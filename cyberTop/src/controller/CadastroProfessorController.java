package controller;

import dao.Conexao;
import dao.ProfessorDAO;

import interfaces.Cadastrar;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Professor;
import model.Turmas;
import telas.CadastroProfessor;

/*Classe que controla todas as regras de negócios do cadastro do Professor*/
public class CadastroProfessorController implements Cadastrar{
    
    //Declaração do atributo que possui a tela CadastroProfessor
    private final CadastroProfessor view;
    
    //Construtor
    public CadastroProfessorController(CadastroProfessor view){
        this.view = view;
    }
    
    /*
        Método: salvarCadastro
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */    
    @Override
    public void salvarCadastro() {
        
        /*Pegas as informações passadas nos campos da tela*/
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String telefone = view.getTxtTelefone().getText();
        String endereco = view.getTxtLogradouro().getText();
        String materia = view.getTxtMateria().getText();
        String nomeTurma = view.getCmbTurmaProfessor().getSelectedItem().toString();
        
        
        /*Tratando o dado Data de Nascimento*/
        String dataNascimentoString = view.getTxtDataNascimento().getText();
        //define padrão que a data deve obedecer
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); 
        //Transforma o atributo em tipo calendar
        Calendar dataNascimento = Calendar.getInstance();        
        try {
            //Seta a data no atributo data nascimento
            dataNascimento.setTime(sdf.parse(dataNascimentoString));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroProfessorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*Tratando o dado Genero*/  
       //Variável que recebe o return do método formatarGenero que está implementado no final do código
        char genero = CadastroAlunoController.formatarGenero((view.getCmbGenero().getSelectedIndex()));
        
        /*Instaciando o objeto professor com os dados recebidos pela tela*/
        Professor professor = new Professor(nome, cpf, dataNascimento, telefone, endereco, genero, materia, nomeTurma);
        
         /*Conexão com o banco de dados para salvar os dados do aluno na tabela professor*/
        Connection conexao;
        try {
            //Faz a conexão com o banco
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe ProfessorDAO que possui o CRUD
            ProfessorDAO professorDAO = new ProfessorDAO(conexao);
            //Chama o método de inserção 
            professorDAO.insert(professor);
            //Mensagem de professor cadastrado com sucesso
            JOptionPane.showMessageDialog(null, "Professor criado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProfessorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao criar professor!");
        }
 
        
    }
    
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: confere se teve algum campo que ficou sem ser preenchido e mostra na tela
        uma mensagem para preencher todos os campos.
    */
    public boolean exibirAlertarCampos(){
        if(view.getTxtNome().getText().equals("")                       ||
            view.getTxtCPF().getText().equals("   .   .   -  ")         || 
            view.getTxtDataNascimento().getText().equals("  /  /    ")  ||
            view.getCmbGenero().getSelectedItem().equals("Selecione")   ||
            view.getCmbCorRaca().getSelectedItem().equals("Selecione")  ||
            view.getTxtTelefone().getText().equals("(  )      -    ")   ||
            view.getTxtCEP().getText().equals("     -   ")              ||
            view.getTxtLogradouro().getText().equals("")                ||
            view.getTxtMateria().getText().equals("")
                ){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
        }
        
        return false;            
    }
    
     /*
        Método: limparCampos
        Parâmetros: vazio
        Descrição: deixa todos os campos da tela vazio
    */
    @Override
    public void limparCampos(){    
    //Insere o cursor no txtNome e o deixa em foco
        view.getTxtNome().requestFocus();

        // Limpa todos os campos
        view.getTxtNome().setText("");
        view.getTxtCPF().setText("");
        view.getTxtDataNascimento().setText("");
        view.getCmbCorRaca().setSelectedItem("Selecione");
        view.getCmbGenero().setSelectedItem("Selecione");
        view.getTxtTelefone().setText("");
        view.getTxtCEP().setText("");
        view.getTxtLogradouro().setText("");
        view.getTxtMateria().setText("");
    
    }
    
    
     /*
        Método: inserirDadosTurmaCmB
        Parâmetros: vazio
        Descrição: insere os dados das turmas vindos do banco de dados
        no combo box que representa a turma que ele irá administrar a aula.
    */
    public void inserirDadosTurmaCmB() throws SQLException{
        
        ArrayList<Turmas> turmas = CadastroAlunoController.carregarDadosTurma();
        view.getCmbTurmaProfessor().removeAllItems();
        view.getCmbTurmaProfessor().addItem("Selecione");
        turmas.forEach(t -> {
            view.getCmbTurmaProfessor().addItem(t.getNome());        
        });  
   
    }

    

    @Override
    public void removerCadastro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarCadastro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
