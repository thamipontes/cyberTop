package controller;

import javax.swing.JOptionPane;
import telas.CadastroUniversidade;

public class CadastroUniversidadeController {
    private final CadastroUniversidade view;
    
    public CadastroUniversidadeController(CadastroUniversidade view){
        this.view = view;
    }
    
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
}
