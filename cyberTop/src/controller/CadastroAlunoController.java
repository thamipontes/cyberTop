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
import interfaces.Cadastrar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turmas;
import telas.CadastroTurma;


/*Classe que controla todas as regras de negócios do cadastro do Aluno*/
public class CadastroAlunoController implements Cadastrar{
    
    //Declaração do atributo que possui a tela CadastroAluno
    private final CadastroAluno view;
    

    //Construtor
    public CadastroAlunoController(CadastroAluno view) {
        this.view = view;
    }
    

    /*
        Método: salvarCadastro
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */    
    @Override
    public void salvarCadastro(){
        
        /*Pegas as informações passadas nos campos da tela*/
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String telefone = view.getTxtTelefone().getText();
        String endereco = view.getTxtLogradouro().getText();
        String cep = view.getTxtCEP().getText();
        String email = view.getTxtEmail().getText();
        String curso = view.getTxtCurso().getText();
        
        /*Tratando o dado Data de Nascimento*/   
        //Pega o texto que está no campo data de nascimento
        String dataNascimentoString = view.getTxtDataNascimento().getText();
        //define padrão que a data deve obedecer
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); 
        //Transforma o atributo em tipo calendar
        Calendar dataNascimento = Calendar.getInstance();
        try {
            //Seta a data no atributo data nascimento
            dataNascimento.setTime(sdf.parse(dataNascimentoString));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroAlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
       Aluno aluno = new Aluno(nome, cpf, dataNascimento, telefone, endereco, genero, cep, corRaca, turmaId, email, curso);
       
       /*Atualizando o atributo vagas no banco de dados*/
        try {
            //Método que atualiza a tabela turma diminuindo a vagas toda vez que um aluno é criado na turma específica
            diminuirVagasTurma();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       /*Conexão com o banco de dados para salvar os dados do aluno na tabela aluno*/
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
    public static char formatarGenero(int index){        
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
        view.getTxtEmail().setText("");
        view.getTxtCurso().setText("");
    
    }
    
    /*
        Método: carregarDadosTurma
        Parâmetros: vazio
        Descrição: retorna a lista de turmas que está persistido no banco de dados
    */
     public static ArrayList<Turmas> carregarDadosTurma() throws SQLException {
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
    
    
    /*
        Método: pesquisarTurmaPorId
        Parâmetros: vazio
        Descrição: procura no banco a turma correspondente ao id passado no campo
        turma id da tela.
    */ 
    public Turmas pesquisarTurmaPorId() throws SQLException{               
            //Faz a conexão com o banco 
            Connection conexao;
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe TurmaDAO para realizar o CRUD
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
            Turmas turma = turmaDAO.findById(Integer.parseInt(view.getTxtTurma().getText())); 
            
            return turma; 
    }
    
    
    /*
        Método: inserirTurmaPorIdTabela
        Parâmetros: vazio
        Descrição: insere na tabela a turma correspondente ao id passado no campo
        turma id da tela.
    */
    public void inserirTurmaPorIdTabela() throws SQLException{        
        
        
        //Chama o método que irá retorna uma turma de acordo com o Id
        Turmas turma = pesquisarTurmaPorId();
        
        
        //Cria o modelo da tabela
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Horário", "Período", "Vagas"}, 0);
        
        //Insere a turma na linha da tabela       
        Object linha[] = new Object[]{turma.getId(), turma.getNome(), turma.getHorario(), turma.getPeriodo(), turma.getVagas()};
        modelo.addRow(linha);              
        
        //Seta na tabela os valores da linha
        view.getTblTurmas().setModel(modelo);             
        
    }
    
    
     /*
        Método: diminuirVagasTurma()
        Parâmetros: vazio
        Descrição: pesquisa a turma pelo id e atualiza o campo vagas da tabela turma 
        diminuindo 1 na quantidade de vagas no banco e insere os dados da turma novamente na tabela da tela.
    */
    public void diminuirVagasTurma() throws SQLException{
    
        Turmas turma = pesquisarTurmaPorId();
        
        int vagasAtual = turma.getVagas(); 
        turma.setVagas(vagasAtual -1);     
        
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
            
        turmaDAO.update(turma);
        
        inserirDadosTurmaTabela();    
 
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
