package controller;

import dao.AlunosDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import telas.GerenciarAluno;

/**
 *
 * @author Jhonatan Borges
 */
public class GerenciarAlunoController {
    private final GerenciarAluno view;
    
    public GerenciarAlunoController(GerenciarAluno view){
        this.view = view;
    }
    
    public static ArrayList<Aluno> carregarDadosAluno() throws SQLException, ParseException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        AlunosDAO alunoDAO = new AlunosDAO(conexao);
        
        ArrayList<Aluno> alunoBanco = alunoDAO.findAll();
        
        return alunoBanco;
    }
    
    public void inserirDadosAlunoTabela() throws SQLException, ParseException{
        ArrayList<Aluno> alunosBanco = carregarDadosAluno();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome"}, 0);
        
        
        alunosBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome()};
            modelo.addRow(linha);        
        });
        
        view.getTblAluno().setModel(modelo);
        
    }
    
    
}
