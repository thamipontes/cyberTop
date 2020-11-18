package classes;
//
// Subclasse(classe filha) de Dados
public class Alunos extends Dados{
    // Declaração de atributos
    //private Turmas turma;
    private String endereco;
    
    
    /*
    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }
    */
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
