package controller;

import dao.AlunosDAO;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Aluno;

import telas.CadastroAluno;
import dao.Conexao;
import dao.TurmaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turmas;
import telas.CadastroTurma;

/**
 *
 * @author thamires
 */

/*Classe que controla todas as regras de negócios do cadastro do Aluno*/
public class CadastroAlunoController {
    
    //Declaração do atributo que possui a tela CadastroAluno
    private CadastroAluno view;
    

    //Construtor
    public CadastroAlunoController(CadastroAluno view) {
        this.view = view;
    }

    /*
        Método: salvarAluno
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */
    public void salvarAluno() throws ParseException, SQLException{
        
        /*Pegas as informações passadas nos campos da tela*/
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String telefone = view.getTxtTelefone().getText();
        String endereco = view.getTxtLogradouro().getText();
        String cep = view.getTxtCEP().getText();
        
        /*Tratando o dado Data de Nascimento*/   
        //Pega o texto que está no campo data de nascimento
        String dataNascimentoString = view.getTxtDataNascimento().getText();
        //define padrão que a data deve obedecer
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); 
        //Transforma o atributo em tipo calendar
        Calendar dataNascimento = Calendar.getInstance();
        //Seta a data no atributo data nascimento
        dataNascimento.setTime(sdf.parse(dataNascimentoString));  
    
       /*Tratando o dado Genero*/  
       //Variável que recebe o return do método formatarGenero que está implementado no final do código
        char genero = formatarGenero((view.getCmbGenero().getSelectedIndex()));        
    
       /*Tratando o dado Cor Raça*/
       //Transforma o o texto do item selecionado em string e guarda na variável
        String corRaca = view.getCmbCorRaca().getSelectedItem().toString();
        
       /*Tratando o dado da turma*/
       //Transforma String em inteiro
        int turmaId = Integer.parseInt(view.getTxtTurma().getText());
    
       /*Instaciando o objeto aluno com os dados recebidos pela tela*/
       Aluno aluno = new Aluno(nome, cpf, dataNascimento, telefone, endereco, genero, cep, corRaca, turmaId);
       
       /*Conexão com o banco de dados*/
        Connection conexao;        
        try {
            //Faz a conexão com o banco
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe AlunosDAO que possui o CRUD
            AlunosDAO alunoDAO = new AlunosDAO(conexao);
            //Chama o método de inserção            
            alunoDAO.insert(aluno);        
            //Mensagem de aluno cadastrado com sucesso
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            //Caso dê erro mostra essa tela
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar dado no banco");
        }  
    
    }
    
    /*
        Método: formatarGenero
        Parâmetros: index do tipo inteiro
        Descrição: Confere qual index foi selecionado na tela cadastro aluno do campo gênero 
    e retorna um char que indica se o gênero é não informado, masculino, feminino e outros    
    */
    public char formatarGenero(int index){        
        if(index == 1) return 'I'; //Prefiro não informar
        if(index == 2) return 'M'; //Masculino
        if(index == 3) return 'F'; //Feminino
        if(index == 4) return 'O'; //Outros       
        return ' '; 
    }
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: confere se teve algum campo que ficou sem ser preenchido e mostra na tela
        uma mensagem para preencher todos os campos.
    */
    public boolean exibirAlertarCampos(){        
        //Descobre se algum dos campos ficou vazio
        if(view.getTxtNome().getText().equals("")                       ||
            view.getTxtCPF().getText().equals("   .   .   -  ")         || 
            view.getTxtDataNascimento().getText().equals("  /  /    ")  ||
            view.getCmbGenero().getSelectedItem().equals("Selecione")   ||
            view.getCmbCorRaca().getSelectedItem().equals("Selecione")  ||
            view.getTxtTelefone().getText().equals("(  )      -    ")   ||
            view.getTxtCEP().getText().equals("     -   ")              ||
            view.getTxtLogradouro().getText().equals("")                ||
            view.getTxtEmail().getText().equals("")                     ||
            view.getTxtCurso().getText().equals("")
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
        view.getTxtEmail().setText("");
        view.getTxtCurso().setText("");
    
    }
    
    /*
        Método: carregarDadosTurma
        Parâmetros: vazio
        Descrição: retorna a lista de turmas que está persistido no banco de dados
    */
     private ArrayList<Turmas> carregarDadosTurma() throws SQLException {
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
        ArrayList<Turmas> turmasBanco = turmaDAO.findAll();
        return turmasBanco;
    }
    
    /*
        Método: inserirDadosTurmaTabela
        Parâmetros: vazio
        Descrição: insere as informações da tabela turma do banco de dados na tabela da tela
    */
    public void inserirDadosTurmaTabela() throws SQLException{
        
        //Variável que possui uma lista de turmas vinda do banco de dados
        ArrayList<Turmas> turmasBanco = carregarDadosTurma();
        
        //Cria o modelo da tabela
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Horário", "Período", "Vagas"}, 0);
        
        //Percorre a lista de turmas vinda do banco e insere em cada linha
        turmasBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getHorario(), e.getPeriodo(), e.getVagas()};
            modelo.addRow(linha);        
        });        
        
        //Seta na tabela todos os valores vindo da lista
        view.getTblTurmas().setModel(modelo);
    
    }
    
    /*
        Método: salvarLinhaTurma
        Parâmetros: vazio
        Descrição: insere no campo turma da tela o id da turma que foi selecionada da tabela 
        ao clicar na linha
    */   
    public void salvarLinhaTurma() throws SQLException {
        //Variável que possui uma lista de turmas vinda do banco de dados
        ArrayList<Turmas> turmasBanco = carregarDadosTurma();
        
        //Variável que possui a linha que foi clicada
        int linha = view.getTblTurmas().getSelectedRow();
        
        //Conferindo se é uma linha inválida
        if(linha >= 0 && linha<turmasBanco.size()){
            //variável que recebe a turma que está na linha selecionada
            Turmas turma = turmasBanco.get(linha);
            //Seta no campo turma da tela o id da turma
            view.getTxtTurma().setText(String.valueOf(turma.getId()));
            //Desabilita o campo turma da tela
            //view.getTxtTurma().setEnabled(false);

        }  
    
    }
    
}
