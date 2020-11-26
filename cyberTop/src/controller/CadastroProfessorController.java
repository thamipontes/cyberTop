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


public class CadastroProfessorController implements Cadastrar{
    private final CadastroProfessor view;
    
    public CadastroProfessorController(CadastroProfessor view){
        this.view = view;
    }
    
    
    @Override
    public void salvarCadastro() {
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String telefone = view.getTxtTelefone().getText();
        String endereco = view.getTxtLogradouro().getText();
        String materia = view.getTxtMateria().getText();
        String nomeTurma = view.getCmbTurmaProfessor().getSelectedItem().toString();
        
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
        
        Professor professor = new Professor(nome, cpf, dataNascimento, telefone, endereco, genero, materia, nomeTurma);
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            ProfessorDAO professorDAO = new ProfessorDAO(conexao);
            professorDAO.insert(professor);
            
            JOptionPane.showMessageDialog(null, "Professor criada com sucesso");
            
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
