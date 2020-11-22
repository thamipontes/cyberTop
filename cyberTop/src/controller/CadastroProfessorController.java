package controller;

import javax.swing.JOptionPane;
import telas.CadastroProfessor;

public class CadastroProfessorController {
    private CadastroProfessor view;
    
    public CadastroProfessorController(CadastroProfessor view){
        this.view = view;
    }
    
    public boolean exibirAlertarCampos(){
        if(view.getTxtNome().getText().equals("")                       ||
            view.getTxtCPF().getText().equals("   .   .   -  ")         || 
            view.getTxtDataNascimento().getText().equals("  /  /    ")  ||
            view.getCmbGenero().getSelectedItem().equals("Selecione")   ||
            view.getCmbCorRaca().getSelectedItem().equals("Selecione")  ||
            view.getTxtTelefone().getText().equals("(  )      -    ")   ||
            view.getTxtCEP().getText().equals("     -   ")              ||
            view.getTxtLogradouro().getText().equals("")
                ){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
        }
        
        return false;            
    }
    
    
}
