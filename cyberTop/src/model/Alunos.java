package model;

import java.math.BigInteger;
import java.util.Calendar;

public class Alunos extends Pessoa{
    
    // Declaração de atributos
    private BigInteger id;    
    private Turmas turma;    
    private String CEP;   
    private String corRaca;    
    

    // Construtores 
    
    public Alunos(){
        
    }
    

    public Alunos(BigInteger id, String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                    Turmas turma, String CEP, String corRaca
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);
        this.id = id;
        this.turma = turma;
        this.CEP = CEP;
        this.corRaca = corRaca;        
    }
    
    
    public Alunos(String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                   String CEP, String corRaca
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);   
        this.CEP = CEP;
        this.corRaca = corRaca;        
    }  
    
   
    // Métodos getters e setters

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }
    
     
    
    
}
