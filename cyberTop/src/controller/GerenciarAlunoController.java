package controller;

import dao.AlunosDAO;
import dao.Conexao;
import dao.TurmaDAO;
import interfaces.Cadastrar;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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


public class GerenciarAlunoController{
    private final GerenciarAluno view;
    
    public GerenciarAlunoController(GerenciarAluno view){
        this.view = view;
    }
    
    
    public void editar() throws ParseException, SQLException{
        if(view.getTblAluno().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione algum aluno para poder editar.");
        }else{
            ativarCampos();
            view.getLblCadastrar().setVisible(false);
            view.getLblEditar().setVisible(false);
            view.getLblRemover().setVisible(false);
            view.getLblBuscar().setVisible(false);
            view.getLblCancelar().setVisible(true);
            view.getLblSalvar().setVisible(true);
        }
        
    }
    
    
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
            //Variável que recebe o return do método formatarGenero que está implementado no final do código
            char genero = formatarGenero((view.getCmbGenero().getSelectedIndex()));        

            /*Tratando o dado Cor Raça*/
            //Transforma o o texto do item selecionado em string e guarda na variável
            String corRaca = view.getCmbCorRaca().getSelectedItem().toString();
            
             /*Tratando o dado da turma*/
            int id = tratarIdAlunoIdTurma(idTurmaNovo);


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

                  //aumentarVagasTurma(aluno.getTurmaId());

            } catch (SQLException ex) {
                Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }  

                limparCampos();
                desativarCampos();
                cancelarEditar();
        }
    }

    private int tratarIdAlunoIdTurma(int idTurmaNovo) throws SQLException, ParseException {
                       
        ArrayList<Aluno> alunoBanco = carregarDadosAluno();
        int linha = view.getTblAluno().getSelectedRow();
        int id = 0;
        if(linha >= 0 && linha < alunoBanco.size()){
            Aluno alun = alunoBanco.get(linha);
            id = alun.getId();
            
            int turmaIdVelho = pesquisarTurmaPorId(alun.getTurmaId()).getId();
            diminuirVagasTurma(turmaIdVelho);
            aumentarVagasTurma(idTurmaNovo);
        }
        return id;
    }
    
    public void cancelarEditar() throws SQLException, ParseException{
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
    
    
    
    // Metodo que vai setar as informações do aluno selecionado na tabela para o campo de dados
    public void inserirCampos() throws SQLException, ParseException{
        
        view.getLblRemover().setEnabled(true);
        view.getLblEditar().setEnabled(true);
        ArrayList<Aluno> alunoBanco = carregarDadosAluno();
        int linha = view.getTblAluno().getSelectedRow();

        if(linha >= 0 && linha < alunoBanco.size()){
            Aluno aluno = alunoBanco.get(linha);
            
            view.getTxtIdTurma().setText(Integer.toString(aluno.getTurmaId()));
            view.getTxtNome().setText(aluno.getNome());
            view.getTxtCPF().setText(aluno.getCPF());
            view.getTxtEmail().setText(aluno.getEmail());
            view.getTxtTelefone().setText(aluno.getTelefone());
            view.getTxtCEP().setText(aluno.getCEP());
            view.getTxtLogradouro().setText(aluno.getEndereco());
            view.getTxtCurso().setText(aluno.getCurso());
            view.getCmbGenero().setSelectedItem(tratarGenero(aluno));
            view.getCmbCorRaca().setSelectedItem(tratarCorRaca(aluno));
                
            /*Tratando data nascimento*/
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            String dataNascimento = s.format(aluno.getDataNascimento().getTime());
            view.getTxtDataNascimento().setText(dataNascimento);
            

        }
        
   }
    
    //Alerta o usuario que todos os campos precisam ser preenchidos
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
    
    
    
    //Limpas todos os campos de texto
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
    
    
    public static String tratarGenero(Aluno alun){
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
    //Mudar nome do metodo para remover
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
                    //Chama o método de remoção            
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
                
                limparCampos();
                desativarCampos();
                view.getLblRemover().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma linha válida!");
            }
        }
        // VERSAO Q DAVA CERTO E FUNCIONAVA
        //limparCampos();
        //desativarCampos();
        //view.getLblRemover().setEnabled(false);
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
    
    
    public void diminuirVagasTurma(int idTurma) throws SQLException{
    
        Turmas turma = pesquisarTurmaPorId(idTurma);
        
        int vagasAtual = turma.getVagas(); 
        turma.setVagas(vagasAtual -1);     
        
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
        view.getTxtIdTurma().setEnabled(true);

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
        view.getTxtIdTurma().setEnabled(false);
    }
    
    //Desativar e ativar botoes
    public void ativarTodosBotoes(){
        view.getLblBuscar().setEnabled(true);
        view.getLblCadastrar().setEnabled(true);
        view.getLblEditar().setEnabled(true);
        view.getLblRemover().setEnabled(true);
    }
    
    public void buscarAluno() throws SQLException, ParseException{
        String idString = (JOptionPane.showInputDialog("Digite o id do aluno:"));
        int id;
        
        // Condição que irá garantir que o retorno do JOptionPane nao seja nulo
        if(idString != null){
            id = Integer.parseInt(idString);
            
            if(posicaoAlunoLista(id)  != -1){
                Aluno aluno = buscarAlunoPorId(id);
                inserirBuscarDadosAluno(aluno);
                desativarCampos();
                ativarTodosBotoes();
                inserirDadosAlunoTabela();
                view.getTblAluno().addRowSelectionInterval(posicaoAlunoLista(id),posicaoAlunoLista(id));
           
            }else{
                JOptionPane.showMessageDialog(null, "Aluno não matriculado!");
            } 
        }
    }
    
    public int posicaoAlunoLista(int id) throws SQLException, ParseException{
        ArrayList<Aluno> alunos = carregarDadosAluno();
        
        for(int i = 0; i <alunos.size(); i++){
            if(id == alunos.get(i).getId()){
                return i;
            }
            
        }
        return -1;
    }
    
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
    
    public void inserirBuscarDadosAluno(Aluno aluno){
        view.getTxtIdTurma().setText(Integer.toString(aluno.getTurmaId()));
        view.getTxtNome().setText(aluno.getNome());
        view.getTxtCPF().setText(aluno.getCPF());
        view.getTxtEmail().setText(aluno.getEmail());
        view.getTxtTelefone().setText(aluno.getTelefone());
        view.getTxtCEP().setText(aluno.getCEP());
        view.getTxtLogradouro().setText(aluno.getEndereco());
        view.getTxtCurso().setText(aluno.getCurso());
        view.getCmbGenero().setSelectedItem(tratarGenero(aluno));
        view.getCmbCorRaca().setSelectedItem(tratarCorRaca(aluno));
                
            //Editar isso aqui    
        view.getTxtDataNascimento().setText("00/00/0000");
    }
}
