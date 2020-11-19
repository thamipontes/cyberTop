package cursinho;
//
// Super classe abstrata que contem atributos comuns da classe Alunos, Diretor e Professores

import java.time.YearMonth;

public class Dados {
    // Declaração de atributos
    private String CPF;
    private String nome;
    private YearMonth dataNascimento;
    private String telefone;
    private int idade;
    private char sexo;
    
    
    // Construtores 
    public Dados(){
        
    }
    
     public Dados(String CPF, String nome, YearMonth dataNascimento, String telefone, int idade, char sexo) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    // Métodos getters e setters

   
    
    
    
    
    // Demais métodos
    @Override
    public String toString() {
        return "CPF = " + CPF + "\nNome=" + nome +  "\nData de nascimento=" + dataNascimento + "\n";
    }
   
    
    
}
