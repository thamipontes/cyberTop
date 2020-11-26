
package controller;

import dao.Conexao;
import dao.DiretorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Diretor;
import telas.Login;
import telas.Principal;

/*Classe que controla todas as regras de negócios do cadastro do Login*/
public class LoginController {
    
    //Declaração do atributo que possui a tela Login
    private final Login view;
    
    //Construtor
    public LoginController(Login view) {
        this.view = view;
    }
    
    /*
        Método: autenticar
        Parâmetros: vazio
        Descrição: consulta no banco os dados os dados de logins inseridos na tela login 
        para permitir acesso ou não sistema.   
    */ 
    public void autenticar() throws SQLException{
        
    /*Pegas as informações passadas nos campos da tela*/     
    String login = view.getTxtUsuario().getText();
    String senha = view.getTxtSenha().getText();
    
    //Instacia o objeto diretor
    Diretor diretor = new Diretor(login, senha);
    
    //Conexão com o banco de dados 
    Connection conexao = new Conexao().getConnection();
    DiretorDAO diretorDAO = new DiretorDAO(conexao);
    
    //Retorna verdadeiro ou falso caso tenha os dados passado na tela no banco
    boolean existeLogin =  diretorDAO.autenticarUsuario(diretor);
    
    //Verifica a existência do login 
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
