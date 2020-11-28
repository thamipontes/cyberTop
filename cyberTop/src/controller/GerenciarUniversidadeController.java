package controller;

import dao.Conexao;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Universidade;
import telas.GerenciarUniversidade;

public class GerenciarUniversidadeController {
    private final GerenciarUniversidade view;
    
    public GerenciarUniversidadeController(GerenciarUniversidade view){
        this.view = view;
        
    }
    
    
    public boolean exibirAlertarCampos(){        
        //Descobre se algum dos campos ficou vazio
        if(view.getTxtNome().getText().equals("")                       ||
            view.getCmbEstado().getSelectedItem().equals("Selecione")   ||
            view.getTxtCampus().getText().equals("")){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
        }
        
        return false;
    }
    
    public void buscar() throws SQLException, ParseException{
        String idString = (JOptionPane.showInputDialog("Digite o id da universidade:"));
        int id;
        
        // Condição que irá garantir que o retorno do JOptionPane nao seja nulo
        if(idString != null){
            id = Integer.parseInt(idString);
            
            if(posicaoUniversidadeLista(id)  != -1){
                Universidade universidade = buscarUniversidadePorId(id);
                inserirBuscarDadosUniversidade(universidade);
                desativarCampos();
                //ativarTodosBotoes();
                inserirDadosUniversidadeTabela();
                view.getTblUniversidade().addRowSelectionInterval(posicaoUniversidadeLista(id),posicaoUniversidadeLista(id));
           
            }else{
                JOptionPane.showMessageDialog(null, "Universidade não cadastrada!");
            } 
        }
    }
    
    public int posicaoUniversidadeLista(int id) throws SQLException, ParseException{
        ArrayList<Universidade> universidade = carregarDadosUniversidade();
        
        for(int i = 0; i <universidade.size(); i++){
            if(id == universidade.get(i).getId()){
                return i;
            }
            
        }
        return -1;
    }
    
