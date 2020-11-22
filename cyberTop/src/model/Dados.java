/*package model;
//
// Super classe abstrata que contem atributos comuns da classe Alunos, Diretor e Professores

import java.time.YearMonth;

public abstract class Dados {
    // Declaração de atributos
    private String CPF;
    private String nome;
    private YearMonth dataNascimento;
    private String telefone;
    //private int idade;
    private char genero;
    
    
    // Construtores 
    public Dados(){
        
    }
    
     public Dados(String CPF, String nome, YearMonth dataNascimento, String telefone, char genero) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.genero = genero;
    }
    
    // Métodos getters e setters

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public YearMonth getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(YearMonth dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    // Demais métodos
    @Override
    public String toString() {
        return "CPF = " + CPF + "\nNome=" + nome +  "\nData de nascimento=" + dataNascimento + "\n";
    }
   
    
    
}
*/