package cursinho;
//
// Super classe abstrata que contem atributos comuns da classe Alunos, Diretor e Professores

import java.time.YearMonth;

public class Dados {
    // Declaração de atributos
    private String CPF;
    private String nome;
    private YearMonth dataNascimento;
    private int idade;
    private char sexo;
    
    //
    // Construtores 
    public Dados(){
        
    }
    
    public Dados(String CPF, String nome, YearMonth dataNascimento){
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
    
    // Demais métodos
    @Override
    public String toString() {
        return "CPF = " + CPF + "\nNome=" + nome +  "\nData de nascimento=" + dataNascimento + "\n";
    }
   
    
    
}
