package controller;

import dao.Conexao;
import dao.UniversidadeDAO;
import interfaces.Cadastrar;
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

public class GerenciarUniversidadeController implements Cadastrar{
    //Declaração do atributo que possui a tela CadastroTurma
    private final GerenciarUniversidade view;
    
    //Construtor
    public GerenciarUniversidadeController(GerenciarUniversidade view){
        this.view = view;
        
    }
    
    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: Avisa se algum campo esta em branco
    */
    @Override
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
    
    
    
    /*
        Método: buscarCadastro
        Parâmetros: vazio
        Descrição: busca uma aluno específico ao pedir o id e insere os dados na tela
    */
    public void buscarCadastro() throws SQLException, ParseException{
        String idString = (JOptionPane.showInputDialog("Digite o id da universidade:"));
        int id;
        
        // Condição que irá garantir que o retorno do JOptionPane nao seja nulo
        if(idString != null){
            id = Integer.parseInt(idString);
            int posicaoUniversidadeLista = posicaoUniversidadeLista(id);
            
            if( posicaoUniversidadeLista != -1){
                Universidade universidade = buscarUniversidadePorId(id);
                inserirBuscarDadosUniversidade(universidade);
                desativarCampos();
                //ativarTodosBotoes();
                inserirDadosUniversidadeTabela();
                view.getTblUniversidade().addRowSelectionInterval(posicaoUniversidadeLista, posicaoUniversidadeLista);
           
            }else{
                JOptionPane.showMessageDialog(null, "Universidade não cadastrada!");
            } 
        }
    }
    
    
    
    /*
        Método: posicaoUniversidadeLista
        Parâmetros: inteiro
        Descrição: pesquisa a posição do aluno na lista vindo do banco
    */
    public int posicaoUniversidadeLista(int id) throws SQLException, ParseException{
        ArrayList<Universidade> universidade = carregarDadosUniversidade();
        
        for(int i = 0; i <universidade.size(); i++){
            if(id == universidade.get(i).getId()){
                return i;
            }
            
        }
        return -1;
    }
    
    
    
