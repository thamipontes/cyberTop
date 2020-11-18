package classes;

// Super classe abstrata que contem atributos comuns da classe Alunos, Diretor e Professores
public class Dados {
    // Declaração de atributos
    private String CPF;
    private String nome;
    private String dataCriacao;
    private String nascimento;
    
    // Construtores 
    public Dados(){
        
    }
    
    public Dados(String CPF, String nome, String dataCriacao, String nascimento){
        this.CPF = CPF;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.nascimento = nascimento;
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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
    // Demais métodos
    @Override
    public String toString() {
        return "CPF = " + CPF + "\nNome=" + nome + "\nDataCriacao = " + dataCriacao + "\nNascimento=" + nascimento + "\n";
    }
   
    
    
}
