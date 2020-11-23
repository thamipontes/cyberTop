package controller;

import javax.swing.JOptionPane;
import telas.CadastroProfessor;

public class CadastroProfessorController {
    private CadastroProfessor view;
    
    public CadastroProfessorController(CadastroProfessor view){
        this.view = view;
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
    
    
    
    
}
