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

/*Classe que controla todas as regras de negócios do cadastro da Turma*/
public class CadastroTurmaController implements Cadastrar{
    
    //Declaração do atributo que possui a tela CadastroTurma
    private final CadastroTurma view;
    
    //Construtor
    public CadastroTurmaController(CadastroTurma view) {
        this.view = view;
    }    

    
    /*
        Método: salvarCadastro
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */  
    @Override
    public void salvarCadastro(){  
        
        /*Pegas as informações passadas nos campos da tela*/
        String nome = view.getCampoNomeTurma().getText();  
        String horario = view.getCampoHorario().getSelectedItem().toString();        
        Boolean tipo = view.getCampoTipoEnem().isSelected();      
        Boolean periodo = view.getCampoPeriodoAnual().isSelected();
        String universidade = view.getCampoUniversidade().getSelectedItem().toString();
        
        /*Instaciando o objeto turma com os dados recebidos pela tela*/
        Turmas turma = new Turmas(nome, horario, tipo , periodo, 60, universidade);
        
         /*Conexão com o banco de dados para salvar os dados da turma na tabela turma*/
        Connection conexao;
        try {
            //Faz a conexão com o banco
            conexao = new Conexao().getConnection();
            //Chama o método de inserção 
            TurmaDAO turmaDAO = new TurmaDAO(conexao);
            //Chama o método de inserção 
            turmaDAO.insert(turma);
            //Mensagem de professor cadastrado com sucesso
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
    
    /*
        Método: carregarDadosUniversidades
        Parâmetros: vazio
        Descrição: retorna a lista de universidades que está persistido no banco de dados
    */
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
    
    /*
        Método: inserirDadosUniversidadeCmb
        Parâmetros: vazio
        Descrição: insere os dados das universidade vindos do banco de dados
        no combo box que representa a universidade que ele irá administrar a aula.
    */
    public void inserirDadosUniversidadeCmb() throws SQLException{
        //Salva em uma variavel a lista de todas as universidades que estão no banco de dados
        ArrayList<Universidade> universidades = carregarDadosUniversidades();
        //Remove todos os itens antigos que estão na combo box para não acumular os dados ao adicionar novos dados.
        view.getCampoUniversidade().removeAllItems();
        //Adiciona como primeiro item a palavra selecione
        view.getCampoUniversidade().addItem("Selecione");
        //Percorre a lista de universidades e adiciona o nome da universidade na combo box
        universidades.forEach(u -> {
            view.getCampoUniversidade().addItem(u.getNome());        
        });        
        
    }
    
    /*
        Método: selecionarPeriodoSemestral
        Parâmetros: vazio
        Descrição: Ao selecionar o periodo semestral, deseleciona o anual e desativa a opção enem, pois na regra de negocio
        o tipo enem não pode ser semestral. 
    */
    public void selecionarPeriodoSemestral(){
        //Desativa a opção anual, pois foi escolhida a semestral (não pode escolher os dois).
        view.getCampoPeriodoAnual().setSelected(false);
        //Desativar a opçao enem, pois não existe turma semestral para enem.
        view.getCampoTipoEnem().setEnabled(false);
    }
    
    /*
        Método: selecionarPeriodoAnual
        Parâmetros: vazio
        Descrição: Ao selecionar o periodo anual, deseleciona o semestral e ativa a opção enem, pois na regra de negocio
        o tipo enem só pode ser anual. 
    */
    public void selecionarPeriodoAnual(){
    
        view.getCampoTipoEnem().setEnabled(true);
        view.getCampoPeriodoSemestral().setSelected(false);
    }
        
    /*
        Método: selecionarTipoEnem
        Parâmetros: vazio
        Descrição: Ao selecionar o tipo enem, deseleciona o vestibular (não pode marcar as duas opções);
        desativa a combo box universidade, pois na regra de negocio o tipo enem não escolhe universidade e
        desativa o periodo semestral, pois enem não pode ser semestral.
    */
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
    
    /*
        Método: selecionarTipoVestibular
        Parâmetros: vazio
        Descrição: Ao selecionar o tipo vestibular, deseleciona o enem (não pode marcar as duas opções);
        ativa a combo box universidade e ativa o periodo semestral.
    */
    public void selecionarTipoVestibular(){        
        //Deseleciona a opção tipo enem (não pode marcar as duas opções)
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