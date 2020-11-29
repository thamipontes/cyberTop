
package controller;

import dao.Conexao;
import dao.ProfessorDAO;
import dao.UniversidadeDAO;
import java.awt.HeadlessException;
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
import model.Professor;
import model.Universidade;
import telas.CadastroProfessor;
import telas.GerenciarProfessor;

public class GerenciarProfessorController {
    private final GerenciarProfessor view;
    
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
    
    public void editarCadastro() throws SQLException, ParseException{
        
        
        if(!exibirAlertarCampos()){
                /*Pegas as informações passadas nos campos da tela*/
            String nome = view.getTxtNome().getText();
            String cpf = view.getTxtCPF().getText();
            String telefone = view.getTxtTelefone().getText();
            String endereco = view.getTxtLogradouro().getText();
            String materia = view.getTxtMateria().getText();
            String turma = view.getCmbTurmaProfessor().getSelectedItem().toString();
            
            

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
                Logger.getLogger(CadastroProfessorController.class.getName()).log(Level.SEVERE, null, ex);
            }

           /*Tratando o dado Genero*/  
           //Variável que recebe o return do método formatarGenero que está implementado no final do código
            char genero = formatarGenero((view.getCmbGenero().getSelectedIndex()));        
            
            /*Acha o id do professor na tabela*/
                int id = buscarIdProfessorTabela();


           /*Instaciando o objeto aluno com os dados recebidos pela tela*/
           Professor professor = new Professor(id, nome, cpf, dataNascimento, telefone, endereco, genero, materia, turma);

           /*Conexão com o banco de dados para salvar os dados do aluno na tabela aluno*/
            Connection conexao;        
            try {
                //Faz a conexão com o banco
                conexao = new Conexao().getConnection();
                //Passa a conexão para a classe AlunosDAO que possui o CRUD
                ProfessorDAO professorDAO = new ProfessorDAO(conexao);
                //Chama o método de inserção            
                professorDAO.update(professor);
                //Mensagem de aluno cadastrado com sucesso
                JOptionPane.showMessageDialog(null, "Professor editado com sucesso");            

            } catch (SQLException ex) {
                Logger.getLogger(CadastroProfessor.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar dado no banco");
            }  
        }
        cancelar();
        
    }
    
    
    /*
        Método: buscarIdTurmaTabela
        Parâmetros: vazio
        Descrição: acha qual o id da turma clicada na tabela  
    */
    private int buscarIdProfessorTabela() throws HeadlessException, SQLException, ParseException {
        // Criar uma lista de todas as turmas cadastradas
        ArrayList<Professor> professorBanco = carregarDadosProfessor();
        // Captura qual a linha selecionada da tabela de turmas
        int linha = view.getTblProfessor().getSelectedRow();

        int id = 0;
        // Verifica se a linha selecionada é válida
        if(linha >= 0 && linha < professorBanco.size()){
            // Captura o objeto selecionado na tabela turma
            Professor professor = professorBanco.get(linha);
            // Captura o id da turma selecionada
            id = professor.getId();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha valida na tabela!");
        }
        return id;
    }
    
    
    
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: confere se teve algum campo que ficou sem ser preenchido e mostra na tela
        uma mensagem para preencher todos os campos.
    */
    
    //@Override
    public boolean exibirAlertarCampos(){        
        //Descobre se algum dos campos ficou vazio
        if(view.getTxtNome().getText().equals("")                       ||
            view.getTxtCPF().getText().equals("   .   .   -  ")         || 
            view.getTxtDataNascimento().getText().equals("  /  /    ")  ||
            view.getCmbGenero().getSelectedItem().equals("Selecione")   ||
            view.getCmbTurmaProfessor().getSelectedItem().equals("Selecione")  ||
            view.getTxtTelefone().getText().equals("(  )      -    ")   ||
            view.getTxtLogradouro().getText().equals("")                ||
            view.getTxtMateria().getText().equals("")
            
            
                ){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
        }
        
        return false;
    }
    
    
    
    public GerenciarProfessorController(GerenciarProfessor view){
        this.view = view;
    }
    
    public void inserirCampos() throws SQLException, ParseException{
        ArrayList<Professor> professorBanco = carregarDadosProfessor();
        int linha = view.getTblProfessor().getSelectedRow();
        
        if(linha >= 0 && linha < professorBanco.size()){
            Professor professor = professorBanco.get(linha);
            
            view.getTxtNome().setText(professor.getNome());
            view.getTxtCPF().setText(professor.getCPF());
            view.getTxtTelefone().setText(professor.getTelefone());
            view.getCmbGenero().setSelectedItem(tratarGenero(professor));
            view.getTxtLogradouro().setText(professor.getEndereco());
            view.getTxtMateria().setText(professor.getMateria());
            view.getCmbTurmaProfessor().setSelectedItem(professor.getNomeTurma());
            
            /*Tratando data nascimento*/
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            String dataNascimento = s.format(professor.getDataNascimento().getTime());
            view.getTxtDataNascimento().setText(dataNascimento);
            
            //Regras de botoes
            view.getLblEditar().setEnabled(true);
            view.getLblRemover().setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um professor válido!");
        }
    }
    
    public String tratarGenero(Professor prof){
        if(prof.getGenero() == 'I') return "Prefiro não informar";
        if(prof.getGenero() == 'M')return "Masculino";
        if(prof.getGenero() == 'F') return "Feminino";
        if(prof.getGenero() == 'O') return "Outros";
        return "Selecione";
    }
    
