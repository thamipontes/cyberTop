package controller;

import javax.swing.JOptionPane;
import telas.CadastroUniversidade;

// Classe que controla toda regras e negocios do cadastro de universidades
public class CadastroUniversidadeController {
    private final CadastroUniversidade view;
    
    //Construtor
    public CadastroUniversidadeController(CadastroUniversidade view){
        this.view = view;
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
