package controller;

import dao.Conexao;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Universidade;
import telas.CadastroUniversidade;

// Classe que controla toda regras e negocios do cadastro de universidades
public class CadastroUniversidadeController {
    private final CadastroUniversidade view;
    
    //Construtor
    public CadastroUniversidadeController(CadastroUniversidade view){
        this.view = view;
    }
    
    
    public void salvarCadastro(){
    
        String nome = view.getTxtNomeUniversidade().getText();
        String estado = view.getCmbEstado().getSelectedItem().toString();
        String campus = view.getTxtCampus().getText();        
        
        Universidade universidade = new Universidade(nome, estado, campus);
        
        try{
            Connection conexao;
            conexao = new Conexao().getConnection();
            UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
            universidadeDAO.insert(universidade);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUniversidade.class.getName()).log(Level.SEVERE, null, ex);
            //Caso dê erro mostra essa tela
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar dado no banco");
        }    
    
    }
    
    
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: confere se teve algum campo que ficou sem ser preenchido e mostra na tela
        uma mensagem para preencher todos os campos.
    */
    public boolean exibirAlertarCampos(){
        if(view.getTxtNomeUniversidade().getText().equals("")   ||
            view.getTxtCampus().getText().equals("")            ||
            view.getCmbEstado().getSelectedItem().equals("Selecione")
                
                ){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return true;
        }
        return false;
    
    }
    
     /*
        Método: limparCampos
        Parâmetros: vazio
        Descrição: deixa todos os campos da tela vazio
        Retorno: void
    */
    public void limparCampos(){        
        
    //Insere o cursor no txtNome e o deixa em foco
        //view.getTxtNome().requestFocus();

        // Limpa todos os campos
        view.getTxtNomeUniversidade().setText("");
        view.getCmbEstado().setSelectedItem("Selecione");
        view.getTxtCampus().setText("");
    
    }    
    
    
    

    
    
}