    /*
        Método: botaoEditarCadastro
        Parâmetros: vazio
        Descrição: Verifica se tem alguma linha da tabela selecionada para que seja possivel editar
    */
    public void botaoEditarCadastro(){
        if(view.getTblProfessor().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione algum professor para editar.");
        }else{
            ativarCampos();
            regraBotoesEditar();            
        }
    }
    
    
    /*
        Método: regraBotoesEditar
        Parâmetros: vazio
        Descrição: Deixa apenas os botoes de salvar e cancelar ativos;
    */ 
    public void regraBotoesEditar(){
        view.getLblRemover().setVisible(false);
        view.getLblEditar().setVisible(false);
        view.getLblBuscar().setVisible(false);
        view.getLblCadastrar().setVisible(false);
        view.getLblCancelar().setVisible(true);
        view.getLblSalvarEditar().setVisible(true);
        view.getLblSalvarCadastro().setVisible(false);
    }
    
    /*
        Método: desativarCampos
        Parâmetros: vazio
        Descrição: Ativa todos os campos de inserção de dados   
    */
    public void ativarCampos(){
        view.getTxtNome().setEnabled(true);
        view.getTxtCPF().setEnabled(true);
        
        view.getTxtDataNascimento().setEnabled(true);
        view.getTxtLogradouro().setEnabled(true);
        
        view.getCmbGenero().setEnabled(true);
        
        view.getTxtTelefone().setEnabled(true);
        
        view.getCmbTurmaProfessor().setEnabled(true);
        view.getTxtMateria().setEnabled(true);
        
    }
    
    
    
    
     /*
        Método: limparCampos
        Parâmetros: vazio
        Descrição: limpa todos os campos da tela
    */
    //@Override
    public void limparCampos(){
        
        view.getTxtNome().setText("");
        view.getTxtCPF().setText("");
        
        view.getTxtDataNascimento().setText("");
        view.getTxtLogradouro().setText("");
        
        view.getCmbGenero().setSelectedItem("Selecione");
        
        view.getTxtTelefone().setText("");
        
        view.getCmbTurmaProfessor().setSelectedItem("Selecione");
        view.getTxtMateria().setText("");
    }
    
    
    
    
    
    /*
        Método: cancelar
        Parâmetros: vazio
        Descrição: volta a tela como estavam antes   
    */
    public void cancelar() throws SQLException, ParseException{
        limparCampos();
        desativarCampos();
        configuracaoInicialBotoes();
        
        inserirDadosProfessorTabela();
    }
    
    
    /*
        Método: configuracaoInicialBotoes
        Parâmetros: vazio
        Descrição: seta o padrão de botões para inicio da tela   
    */
    public void configuracaoInicialBotoes(){
            
            view.getLblRemover().setEnabled(false);
            view.getLblRemover().setVisible(true);
            view.getLblEditar().setEnabled(false);
            view.getLblEditar().setVisible(true);
            view.getLblBuscar().setEnabled(true);
            view.getLblBuscar().setVisible(true);
            view.getLblCadastrar().setEnabled(true);
            view.getLblCadastrar().setVisible(true);
            view.getLblCancelar().setVisible(false);
            view.getLblSalvarEditar().setVisible(false);
            view.getLblSalvarCadastro().setVisible(false);
            view.getTblProfessor().setVisible(true);

        }
    
    public void desativarCampos(){
        view.getTxtNome().setEnabled(false);
        view.getTxtCPF().setEnabled(false);
        
        view.getTxtDataNascimento().setEnabled(false);
        view.getTxtLogradouro().setEnabled(false);
        
        view.getCmbGenero().setEnabled(false);
        
        view.getTxtTelefone().setEnabled(false);
        
        view.getCmbTurmaProfessor().setEnabled(false);
        view.getTxtMateria().setEnabled(false);
    }
    
    
    
    //Insere todas as universidades na tabela
    public void inserirDadosProfessorTabela() throws SQLException, ParseException{
        ArrayList<Professor> professorBanco = carregarDadosProfessor();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Matéria", "Turma"}, 0);
        
        
        professorBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getMateria(), e.getNomeTurma()};
            modelo.addRow(linha);        
        });
        
        view.getTblProfessor().setModel(modelo);
        
    } 
    
    public ArrayList<Professor> carregarDadosProfessor() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        ProfessorDAO professorDAO = new ProfessorDAO(conexao);
        
        ArrayList<Professor> professorBanco = professorDAO.findAll();
        
        return professorBanco;
        
    }
    
    
    /*
        Método: inserirDadosTurmaCmB
        Parâmetros: vazio
        Descrição: insere os dados das turmas vindos do banco de dados
        no combo box que representa a turma que ele irá administrar a aula.
    */
    public void inserirDadosProfessorCmB() throws SQLException, ParseException{
        //Salva em uma variavel a lista de todas as turmas que estão no banco de dados
        ArrayList<Professor> professor = carregarDadosProfessor();
        //Remove todos os itens antigos que estão na combo box para não acumular os dados ao adicionar novos dados.
        view.getCmbTurmaProfessor().removeAllItems();
        //Adiciona como primeiro item a palavra selecione
        view.getCmbTurmaProfessor().addItem("Selecione");
        //Percorre a lista de turmas e adiciona o nome da universidade na combo box
        professor.forEach(t -> {
            view.getCmbTurmaProfessor().addItem(t.getNomeTurma());        
        });  
   
    }
    
}
