package model;
//
// Super classe abstrata que contem atributos comuns da classe Alunos, Diretor e Professores

import java.util.Calendar;

public abstract class Pessoa {
    
    // Declaração de atributos
    
    private String nome;
    private String CPF;
    private Calendar dataNascimento;
    private String telefone;
    private String endereco;
    private char genero;
    
    
    // Construtores 
    public Pessoa(){
        
    }
    
     public Pessoa(String nome, String CPF, Calendar dataNascimento, String telefone, String endereco, char genero) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   
    
    
    // Demais métodos
    @Override
    public String toString() {
        return "CPF = " + CPF + "\nNome=" + nome +  "\nData de nascimento=" + dataNascimento + "\n";
    }
   
    
    
}
