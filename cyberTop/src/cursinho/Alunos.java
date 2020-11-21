package cursinho;
//
// Subclasse(classe filha) de Dados
public class Alunos extends Dados{
    // Declaração de atributos
    //private Turmas turma;
    private int codigo;
    private String CEP;
    private String logradouro;
    private String corRaca;
    private String observacoes;
    
    
    
    /*
    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }
    */
    // Métodos getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
    
}
