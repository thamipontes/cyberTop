package model;
//
public class Professor extends Pessoa{
    private String materia;
    private Turmas turma;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Professor{" + "materia=" + materia + ", turma=" + turma + '}';
    }
    
    
    
    
}
