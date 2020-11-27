package controller;

import dao.Conexao;
import dao.UniversidadeDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Universidade;
import telas.GerenciarUniversidade;

public class GerenciarUniversidadeController {
    private final GerenciarUniversidade view;
    
    public GerenciarUniversidadeController(GerenciarUniversidade view){
        this.view = view;
        
    }
    
    public ArrayList<Universidade> carregarDadosUniversidade() throws SQLException{
        Connection conexao;
        conexao = new Conexao().getConnection();
        
        UniversidadeDAO universidadeDAO = new UniversidadeDAO(conexao);
        
        ArrayList<Universidade> universidadeBanco = universidadeDAO.findAll();
        
        return universidadeBanco;
        
    }
    
    public void inserirDadosUniversidadeTabela() throws SQLException{
        ArrayList<Universidade> universidadeBanco = carregarDadosUniversidade();
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id", "Nome", "Campus"}, 0);
        
        
        universidadeBanco.forEach(e -> {        
            Object linha[] = new Object[]{e.getId(), e.getNome(), e.getCampus()};
            modelo.addRow(linha);        
        });
        
        view.getTblUniversidade().setModel(modelo);
        
    }
    
}
