
package controller;

import dao.Conexao;
import dao.TurmaDAO;
import dao.UniversidadeDAO;
import interfaces.Cadastrar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turmas;
import model.Universidade;
import telas.GerenciarTurma;



public class GerenciarTurmaController implements Cadastrar{
    //Declaração do atributo que possui a tela CadastroTurma
    private final GerenciarTurma view;
    
    //Construtor
    public GerenciarTurmaController(GerenciarTurma view) {
        this.view = view;
    }
    
    
     /*
        Método: salvarCadastro
        Parâmetros: vazio
        Descrição: pega os dados inseridos nos campos da tela e salva no banco de dados    
    */  
    @Override
    public void salvarCadastro(){  
        
        if(!exibirAlertarCampos()){
            /*Pega as informações passadas nos campos da tela*/
            String nome = view.getTxtNome().getText();
            String universidade = view.getCampoUniversidade().getSelectedItem().toString();
            String horario = view.getCampoHorario().getSelectedItem().toString();
            //Se for verdadeiro é enem, senão é vestibular
            boolean tipo = view.getRdbEnem().isSelected();
            //Se for verdadeiro é anual, senão é semestral
            boolean periodo = view.getRdbAnual().isSelected();
        
            /*Instaciando o objeto turma com os dados recebidos pela tela*/
            Turmas turma = new Turmas(nome, horario, tipo , periodo, 60, universidade);
        
            /*Conexão com o banco de dados para salvar os dados da turma na tabela turma*/
            Connection conexao;
            try {
                //Faz a conexão com o banco
                conexao = new Conexao().getConnection();
                //Passa a conexão para a classe TurmaDAO que possui o CRUD
                TurmaDAO turmaDAO = new TurmaDAO(conexao);
                //Chama o método de inserção 
                turmaDAO.insert(turma);
                //Mensagem de turma cadastrada com sucesso
                JOptionPane.showMessageDialog(null, "Turma criada com sucesso");     
                // Atualiza a tabela com a nova turma
                inserirDadosTurmaTabela();
                            
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarTurmaController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Falha ao criar turma!");
            }
        }
        
    }
    
    
    /*
        Método: editarCadastro
        Parâmetros: vazio
        Descrição: pega os novos dados inseridos na tela e atualiza a turma   
    */
    @Override
    public void editarCadastro(){
        //Se não tiver aparecido alerta de campos vazios
        if(!exibirAlertarCampos()){            
            try {
                
                /*Pega as informações passadas nos campos da tela*/
                String nome = view.getTxtNome().getText();
                String universidade = view.getCampoUniversidade().getSelectedItem().toString();
                String horario = view.getCampoHorario().getSelectedItem().toString();
                boolean tipo = view.getRdbEnem().isSelected();
                boolean periodo = view.getRdbAnual().isSelected();
                /*Acha o id da turma na tabela*/
                int id = buscarIdTurmaTabela();                
                
                /*Instaciando o objeto turma com os dados recebidos pela tela para atualizar*/
                Turmas turma = new Turmas(id,nome, horario, tipo, periodo, universidade);     
  
                /*Conexão com o banco de dados para salvar os dados da universidade na tabela e banco de dados*/
                Connection conexao;
                try {
                    //Faz a conexão com o banco
                    conexao = new Conexao().getConnection();
                    //Passa a conexão para a classe TurmaDAO que possui o CRUD
                    TurmaDAO turmaDAO = new TurmaDAO(conexao);
                    //Chama o método update e atualiza no banco de dados e na tabela
                    turmaDAO.update(turma);
                    //Mensagem de turma editada com sucesso
                    JOptionPane.showMessageDialog(null, "Turma editada com sucesso");
                    //Volta a tela para como era no inicio
                    cancelar();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarTurmaController.class.getName()).log(Level.SEVERE, null, ex);
                    //Caso dê erro mostra essa tela
                    JOptionPane.showMessageDialog(null, "Falha ao editar dado no banco");
                }

            } catch (SQLException ex) {
                Logger.getLogger(GerenciarTurmaController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        view.getTxtNome().setText("");
        view.getCampoHorario().setSelectedItem("Selecione");
        view.getCampoUniversidade().setSelectedItem("Selecione");
        view.getRdbEnem().setSelected(false);
        view.getRdbAnual().setSelected(false);
        view.getRdbSemestral().setSelected(false);
        view.getRdbVestibular().setSelected(false);
    }
    
    

    /*
        Método: exibirAlertarCampos
        Parâmetros: vazio
        Descrição: Avisa se algum campo esta em branco
    */
    @Override
    public boolean exibirAlertarCampos(){        
        //Se o enem tiver selecionado 
        if(!view.getCampoUniversidade().isEnabled()){
            
            if(view.getTxtNome().getText().equals("")  ||
            view.getCampoHorario().getSelectedItem().equals("Selecione")){         
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true; } else return false;
        }else{
                
            if(view.getTxtNome().getText().equals("")                      ||
            view.getCampoHorario().getSelectedItem().equals("Selecione")   ||
            view.getCampoUniversidade().getSelectedItem().equals("Selecione")   
                ){            
            
            //Mostra a mensagem para preencher todos os campos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            return true;
                } else return false;
            }
         }
        
        
 
    
    
    /*
        Método: removerCadastro
        Parâmetros: vazio
        Descrição: remove a turma do banco de dados  
    */
    @Override
    public void removerCadastro(){
        //Verifica se selecionou alguma linha da tabela
        if(view.getTblTurma().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma turma para descadastrar.");
        }else{
            try {
                // Criar uma lista de todas as turmas cadastradas
                ArrayList<Turmas> turmaBanco = carregarDadosTurma();
                // Captura qual a linha selecionada da tabela de turmas
                int linha = view.getTblTurma().getSelectedRow();
                // Verifica se a linha selecionada é válida
                if(linha >= 0 && linha < turmaBanco.size()){
                    // Captura o objeto selecionado na tabela turma
                    Turmas turma = turmaBanco.get(linha);
                    //Faz a conexão com o banco
                    Connection conexao = new Conexao().getConnection();
                    //Passa a conexão para a classe TurmaDAO para realizar o CRUD
                    TurmaDAO turmaDAO = new TurmaDAO(conexao);
                    //Chama o método delete
                    turmaDAO.delete(turma);
                    //Mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Turma descadastrada!");
                    //Retornar as configurações padrões de inicio
                    cancelar();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma linha válida!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarTurmaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    /*
        Método: inserirCampos
        Parâmetros: vazio
        Descrição: pega os dados do banco e insere na tela   
    */  
    public void inserirCampos() throws SQLException{
        //Descobre qual linha da tabela o mouse clicou
        int linha = view.getTblTurma().getSelectedRow();
        //Salva na variável a lista de todas as turmas do banco
        ArrayList<Turmas> turmaBanco = carregarDadosTurma();
        //Verifica se a linha é válida
        if(linha >= 0 && linha < turmaBanco.size()){
            //Pega a turma da lista de acordo com a linha clicada
            Turmas turma = turmaBanco.get(linha);
            /*Inserção de dados nos campos*/
            view.getTxtNome().setText(turma.getNome());
            view.getCampoUniversidade().setSelectedItem(turma.getNomeUniversidade());
            view.getCampoHorario().setSelectedItem(turma.getHorario());
            
            /*Regras para inserir o periodo da turma*/
            view.getRdbAnual().setSelected(turma.getPeriodo());
            view.getRdbSemestral().setSelected(!turma.getPeriodo());
            
            /*Regras para inserir o tipo da turma*/
            view.getRdbEnem().setSelected(turma.getTipo());
            view.getRdbVestibular().setSelected(!turma.getTipo());
         
            //Ao clicar em uma linha os botões editar e remover agora podem ser selecionados
            view.getLblEditar().setEnabled(true);
            view.getLblRemover().setEnabled(true);
      
        }else{
            JOptionPane.showMessageDialog(null, "Seelcione uma linha válida.");
        }
        
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
        inserirDadosTurmaTabela();
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
            view.getTblTurma().setVisible(true);

        }
    
    

     /*
        Método: desativarCampos
        Parâmetros: vazio
        Descrição: Desativa todos os campos de inserção de dados   
    */
    public void desativarCampos(){
        view.getTxtNome().setEnabled(false);
        view.getCampoHorario().setEnabled(false);
        view.getCampoUniversidade().setEnabled(false);
        view.getRdbAnual().setEnabled(false);
        view.getRdbEnem().setEnabled(false);
        view.getRdbSemestral().setEnabled(false);
        view.getRdbVestibular().setEnabled(false);
    }
    
    

    /*
        Método: ativarCampos
        Parâmetros: vazio
        Descrição: Ativa todos os campos de inserção de dados   
    */
    public void ativarCampos(){
        view.getTxtNome().setEnabled(true);
        view.getCampoHorario().setEnabled(true);
        view.getCampoUniversidade().setEnabled(true);
        view.getRdbAnual().setEnabled(true);
        view.getRdbEnem().setEnabled(true);
        view.getRdbSemestral().setEnabled(true);
        view.getRdbVestibular().setEnabled(true);
        
    }
     
      
    /*
        Método: buscarIdTurmaTabela
        Parâmetros: vazio
        Descrição: acha qual o id da turma clicada na tabela  
    */
    private int buscarIdTurmaTabela() throws HeadlessException, SQLException {
        // Criar uma lista de todas as turmas cadastradas
        ArrayList<Turmas> turmaBanco = carregarDadosTurma();
        // Captura qual a linha selecionada da tabela de turmas
        int linha = view.getTblTurma().getSelectedRow();

        int id = 0;
        // Verifica se a linha selecionada é válida
        if(linha >= 0 && linha < turmaBanco.size()){
            // Captura o objeto selecionado na tabela turma
            Turmas turma = turmaBanco.get(linha);
            // Captura o id da turma selecionada
            id = turma.getId();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha valida na tabela!");
        }
        return id;
    }
    
    
    /*
        Método: buscarCadastro
        Parâmetros: vazio
        Descrição: busca uma turma específica ao pedir o id e insere os dados na tela
    */
    public void buscarCadastro() throws SQLException, ParseException{
        String idString = (JOptionPane.showInputDialog("Digite o id da turma:"));        
        
        // Condição que irá garantir que o retorno do JOptionPane nao seja nulo
        if(idString != null){
            int id = Integer.parseInt(idString);
            int posicaoAlunoLista = posicaoTurmaLista(id);
            
            if(posicaoAlunoLista != -1){
                Turmas turma = buscarTurmaPorId(id);
                
                //Insere os dados encontrados nos campos para edição
                view.getTxtNome().setText(turma.getNome());
                view.getCampoHorario().setSelectedItem(turma.getHorario());
                view.getCampoUniversidade().setSelectedItem(turma.getNomeUniversidade());
                // Se a expressao for verdaeira o tipo da turma é enem, senao vestibular
                view.getRdbEnem().setSelected(turma.getTipo());
                view.getRdbVestibular().setSelected(!turma.getTipo());          
                // Se a expressao for verdadeira o periodo da turma é Anual, senao Semestral
                view.getRdbAnual().setSelected(turma.getPeriodo());
                view.getRdbSemestral().setSelected(!turma.getPeriodo());       
               
                desativarCampos();
                //Ativa todos os botoes principais da tela
                regraBotoesBuscar();                
                
                inserirDadosTurmaTabela();                
                
                view.getTblTurma().addRowSelectionInterval(posicaoAlunoLista, posicaoAlunoLista);
           
            }else{
                JOptionPane.showMessageDialog(null, "Turma não cadastrada!");
            } 
        }
    }
    

    /*
        Método: regraBotoesBuscar
        Parâmetros: vazio
        Descrição: Ativa os botoes principais da tela
    */
    public void regraBotoesBuscar(){
        view.getLblRemover().setVisible(true);
        view.getLblRemover().setEnabled(true);
        view.getLblEditar().setVisible(true);
        view.getLblEditar().setEnabled(true);
        view.getLblBuscar().setVisible(true);
        view.getLblBuscar().setEnabled(true);
        view.getLblCadastrar().setVisible(true);
        view.getLblCadastrar().setEnabled(true);
        view.getLblCancelar().setVisible(false);
        view.getLblSalvarEditar().setVisible(false);
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
        view.getTblTurma().setVisible(false);
    }
    
    
    /*
        Método: posicaoTurmaLista
        Parâmetros: inteiro
        Descrição: pesquisa a posição da turma na lista vindo do banco
    */
    public int posicaoTurmaLista(int id) throws SQLException, ParseException{
        ArrayList<Turmas> turma = carregarDadosTurma();
        
        for(int i = 0; i <turma.size(); i++){
            if(id == turma.get(i).getId()){
                return i;
            }
            
        }
        return -1;
    }
    
    
    /*
        Método: buscarTurmaPorId
        Parâmetros: inteiro
        Descrição: busca os dados de uma turma de acordo com o id dela
    */
    public Turmas buscarTurmaPorId(int id) throws SQLException, ParseException{
        //Faz a conexão com o banco 
        Connection conexao;
        conexao = new Conexao().getConnection();
        //Passa a conexão para a classe TurmaDAO para realizar o CRUD
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        //Chama o método findAll que retorna uma lista de turmas que está no banco de dados
        Turmas turma = turmaDAO.findById(id); 
        return turma;
    }
    
  
    /*
        Método: botaoEditarCadastro
        Parâmetros: vazio
        Descrição: Verifica se tem alguma linha da tabela selecionada para que seja possivel editar
    */
    public void botaoEditarCadastro(){
        if(view.getTblTurma().getSelectedRow() == -1){
            JOptionPane.showMessageDialog(view, "Selecione alguma turma para editar.");
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
    public void botaoCadastrar() throws SQLException{
        regraBotoesCadastrar();
        ativarCampos();
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
        Método: inserirDadosTurmaTabela
        Parâmetros: vazio
        Descrição: insere as informações da tabela turma do banco de dados na tabela da tela
    */
    public void inserirDadosTurmaTabela() throws SQLException{
        // Variavel que recebe uma lista de turmas
        ArrayList<Turmas> turmaBanco = carregarDadosTurma();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Tipo", "Período", "Horário"}, 0);
        
        //Tratar informações para inserir na tabela
        turmaBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getTipo(), e.getPeriodo(), e.getHorario()};
            modelo.addRow(linha);        
        });
        
        view.getTblTurma().setModel(modelo);
        
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
        Método: carregarDadosTurma
        Parâmetros: vazio
        Descrição: retorna a lista de turmas que está persistido no banco de dados
    */
    public ArrayList<Turmas> carregarDadosTurma() throws SQLException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        
        ArrayList<Turmas> turmaBanco = turmaDAO.findAll();
        
        return turmaBanco;
        
    }
    
    /*
        Método: selecionarPeriodoSemestral
        Parâmetros: vazio
        Descrição: Ao selecionar o periodo semestral, deseleciona o anual e desativa a opção enem, pois na regra de negocio
        o tipo enem não pode ser semestral. 
    */
    public void selecionarPeriodoSemestral(){
        //Desativa a opção anual, pois foi escolhida a semestral (não pode escolher os dois).
        view.getRdbAnual().setSelected(false);
        //Desativar a opçao enem, pois não existe turma semestral para enem.
        view.getRdbEnem().setEnabled(false);
    }
    
    /*
        Método: selecionarPeriodoAnual
        Parâmetros: vazio
        Descrição: Ao selecionar o periodo anual, deseleciona o semestral e ativa a opção enem, pois na regra de negocio
        o tipo enem só pode ser anual. 
    */
    public void selecionarPeriodoAnual(){
    
        view.getRdbEnem().setEnabled(true);
        view.getRdbSemestral().setSelected(false);
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
        view.getRdbVestibular().setSelected(false);

        // Desativa a opção de inserção do nome da Universidade e limpa o campo, pois em enem não escolhe a universidade
        view.getCampoUniversidade().setEnabled(false);
        view.getCampoUniversidade().setSelectedItem("Selecione");
        
        //Ativa a opção anual e desativa a opção semestral, pois enem não pode ser semestral 
        view.getRdbAnual().setSelected(true);
        view.getRdbSemestral().setEnabled(false);    
    }
    
    /*
        Método: selecionarTipoVestibular
        Parâmetros: vazio
        Descrição: Ao selecionar o tipo vestibular, deseleciona o enem (não pode marcar as duas opções);
        ativa a combo box universidade e ativa o periodo semestral.
    */
    public void selecionarTipoVestibular(){        
        //Deseleciona a opção tipo enem (não pode marcar as duas opções)
        view.getRdbEnem().setSelected(false);
        
        //Ativa a opção semestral
        view.getRdbSemestral().setEnabled(true);
        
        //Ativa o combo box para inserção do nome da Universidade
        view.getCampoUniversidade().setEnabled(true);    
    
    }
    
    
}
