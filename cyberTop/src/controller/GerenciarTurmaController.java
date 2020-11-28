
package controller;

import dao.Conexao;
import dao.TurmaDAO;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
            
            // Cria uma variavel de controle para poder ter acesso ao banco de universidades
            
            JOptionPane.showMessageDialog(null, turma.getNomeUniversidade());
            view.getCampoUniversidade().setSelectedItem(turma.getNomeUniversidade());
            
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Seelcione uma linha válida.");
        }
        
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
