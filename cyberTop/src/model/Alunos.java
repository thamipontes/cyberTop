package model;

import java.math.BigInteger;
import java.util.Calendar;

public class Alunos extends Pessoa{
    
    // Declaração de atributos
    private int id;    
    private int turmaId;    
    private String CEP;   
    private String corRaca;
    

    // Construtores 
    
    public Alunos(){
        
    }
    

    public Alunos(int id, String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                    int turmaId, String CEP, String corRaca
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);
        this.id = id;
        this.turmaId = turmaId;
        this.CEP = CEP;
        this.corRaca = corRaca;        
    }
    
    //Construtor para o método salvar no banco
    public Alunos(String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                   String CEP, String corRaca, int turmaId
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);   
        this.CEP = CEP;
        this.corRaca = corRaca; 
        this.turmaId = turmaId;
    }  

  
    

    // Métodos getters e setters
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }    
    
     
    
    
}