    /*
        Método: buscarAlunoPorId
        Parâmetros: inteiro
        Descrição: busca os dados de uma universidade de acordo com o id dela
    */
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
    
    
    /*
        Método: cancelar
        Parâmetros: vazio
        Descrição: volta a tela como estavam antes   
    */
    public void cancelar() throws SQLException{
        limparCampos();
        desativarCampos();
        configuracaoInicialBotoes();
        inserirDadosUniversidadeTabela();
    }
 
    
    /*
        Método: editarCadastro
        Parâmetros: vazio
        Descrição: pega os novos dados inseridos na tela e atualiza a turma   
    */
    @Override
    public void editarCadastro(){
        
        if(!exibirAlertarCampos()){
            
            try {
                
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
                    cancelar();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarUniversidadeController.class.getName()).log(Level.SEVERE, null, ex);
                    //Caso dê erro mostra essa tela
                    JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }                

                
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarUniversidadeController.class.getName()).log(Level.SEVERE, null, ex);
                }  
        }
    }
    
    
    
    /*
        Método: limparCampos
        Parâmetros: vazio
        Descrição: limpa todos os campos da tela
    */
    @Override
    public void limparCampos(){
        view.getTxtCampus().setText("");
        view.getTxtNome().setText("");
        view.getCmbEstado().setSelectedItem("Selecione");
    }
    
    
    /*
        Método: salvarCadastro
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */  
    @Override
    public void salvarCadastro(){
        if(!exibirAlertarCampos()){
            
            String nome = view.getTxtNome().getText();
            String estado = view.getCmbEstado().getSelectedItem().toString();
            String campus = view.getTxtCampus().getText();        
        
            Universidade universidade = new Universidade(nome, estado, campus);
        
            try{
                Connection conexao;
                conexao = new Conexao().getConnection();
                UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
                universidadeDAO.insert(universidade);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                cancelar();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarUniversidadeController.class.getName()).log(Level.SEVERE, null, ex);
                //Caso dê erro mostra essa tela
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar dado no banco");
            }           
            
        }
    
    }
    
    
    
    /*
        Método: botaoEditarCadastro
        Parâmetros: vazio
        Descrição: Verifica se tem alguma linha da tabela selecionada para que seja possivel editar
    */
    public void botaoEditarCadastro(){
        if(view.getTblUniversidade().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma universidade para editar.");
        }else{
            ativarCampos();
            regraBotoesEditar();
            
        }
    }
    
    
    /*
        Método: botaoCadastrar
        Parâmetros: vazio
        Descrição: ativa os campos e seta o padrão dos botões ao se cadastrar uma turma
    */ 
    public void botaoSalvarCadastro(){        
        limparCampos();
        ativarCampos();
        regraBotoesCadastrar();
    }
    
    
    
    /*
        Método: removerCadastro
        Parâmetros: vazio
        Descrição: remove a turma do banco de dados  
    */
    @Override
    public void removerCadastro(){
        if(view.getTblUniversidade().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma universidade paara descadastrar.");
        }else{
            
            try {
                ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
                int linha = view.getTblUniversidade().getSelectedRow();
                
                if(linha >= 0 && linha < universidadeBanco.size()){
                    
                    Universidade universidade = universidadeBanco.get(linha);
                    
                    Connection conexao = new Conexao().getConnection();
                    UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
                    
                    universidadeDAO.remove(universidade);
                    
                    inserirDadosUniversidadeTabela();
                    limparCampos();
                    
                    JOptionPane.showMessageDialog(null, "Universidade descadastrada!");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma linha válida!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarUniversidadeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    /*
        Método: regraBotoesBuscar
        Parâmetros: vazio
        Descrição: Ativa os botoes principais da tela
    */
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
        view.getLblSalvarEditar().setVisible(false);
        view.getLblSalvarCadastro().setVisible(false);
    }
    
    
    /*
        Método: regraBotoesEditar
        Parâmetros: vazio
        Descrição: Deixa apenas os botoes de salvar e cancelar ativos;
    */ 
    public void regraBotoesEditar(){
        view.getLblRemover().setVisible(false);
        view.getLblEditar().setVisible(false);
        view.getLblBuscar().setVisible(false);
        view.getLblCadastrar().setVisible(false);
        view.getLblCancelar().setVisible(true);
        view.getLblSalvarEditar().setVisible(true);
        view.getLblSalvarCadastro().setVisible(false);
    }
    
    
    
    /*
        Método: regraBotoesBuscar
        Parâmetros: vazio
        Descrição: Segue a regra de negocio para salvar a turma
    */
    public void regraBotoesCadastrar(){
        view.getLblRemover().setVisible(false);
        view.getLblEditar().setVisible(false);
        view.getLblBuscar().setVisible(false);
        view.getLblCadastrar().setVisible(false);
        view.getLblCancelar().setVisible(true);
        view.getLblSalvarEditar().setVisible(false);
        view.getLblSalvarCadastro().setVisible(true);
        view.getTblUniversidade().setVisible(false);
    }
    
    
    /*
        Método: configuracaoInicialBotoes
        Parâmetros: vazio
        Descrição: seta o padrão de botões para inicio da tela   
    */
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
        view.getLblSalvarEditar().setVisible(false);
        view.getLblSalvarCadastro().setVisible(false);
        view.getTblUniversidade().setVisible(true);
        
    }
    
    
    /*
        Método: ativarCampos
        Parâmetros: vazio
        Descrição: ativa todos os campos de inserção de dados   
    */
    public void ativarCampos(){
        view.getTxtCampus().setEnabled(true);
        view.getTxtNome().setEnabled(true);
        view.getCmbEstado().setEnabled(true);
        
    }
    
    /*
        Método: desativarCampos
        Parâmetros: vazio
        Descrição: Desativa todos os campos de inserção de dados   
    */
    public void desativarCampos(){
        view.getTxtCampus().setEnabled(false);
        view.getTxtNome().setEnabled(false);
        view.getCmbEstado().setEnabled(false);
    }
    
    
    
        
    /*
        Método: inserirCampos
        Parâmetros: vazio
        Descrição: pega os dados do banco e insere na tela   
    */ 
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
    
    
    
    /*
        Método: carregarDadosUniversidades
        Parâmetros: vazio
        Descrição: retorna a lista de universidades que está persistido no banco de dados
    */
    public ArrayList<Universidade> carregarDadosUniversidade() throws SQLException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
        
        ArrayList<Universidade> universidadeBanco = universidadeDAO.findAll();
        
        return universidadeBanco;
        
    }
    
    
    /*
        Método: inserirDadosUniversidadeTabela
        Parâmetros: vazio
        Descrição: insere as informações da tabela universidade do banco de dados na tabela da tela
    */
    public void inserirDadosUniversidadeTabela() throws SQLException{
        ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Campus"}, 0);
        
        
        universidadeBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getCampus()};
            modelo.addRow(linha);        
        });
        
        view.getTblUniversidade().setModel(modelo);
        
    } 
    
    
    
    /*
        Método: inserirDadosAluno
        Parâmetros: inteiro
        Descrição: insere os dados do aluno na tela
    */
    private void inserirBuscarDadosUniversidade(Universidade universidade) {
        view.getTxtNome().setText(universidade.getNome());
        view.getTxtCampus().setText(universidade.getCampus());
        view.getCmbEstado().setSelectedItem(universidade.getEstado());
        ativarCampos();
        regraBotoesBuscar();
    }
    
}
