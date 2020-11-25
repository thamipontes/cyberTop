/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.TurmaDAO;
import dao.UniversidadeDAO;
import interfaces.Cadastrar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Turmas;
import model.Universidade;

import telas.CadastroTurma;

/**
 *
 * @author thamires
 */
public class CadastroTurmaController implements Cadastrar{
    
    private final CadastroTurma view;

    public CadastroTurmaController(CadastroTurma view) {
        this.view = view;
    }    

    @Override
    public void salvarCadastro(){  
        
        
        String nome = view.getCampoNomeTurma().getText();  
        String horario = view.getCampoHorario().getSelectedItem().toString();        
        Boolean tipo = view.getCampoTipoEnem().isSelected();      
        Boolean periodo = view.getCampoPeriodoAnual().isSelected();
        String universidade = view.getCampoUniversidade().getSelectedItem().toString();
     
        Turmas turma = new Turmas(nome, horario, tipo , periodo, 60, universidade);
        
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            turmaDAO.insert(turma);
            
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao criar turma!");
        }
    }
    
 
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: confere se teve algum campo que ficou sem ser preenchido e mostra na tela
        uma mensagem para preencher todos os campos.
    */
    public boolean exibirAlertarCampos(){
        if(view.getCampoNomeTurma().getText().equals("")   ||
           view.getCampoHorario().getSelectedItem().equals("Selecione")  
    
                ){
            JOptionPane.showMessageDialog(null, "Preencha os campos em branco!");
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
        view.getCampoNomeTurma().requestFocus();

        // Limpa todos os campos
        view.getCampoNomeTurma().setText("");
        view.getCampoTipoEnem().setSelected(false);
        view.getCampoTipoVestibular().setSelected(false);
        view.getCampoPeriodoAnual().setSelected(false);
        view.getCampoPeriodoSemestral().setSelected(false);
        view.getCampoUniversidade().setSelectedItem("Selecione");
        view.getCampoHorario().setSelectedItem("Selecione");    
    
    }
    
    
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
    
    
    public void inserirDadosUniversidadeCmb() throws SQLException{
        
        ArrayList<Universidade> universidades = carregarDadosUniversidades();
        view.getCampoUniversidade().removeAllItems();
        view.getCampoUniversidade().addItem("Selecione");
        universidades.forEach(u -> {
            view.getCampoUniversidade().addItem(u.getNome());        
        });        
        
    }
    
    
    public void selecionarPeriodoSemestral(){
        //Desativa a opção anual, pois foi escolhida a semestral (não pode escolher os dois).
        view.getCampoPeriodoAnual().setSelected(false);
        //Desativar a opçao enem, pois não existe turma semestral para enem.
        view.getCampoTipoEnem().setEnabled(false);
    }
    
    
    public void selecionarPeriodoAnual(){
    
        view.getCampoTipoEnem().setEnabled(true);
        view.getCampoPeriodoSemestral().setSelected(false);
    }
    
    public void selecionarTipoEnem(){
        //Desativar a opção tipo vestibular (não pode marcar as duas opções)
        view.getCampoTipoVestibular().setSelected(false);

        // Desativa a opção de inserção do nome da Universidade e limpa o campo, pois em enem não escolhe a universidade
        view.getCampoUniversidade().setEnabled(false);
        view.getCampoUniversidade().setSelectedItem("Selecione");
        
        //Ativa a opção anual e desativa a opção semestral, pois enem não pode ser semestral 
        view.getCampoPeriodoAnual().setSelected(true);
        view.getCampoPeriodoSemestral().setEnabled(false);    
    }
    
    
    public void selecionarTipoVestibular(){        
        //Desativar a opção tipo enem (não pode marcar as duas opções)
        view.getCampoTipoEnem().setSelected(false);
        
        //Ativa a opção semestral
        view.getCampoPeriodoSemestral().setEnabled(true);
        
        //Ativa o combo box para inserção do nome da Universidade
        view.getCampoUniversidade().setEnabled(true);    
    
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