    public Universidade buscarUniversidadePorId(int id) throws SQLException, ParseException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
        //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
        Universidade universidade = universidadeDAO.findById(id); 
        return universidade;
    }
    
    
    public void cancelar() throws SQLException{
        limparCampos();
        desativarCampos();
        configuracaoInicialBotoes();
        inserirDadosUniversidadeTabela();
    }
    
    public void salvarEditar() throws ParseException, SQLException{
        
        if(!exibirAlertarCampos()){
            
                /*Pega as informações passadas nos campos da tela*/
            String nome = view.getTxtNome().getText();
            String estado = view.getCmbEstado().getSelectedItem().toString();
            String campus = view.getTxtCampus().getText();

            // Criar uma lista de todas as universidades cadastradas
            ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
            // Captura qual a linha selecionada da tabela de universidades
            int linha = view.getTblUniversidade().getSelectedRow();
            
            // 
            int id=0;
            // Verificação se alguma linha da tabela de universidade foi selecionada
            if(linha >= 0 && linha < universidadeBanco.size()){
                // Captura o objeto selecionado na tabela universidade
                Universidade universidade = universidadeBanco.get(linha);
                // Captura o id da turma selecionada
                id = universidade.getId();
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma linha valida na tabela!");
            }
            
            
            /*Instaciando o objeto aluno com os dados recebidos pela tela para atualizar*/
            Universidade universidade = new Universidade(id, nome, estado, campus);


            
            /*Conexão com o banco de dados para salvar os dados da universidade na tabela e banco de dados*/
            Connection conexao;        
            try {
            //Faz a conexão com o banco
                conexao = new Conexao().getConnection();
                //Passa a conexão para a classe AlunosDAO que possui o CRUD
                UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
               //Chama o método de inserção e atualiza no banco de dados e na tabela           
                universidadeDAO.update(universidade);
                //Mensagem de aluno cadastrado com sucesso
                JOptionPane.showMessageDialog(null, "Universidade editada com sucesso");
                inserirDadosUniversidadeTabela();

                  //aumentarVagasTurma(aluno.getTurmaId());

            } catch (SQLException ex) {
                Logger.getLogger(GerenciarUniversidadeController.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }  
                
                limparCampos();
                desativarCampos();
                cancelar();
        }
    }
    
    //Limpa os campos da tela
    public void limparCampos(){
        view.getTxtCampus().setText("");
        view.getTxtNome().setText("");
        view.getCmbEstado().setSelectedItem("Selecione");
    }
    
    
    
    public void editar(){
        if(view.getTblUniversidade().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma universidade para poder editar.");
        }else{
            ativarCampos();
            regraBotoesEditar();
        }
    }
    
    public void regraBotoesBuscar(){
        view.getLblRemover().setEnabled(true);
        view.getLblRemover().setVisible(true);
        view.getLblEditar().setEnabled(true);
        view.getLblEditar().setVisible(true);
        view.getLblBuscar().setEnabled(true);
        view.getLblBuscar().setVisible(true);
        view.getLblCadastrar().setEnabled(true);
        view.getLblCadastrar().setVisible(true);
        view.getLblCancelar().setVisible(false);
        view.getLblSalvar().setVisible(false);
    }
    
    public void regraBotoesEditar(){
        view.getLblRemover().setVisible(false);
        view.getLblEditar().setVisible(false);
        view.getLblBuscar().setVisible(false);
        view.getLblCadastrar().setVisible(false);
        view.getLblCancelar().setVisible(true);
        view.getLblSalvar().setVisible(true);
    }
    
    // Regra especial para ativar e desativar botoes
    public void configuracaoInicialBotoes(){
        view.getLblRemover().setEnabled(false);
        view.getLblRemover().setVisible(true);
        view.getLblEditar().setEnabled(false);
        view.getLblEditar().setVisible(true);
        view.getLblBuscar().setEnabled(true);
        view.getLblBuscar().setVisible(true);
        view.getLblCadastrar().setEnabled(true);
        view.getLblCadastrar().setVisible(true);
        view.getLblCancelar().setVisible(false);
        view.getLblSalvar().setVisible(false);
        
    }
    
    // Ativa todos os campos da tela
    public void ativarCampos(){
        view.getTxtCampus().setEnabled(true);
        view.getTxtNome().setEnabled(true);
        view.getCmbEstado().setEnabled(true);
        
    }
    
    // Desativa todos os campos da tela
    public void desativarCampos(){
        view.getTxtCampus().setEnabled(false);
        view.getTxtNome().setEnabled(false);
        view.getCmbEstado().setEnabled(false);
    }
    
    public void inserirCampos() throws SQLException{
        ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
        int linha = view.getTblUniversidade().getSelectedRow();
        
        if(linha >= 0 && linha < universidadeBanco.size()){
            Universidade universidade = universidadeBanco.get(linha);
            view.getTxtNome().setText(universidade.getNome());
            view.getTxtCampus().setText(universidade.getCampus());
            view.getCmbEstado().setSelectedItem(universidade.getEstado());
            
            //Regras de botoes
            view.getLblEditar().setEnabled(true);
            view.getLblRemover().setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma universidade válida!");
        }
    }
    
    
    // Conecta-se com o banco de dados e retorna uma lista de universidades cadastradas
    public ArrayList<Universidade> carregarDadosUniversidade() throws SQLException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
        
        ArrayList<Universidade> universidadeBanco = universidadeDAO.findAll();
        
        return universidadeBanco;
        
    }
    
    
    //Insere todas as universidades na tabela
    public void inserirDadosUniversidadeTabela() throws SQLException{
        ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Campus"}, 0);
        
        
        universidadeBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getCampus()};
            modelo.addRow(linha);        
        });
        
        view.getTblUniversidade().setModel(modelo);
        
    }

    private void inserirBuscarDadosUniversidade(Universidade universidade) {
        view.getTxtNome().setText(universidade.getNome());
        view.getTxtCampus().setText(universidade.getCampus());
        view.getCmbEstado().setSelectedItem(universidade.getEstado());
        ativarCampos();
        regraBotoesBuscar();
    }
    
}
