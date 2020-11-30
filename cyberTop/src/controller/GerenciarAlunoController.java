package controller;

import dao.AlunosDAO;
import dao.Conexao;
import dao.TurmaDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Turmas;

import telas.GerenciarAluno;


public class GerenciarAlunoController{
    //Declaração do atributo que possui a tela CadastroTurma
    private final GerenciarAluno view;
    
    //Construtor
    public GerenciarAlunoController(GerenciarAluno view){
        this.view = view;
    }
    
    /*
        Método: editar
        Parâmetros: vazio
        Descrição: Ao clicar no botão editar, caso não tenha alguma linha selecionada mostra mensagem, senão
        some com os botões principais e mostra o botão salvar e cancelar.
    */
    public void editar() throws ParseException, SQLException{
        if(view.getTblAluno().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione algum aluno para poder editar.");
        }else{
            //Ativa os campos para poder preencher com novos dados
            ativarCampos();
            //Torna os botões invisiveis
            view.getLblCadastrar().setVisible(false);
            view.getLblEditar().setVisible(false);
            view.getLblRemover().setVisible(false);
            view.getLblBuscar().setVisible(false);
            //Torna os botões visiveis
            view.getLblCancelar().setVisible(true);
            view.getLblSalvar().setVisible(true);
        }
        
    }
    
    
    
