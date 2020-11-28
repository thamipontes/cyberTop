
package controller;

import dao.Conexao;
import dao.TurmaDAO;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turmas;
import model.Universidade;
import telas.GerenciarTurma;



public class GerenciarTurmaController {
    //Declaração do atributo que possui a tela CadastroTurma
    private final GerenciarTurma view;
    
    //Construtor
    public GerenciarTurmaController(GerenciarTurma view) {
        this.view = view;
    }
    
    public void inserirCampos() throws SQLException{
        int linha = view.getTblTurma().getSelectedRow();
        ArrayList<Turmas> turmaBanco = carregarDadosTurma();
        
        if(linha >= 0 && linha < turmaBanco.size()){
            Turmas turma = turmaBanco.get(linha);
            
            view.getTxtNome().setText(turma.getNome());
            //Regras para selecionar o tipo da turma
            
            // Se a expressao for positiva o tipo da turma é Enem,  senao vestibular
            if(turma.getTipo()){
                view.getRdbEnem().setSelected(true);
                view.getRdbVestibular().setSelected(false);
            }else{
                view.getRdbEnem().setSelected(false);
                view.getRdbVestibular().setSelected(true);
            }
            
            // Se a expressao for positiva o periodo da turma é Anual,  senao Semestral
            if(turma.getPeriodo()){
                view.getRdbAnual().setSelected(true);
                view.getRdbSemestral().setSelected(false);
            }else{
                view.getRdbAnual().setSelected(false);
                view.getRdbSemestral().setSelected(true);
            }
            
            view.getCampoUniversidade().setSelectedItem(turma.getNomeUniversidade());
            view.getCampoHorario().setSelectedItem(turma.getHorario());
            
            //Regras de botoes
            view.getLblEditar().setEnabled(true);
            view.getLblRemover().setEnabled(true);
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Seelcione uma linha válida.");
        }
        
    }
    
    
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
            view.getTblTurma().setVisible(true);

        }
    //Desativa todos os campos de inserção de dados
    public void desativarCampos(){
        view.getTxtNome().setEnabled(false);
        view.getCampoHorario().setEnabled(false);
        view.getCampoUniversidade().setEnabled(false);
        view.getRdbAnual().setEnabled(false);
        view.getRdbEnem().setEnabled(false);
        view.getRdbSemestral().setEnabled(false);
        view.getRdbVestibular().setEnabled(false);
    }
    // Ativa todos os campos de inserção de dados
    public void ativarCampos(){
        view.getTxtNome().setEnabled(true);
        view.getCampoHorario().setEnabled(true);
        view.getCampoUniversidade().setEnabled(true);
        view.getRdbAnual().setEnabled(true);
        view.getRdbEnem().setEnabled(true);
        view.getRdbSemestral().setEnabled(true);
        view.getRdbVestibular().setEnabled(true);
        
    }
    
    // Avisa se algum campo esta em branco
    public boolean exibirAlertarCampos(){        
        //Descobre se algum dos campos ficou vazio
        if(view.getTxtNome().getText().equals("")                               ||
            view.getCampoHorario().getSelectedItem().equals("Selecione")        ||
            view.getCampoUniversidade().getSelectedItem().equals("Selecione")   //||
            //!view.getRdbAnual().isSelected()                                    ||
            //!view.getRdbSemestral().isSelected()                                ||
            //!view.getRdbEnem().isSelected()                                     ||
            //!view.getRdbVestibular().isSelected()
                ){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
        }
        
        return false;
    }
    
    public void editarCadastro() throws ParseException, SQLException{
        
        if(!exibirAlertarCampos()){
            
                /*Pega as informações passadas nos campos da tela*/
            String nome = view.getTxtNome().getText();
            String universidade = view.getCampoUniversidade().getSelectedItem().toString();
            String horario = view.getCampoHorario().getSelectedItem().toString();
            boolean enem = view.getRdbEnem().isSelected();
            boolean vestibular = view.getRdbVestibular().isSelected();
            boolean anual = view.getRdbAnual().isSelected();
            boolean semestral = view.getRdbSemestral().isSelected();
            boolean tipo;
            boolean periodo;
            // Verificação para definir o tipo da turma, se verdadeiro for é do tipo enem senao vestibular
            if(enem){
               tipo = enem;
            }else{
               tipo = vestibular;
            }
            // Verificação para definir o tipo da turma, se verdadeiro for é do tipo enem senao vestibular
            if(anual){
                periodo = anual;
            }else{
                periodo = semestral;
                
            }
            
            
            // Criar uma lista de todas as universidades cadastradas
            ArrayList<Turmas> turmaBanco = carregarDadosTurma();
            // Captura qual a linha selecionada da tabela de universidades
            int linha = view.getTblTurma().getSelectedRow();
            
            // 
            int id=0;
            // Verificação se alguma linha da tabela de universidade foi selecionada
            if(linha >= 0 && linha < turmaBanco.size()){
                // Captura o objeto selecionado na tabela universidade
                Turmas turma = turmaBanco.get(linha);
                // Captura o id da turma selecionada
                id = turma.getId();
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma linha valida na tabela!");
            }
            
            
            
            /*Instaciando o objeto aluno com os dados recebidos pela tela para atualizar*/
            Turmas turma = new Turmas(id,nome, horario, tipo, periodo, universidade);
            JOptionPane.showMessageDialog(null, universidade);
            
            
            

            
            /*Conexão com o banco de dados para salvar os dados da universidade na tabela e banco de dados*/
            Connection conexao;        
            try {
            //Faz a conexão com o banco
                conexao = new Conexao().getConnection();
                //Passa a conexão para a classe AlunosDAO que possui o CRUD
                TurmaDAO turmaDAO = new TurmaDAO(conexao);
               //Chama o método de inserção e atualiza no banco de dados e na tabela           
                turmaDAO.update(turma);
                //Mensagem de aluno cadastrado com sucesso
                JOptionPane.showMessageDialog(null, "Turma editada com sucesso");
                inserirDadosTurmaTabela();

                  

            } catch (SQLException ex) {
                Logger.getLogger(GerenciarTurmaController.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }  
                
                limparCampos();
                desativarCampos();
                configuracaoInicialBotoes();
                //implementar
                //cancelar();
        }
    }
    
    
    // Limpar todo os campos da tela
    public void limparCampos(){
        
        view.getTxtNome().setText("");
        view.getCampoHorario().setSelectedItem("Selecione");
        view.getCampoUniversidade().setSelectedItem("Selecione");
        view.getRdbEnem().setSelected(false);
        view.getRdbAnual().setSelected(false);
        view.getRdbSemestral().setSelected(false);
        view.getRdbVestibular().setSelected(false);
    }
    
    
    // Verifica se tem alguma linha da tabela selecionada para que seja possivel editar
    public void botaoEditarCadastro(){
        if(view.getTblTurma().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma turma para poder editar.");
        }else{
            ativarCampos();
            regraBotoesEditar();
            
        }
    }
    // Deixa apenas os botoes de salvar e cancelar ativos;
    public void regraBotoesEditar(){
        view.getLblRemover().setVisible(false);
        view.getLblEditar().setVisible(false);
        view.getLblBuscar().setVisible(false);
        view.getLblCadastrar().setVisible(false);
        view.getLblCancelar().setVisible(true);
        view.getLblSalvarEditar().setVisible(true);
        view.getLblSalvarCadastro().setVisible(false);
    }
     //Insere todas as universidades na tabela
    public void inserirDadosTurmaTabela() throws SQLException{
        // Variavel que recebe uma lista de turmas
        ArrayList<Turmas> turmaBanco = carregarDadosTurma();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Tipo", "Período", "Horário"}, 0);
        
        //Tratar informações para inserir na tabela
        turmaBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getNome(), e.getTipo(), e.getPeriodo(), e.getHorario()};
            modelo.addRow(linha);        
        });
        
        view.getTblTurma().setModel(modelo);
        
    }
    
   /*
        Método: inserirDadosUniversidadeCmb
        Parâmetros: vazio
        Descrição: insere os dados das universidade vindos do banco de dados
        no combo box que representa a universidade que ele irá administrar a aula.
    */
    public void inserirDadosUniversidadeCmb() throws SQLException{
        //Salva em uma variavel a lista de todas as universidades que estão no banco de dados
        ArrayList<Universidade> universidades = carregarDadosUniversidades();
        //Remove todos os itens antigos que estão na combo box para não acumular os dados ao adicionar novos dados.
        view.getCampoUniversidade().removeAllItems();
        //Adiciona como primeiro item a palavra selecione
        view.getCampoUniversidade().addItem("Selecione");
        //Percorre a lista de universidades e adiciona o nome da universidade na combo box
        universidades.forEach(u -> {
            view.getCampoUniversidade().addItem(u.getNome());        
        });        
        
    }
    
    /*
        Método: carregarDadosUniversidades
        Parâmetros: vazio
        Descrição: retorna a lista de universidades que está persistido no banco de dados
    */
    public ArrayList<Universidade> carregarDadosUniversidades() throws SQLException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe UniversidadeDAO para realizar o CRUD
        UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
        //Chama o método findAll que retorna uma lista de universidades que está no banco de dados
        ArrayList<Universidade> universidades = universidadeDAO.findAll();
        return universidades;    
    }
    
    // Carrega as informações a partir do banco de dados e retorna uma lista de turmas
    public ArrayList<Turmas> carregarDadosTurma() throws SQLException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        
        ArrayList<Turmas> turmaBanco = turmaDAO.findAll();
        
        return turmaBanco;
        
    }
    

    
    
    
}
