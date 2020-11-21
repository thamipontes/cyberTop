package model;
//
// Subclasse(classe filha) de Dados

import java.math.BigInteger;
import java.util.Calendar;

public class Alunos extends Dados{
    // Declaração de atributos
    //private Turmas turma;
    //private int codigo; desnecessario
    private String CEP;
    private String logradouro;
    private String corRaca;
    private String observacoes;
    

    // Construtores

    private BigInteger id;
    private String nome;
    private String cpf;
    private Calendar data_nascimento;
    private String telefone;
    private String endereco;

    
    public Alunos(){
        
    }
    
    //Construtor para o teste com o banco de dados

    public Alunos(BigInteger id, String nome, String cpf, Calendar data_nascimento, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Alunos(String nome, String cpf, Calendar data_nascimento, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    
    
    
        
    /*
    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }
    */
    // Métodos getters e setters

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String endereco) {
        this.logradouro = endereco;
    }

    public String getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    // Demais vagas
    
    
    //Getters e Setters para o teste com banco de dados

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    
}
