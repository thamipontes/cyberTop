package controller;

import dao.AlunosDAO;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Alunos;

import telas.CadastroAluno;
import dao.Conexao;
import dao.TurmaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Turmas;
import telas.CadastroTurma;

/**
 *
 * @author thamires
 */

/*Classe que controla todas as regras de negócios do cadastro do Aluno*/
public class CadastroAlunoController {
    
    //Declaração do atributo que possui a tela CadastroAluno
    private CadastroAluno view;
    

    //Construtor
    public CadastroAlunoController(CadastroAluno view) {
        this.view = view;
    }

    /*
        Método: salvarAluno
        Parâmetros: vazio
        Descrição: pega os dados inseridos na tela e salva no banco de dados    
    */
    public void salvarAluno() throws ParseException, SQLException{
        
        /*Pegas as informações passadas nos campos da tela*/
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String telefone = view.getTxtTelefone().getText();
        String endereco = view.getTxtLogradouro().getText();
        String cep = view.getTxtCEP().getText();
        
        /*Transformando a data string para Date*/        
        String dataNascimentoString = view.getTxtDataNascimento().getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); //define padrão que a data deve obedecer
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(sdf.parse(dataNascimentoString));  
    
       /*Tratando o dado Genero*/       
        char genero = formatarGenero((view.getCmbGenero().getSelectedIndex()));        
    
       /*Tratando o dado Cor Raça*/
        String corRaca = view.getCmbCorRaca().getSelectedItem().toString();
        
       /*Tratando a turma*/
        int turmaId = Integer.parseInt(view.getTxtTurma().getText());
    
       /*Instaciando o objeto aluno com os dados recebidos pela tela*/
       Alunos aluno = new Alunos(nome, cpf, dataNascimento, telefone, endereco, genero, cep, corRaca, turmaId);
       
       /*Conexão com o banco de dados*/
        Connection conexao;        
        try {
            
            conexao = new Conexao().getConnection();
            AlunosDAO alunoDAO = new AlunosDAO(conexao);
            alunoDAO.insert(aluno);
        
            //Mensagem de aluno cadastrado com sucesso
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }
    
    /*
        Método: formatarGenero
        Parâmetros: index do tipo inteiro
        Descrição: Confere qual index foi selecionado na tela cadastro aluno do campo gênero 
    e retorna um char que indica se o gênero é não informado, masculino, feminino e outros    
    */
    public char formatarGenero(int index){        
        if(index == 1) return 'I'; //Prefiro não informar
        if(index == 2) return 'M'; //Masculino
        if(index == 3) return 'F'; //Feminino
        if(index == 4) return 'O'; //Outros       
        return ' '; 
    }
    
    
    public boolean exibirAlertarCampos(){        
        //Descobre se alguns dos campos ficaram vazios
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
    
    }
    
    
     private ArrayList<Turmas> carregarDadosTurma() throws SQLException {
        Connection conexao;
        conexao = new Conexao().getConnection();
        TurmaDAO turmaDAO = new TurmaDAO(conexao);
        ArrayList<Turmas> turmasBanco = turmaDAO.findAll();
        return turmasBanco;
    }
    
    
    public void inserirDadosTurmaTabela() throws SQLException{
        
        ArrayList<Turmas> turmasBanco = carregarDadosTurma();
    
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Horário", "Período", "Vagas"}, 0);
        
        turmasBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getHorario(), e.getPeriodo(), e.getVagas()};
            modelo.addRow(linha);        
        });        
        
        view.getTblTurmas().setModel(modelo);
    
    }

   
    public void salvarLinhaTurma() throws SQLException {
        
        ArrayList<Turmas> turmasBanco = carregarDadosTurma();
        
        int linha = view.getTblTurmas().getSelectedRow();
        
        //Conferindo se é uma linha inválida
        if(linha >= 0 && linha<turmasBanco.size()){
        
            Turmas turma = turmasBanco.get(linha);
            view.getTxtTurma().setText(String.valueOf(turma.getId()));
            view.getTxtTurma().setEnabled(false);

        }  
    
    }
    
}
