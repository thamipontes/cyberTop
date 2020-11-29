
package controller;

import dao.Conexao;
import dao.ProfessorDAO;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Professor;
import model.Universidade;
import telas.GerenciarProfessor;

public class GerenciarProfessorController {
    private final GerenciarProfessor view;
    
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