    /*
        Método: salvarEditar
        Parâmetros: vazio
        Descrição: Ao clicar no botão editar, caso não tenha alguma linha selecionada mostra mensagem, senão
        some com os botões principais e mostra o botão salvar e cancelar.
    */
    public void salvarEditar() throws ParseException, SQLException{
        
        if(!exibirAlertarCampos()){
            /*Pegas as informações passadas nos campos da tela*/
            String nome = view.getTxtNome().getText();
            String cpf = view.getTxtCPF().getText();
            String telefone = view.getTxtTelefone().getText();
            String endereco = view.getTxtLogradouro().getText();
            String cep = view.getTxtCEP().getText();
            String email = view.getTxtEmail().getText();
            String curso = view.getTxtCurso().getText();
            int idTurmaNovo = Integer.parseInt(view.getTxtIdTurma().getText());

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
            //Variável que recebe o return do método formatarGenero que está implementado no codigo
            char genero = formatarGenero((view.getCmbGenero().getSelectedIndex()));        

            /*Tratando o dado Cor Raça*/
            //Transforma o o texto do item selecionado em string e guarda na variável
            String corRaca = view.getCmbCorRaca().getSelectedItem().toString();
            
             /*Tratando o dado da turma*/ 
            int id = tratarVagas(idTurmaNovo);


            /*Instaciando o objeto aluno com os dados recebidos pela tela*/
            Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, telefone, endereco, genero, idTurmaNovo, cep, corRaca, email, curso);

    
            
            /*Conexão com o banco de dados para salvar os dados do aluno na tabela aluno*/
            Connection conexao;        
            try {
            //Faz a conexão com o banco
                conexao = new Conexao().getConnection();
                //Passa a conexão para a classe AlunosDAO que possui o CRUD
                AlunosDAO alunoDAO = new AlunosDAO(conexao);
               //Chama o método de inserção            
                alunoDAO.update(aluno);
                //Mensagem de aluno cadastrado com sucesso
                JOptionPane.showMessageDialog(null, "Aluno editado com sucesso");
                inserirDadosAlunoTabela();

            } catch (SQLException ex) {
                Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }
                //Voltar a tela como tava inicialmente
                cancelar();
        }
    }
    
    
   /*
        Método: tratarVagas
        Parâmetros: inteiro
        Descrição: aumentar e diminuir vagas caso o aluno troque de turma
    */
    private int tratarVagas(int idTurmaNovo) throws SQLException, ParseException {
                       
        ArrayList<Aluno> alunoBanco = carregarDadosAluno();
        int linha = view.getTblAluno().getSelectedRow();
        int id = 0;
        if(linha >= 0 && linha < alunoBanco.size()){
            Aluno alun = alunoBanco.get(linha);
            id = alun.getId();
            
            int turmaIdVelho = pesquisarTurmaPorId(alun.getTurmaId()).getId();
            //Só muda as vagas se houver mudança de turma
            if(turmaIdVelho != idTurmaNovo){
                diminuirVagasTurma(idTurmaNovo);
                aumentarVagasTurma(turmaIdVelho);
            }
        }
        return id;
    }
    
    
    /*
        Método: cancelar
        Parâmetros: vazio
        Descrição: volta a tela como estavam antes   
    */
    public void cancelar() throws SQLException, ParseException{
        view.getLblCadastrar().setVisible(true);
        view.getLblEditar().setVisible(true);
        view.getLblEditar().setEnabled(false);
        view.getLblRemover().setVisible(true);
        view.getLblRemover().setEnabled(false);
        view.getLblBuscar().setVisible(true);
        view.getLblCancelar().setVisible(false);
        view.getLblSalvar().setVisible(false);
        limparCampos();
        desativarCampos();
        inserirDadosAlunoTabela();
        
    }
    
    
    /*
        Método: inserirCampos
        Parâmetros: vazio
        Descrição: pega os dados do banco e insere na tela   
    */  
    public void inserirCampos() throws SQLException, ParseException{
        
        view.getLblRemover().setEnabled(true);
        view.getLblEditar().setEnabled(true);
        //Salva na variável a lista de todas os alunos do banco
        ArrayList<Aluno> alunoBanco = carregarDadosAluno();
        //Descobre qual linha da tabela o mouse clicou
        int linha = view.getTblAluno().getSelectedRow();
        //Verifica se a linha é válida
        if(linha >= 0 && linha < alunoBanco.size()){
            //Pega o aluno da lista de acordo com a linha clicada
            Aluno aluno = alunoBanco.get(linha);            
            //Insere os dados do aluno na tela
            inserirDadosAluno(aluno);           

        }else{
            JOptionPane.showMessageDialog(null, "Seelcione uma linha válida.");
        }        
   }
    
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: Avisa se algum campo esta em branco
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
        Descrição: limpa todos os campos da tela
    */
    public void limparCampos(){
        view.getTxtNome().setText("");
        view.getTxtCPF().setText("");
        view.getTxtEmail().setText("");
        view.getTxtTelefone().setText("");
        view.getTxtCEP().setText("");
        view.getTxtLogradouro().setText("");
        view.getTxtCurso().setText("");
        view.getCmbGenero().setSelectedItem("Selecione");
        view.getCmbCorRaca().setSelectedItem("Selecione");
        view.getTxtDataNascimento().setText("");
        view.getTxtIdTurma().setText("");
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
        Método: tratarGenero
        Parâmetros: classe Aluno
        Descrição: pega os dados do banco e transforma para o formato para por na tela    
    */
    public static String tratarGenero(Aluno alun){
        if(alun.getGenero() == 'I') return "Prefiro não informar";
        if(alun.getGenero() == 'M')return "Masculino";
        if(alun.getGenero() == 'F') return "Feminino";
        if(alun.getGenero() == 'O') return "Outros";
        return "Selecione";
    }
    
    
    /*
        Método: carregarDadosAluno
        Parâmetros: vazio
        Descrição: retorna a lista de alunos que está persistido no banco de dados
    */
    public static ArrayList<Aluno> carregarDadosAluno() throws SQLException, ParseException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe AlunoDAO para realizar o CRUD
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        //Chama o método findAll que retorna uma lista de alunos que está no banco de dados
        ArrayList<Aluno> alunoBanco = alunoDAO.findAll();
        
        return alunoBanco;
    }
    
    
    /*
        Método: carregarDadosTurma
        Parâmetros: vazio
        Descrição: retorna a lista de turmas que está persistido no banco de dados
    */
    public static ArrayList<Turmas> carregarDadosTurma() throws SQLException, ParseException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe AlunoDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        //Chama o método findAll que retorna uma lista de alunos que está no banco de dados
        ArrayList<Turmas> turmaBanco = turmaDAO.findAll();
        
        return turmaBanco;
    }
    
    
    /*
        Método: inserirDadosAlunoTabela
        Parâmetros: vazio
        Descrição: insere as informações da tabela aluno do banco de dados na tabela da tela
    */
    public void inserirDadosAlunoTabela() throws SQLException, ParseException{
        // Variavel que recebe uma lista de turmas
        ArrayList<Aluno> alunosBanco = carregarDadosAluno();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Turma"}, 0);
        
        //Tratar informações para inserir na tabela
        alunosBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getTurmaId()};
            modelo.addRow(linha);        
        });
        
        view.getTblAluno().setModel(modelo);
        
    }
    
    /*
        Método: removerCadastro
        Parâmetros: vazio
        Descrição: remove a turma do banco de dados  
    */
    public  void removerCadastro() throws SQLException, ParseException{
        
        //Verifica se selecionou alguma linha da tabela
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
                    //Chama o método de remoção            
                    alunoDAO.remove(aluno);
                    //Mensagem de aluno cadastrado com sucesso
                    JOptionPane.showMessageDialog(null, "Aluno descadastrado com sucesso");        
                    //Aumenta a vaga da turma que o aluno pertencia
                    aumentarVagasTurma(aluno.getTurmaId());
                    cancelar();

                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
                    //Caso dê erro mostra essa tela
                    JOptionPane.showMessageDialog(null, "Falha ao descadastrar dado no banco");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma linha válida!");
            }
        }
    }
    
    
    
    /*
        Método: aumentarVagasTurma()
        Parâmetros: vazio
        Descrição: pesquisa a turma pelo id e atualiza o campo vagas da tabela turma 
        aumenta 1 na quantidade de vagas no banco e insere os dados da turma novamente na tabela da tela.
    */
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
    
    
    /*
        Método: diminuirVagasTurma()
        Parâmetros: vazio
        Descrição: pesquisa a turma pelo id e atualiza o campo vagas da tabela turma 
        diminuindo 1 na quantidade de vagas no banco e insere os dados da turma novamente na tabela da tela.
    */
    public static void diminuirVagasTurma(int idTurma) throws SQLException{
    
        Turmas turma = pesquisarTurmaPorId(idTurma);
        
        int vagasAtual = turma.getVagas(); 
        turma.setVagas(vagasAtual -1); 
        
        //Caso a quantidade de vagas fique com 25 a turma pode começar as aulas
        if(turma.getVagas() == 25) JOptionPane.showMessageDialog(null, "Turma apta para começar esse semestre!");
        
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
            
        turmaDAO.update(turma);
        
 
    }
    
    
    /*
        Método: pesquisarTurmaPorId
        Parâmetros: vazio
        Descrição: pesquisa a turma no banco referente ao id passado
    */ 
    public static Turmas pesquisarTurmaPorId(int idTurma) throws SQLException{               
            //Faz a conexão com o banco 
            Connection conexao;
            conexao = new Conexao().getConnection();
            //Passa a conexão para a classe TurmaDAO para realizar o CRUD
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
            Turmas turma = turmaDAO.findById(idTurma); 
            
            return turma; 
    }
    
    
    /*
        Método: ativarCampos
        Parâmetros: vazio
        Descrição: Ativa todos os campos de inserção de dados   
    */
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
        view.getTxtIdTurma().setEnabled(true);

    }
    
    /*
        Método: desativarCampos
        Parâmetros: vazio
        Descrição: Desativa todos os campos de inserção de dados   
    */
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
        view.getTxtIdTurma().setEnabled(false);
    }
    
    
    /*
        Método: ativarTodosBotoes
        Parâmetros: vazio
        Descrição: ativar todos os botões   
    */
    public void ativarTodosBotoes(){
        view.getLblBuscar().setEnabled(true);
        view.getLblCadastrar().setEnabled(true);
        view.getLblEditar().setEnabled(true);
        view.getLblRemover().setEnabled(true);
    }
    
    
    /*
        Método: buscarCadastro
        Parâmetros: vazio
        Descrição: busca uma aluno específico ao pedir o id e insere os dados na tela
    */
    public void buscarCadastro() throws SQLException, ParseException{
        String idString = (JOptionPane.showInputDialog("Digite o id do aluno:"));
        
        // Condição que irá garantir que o retorno do JOptionPane nao seja nulo
        if(idString != null){
            int id = Integer.parseInt(idString);
            int posicaoAlunoLista = posicaoAlunoLista(id);
            
            if(posicaoAlunoLista != -1){
                Aluno aluno = buscarAlunoPorId(id);
                inserirDadosAluno(aluno);
                desativarCampos();
                ativarTodosBotoes();
                inserirDadosAlunoTabela();
                view.getTblAluno().addRowSelectionInterval(posicaoAlunoLista ,posicaoAlunoLista);
           
            }else{
                JOptionPane.showMessageDialog(null, "Aluno não matriculado!");
            } 
        }
    }
    
    
    /*
        Método: posicaoAlunoLista
        Parâmetros: inteiro
        Descrição: pesquisa a posição do aluno na lista vindo do banco
    */
    public int posicaoAlunoLista(int id) throws SQLException, ParseException{
        ArrayList<Aluno> alunos = carregarDadosAluno();
        
        for(int i = 0; i <alunos.size(); i++){
            if(id == alunos.get(i).getId()){
                return i;
            }
            
        }
        return -1;
    }
    
    
    /*
        Método: buscarAlunoPorId
        Parâmetros: inteiro
        Descrição: busca os dados de um aluno de acordo com o id dela
    */
    public Aluno buscarAlunoPorId(int id) throws SQLException, ParseException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
        Aluno aluno = alunoDAO.findById(id); 
        return aluno;
    }
    
    
    /*
        Método: inserirDadosAluno
        Parâmetros: inteiro
        Descrição: insere os dados do aluno na tela
    */
    public void inserirDadosAluno(Aluno aluno){
        view.getTxtIdTurma().setText(Integer.toString(aluno.getTurmaId()));
        view.getTxtNome().setText(aluno.getNome());
        view.getTxtCPF().setText(aluno.getCPF());
        view.getTxtEmail().setText(aluno.getEmail());
        view.getTxtTelefone().setText(aluno.getTelefone());
        view.getTxtCEP().setText(aluno.getCEP());
        view.getTxtLogradouro().setText(aluno.getEndereco());
        view.getTxtCurso().setText(aluno.getCurso());
        view.getCmbGenero().setSelectedItem(tratarGenero(aluno));
        view.getCmbCorRaca().setSelectedItem(aluno.getCorRaca());
        /*Tratando data nascimento*/
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = s.format(aluno.getDataNascimento().getTime());
        view.getTxtDataNascimento().setText(dataNascimento);      
    }
}
