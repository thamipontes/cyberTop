/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.DiretorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Diretor;
import telas.Login;
import telas.Principal;

/**
 *
 * @author thamires
 */
public class LoginController {
    private Login view;

    public LoginController(Login view) {
        this.view = view;
    }
    
    public void autenticar() throws SQLException{
        
    //Buscar na tela as entradas     
    String login = view.getTxtUsuario().getText();
    String senha = view.getTxtSenha().getText();
    
    //Instacia o objeto diretor
    Diretor diretor = new Diretor(login, senha);
    
    //Verificar se existe no banco
    Connection conexao = new Conexao().getConnection();
    DiretorDAO diretorDAO = new DiretorDAO(conexao);
    
    boolean existeLogin =  diretorDAO.autenticarUsuario(diretor);
    
    if(existeLogin){
        //Mostra a tela principal    
         Principal telaPrincipal = new Principal(); 
         telaPrincipal.setVisible(true);

        //Oculta a tela de login
         view.setVisible(false);    
    }else{        
        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
    }

    
    }
    
    
}
