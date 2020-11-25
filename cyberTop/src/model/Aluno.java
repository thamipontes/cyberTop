package model;

import java.math.BigInteger;
import java.util.Calendar;

public class Aluno extends Pessoa{
    
    // Declaração de atributos
    private int id;    
    private int turmaId;    
    private String CEP;   
    private String corRaca;
    private String email;
    private String curso;
    
    

    // Construtores 
    
    public Aluno(){
        
    }
    
    //Construtor para o método pesquisar
    public Aluno(int id, String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                    int turmaId, String CEP, String corRaca, String email, String curso
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);
        this.id = id;
        this.turmaId = turmaId;
        this.CEP = CEP;
        this.corRaca = corRaca;
        this.email = email;
        this.curso = curso;
    }
    
    //Construtor para o método salvar no banco
    public Aluno(String nome, String cpf, Calendar dataNascimento, String telefone, String endereco, char genero,
                   String CEP, String corRaca, int turmaId, String email, String curso
    ) {
        super(nome, cpf, dataNascimento, telefone, endereco, genero);   
        this.CEP = CEP;
        this.corRaca = corRaca; 
        this.turmaId = turmaId;
        this.email = email;
        this.curso = curso;
    }   
    

    // Métodos getters e setters
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", turmaId=" + turmaId + ", CEP=" + CEP + ", corRaca=" + corRaca + '}';
    }
    
    
    
     
    
    
}
