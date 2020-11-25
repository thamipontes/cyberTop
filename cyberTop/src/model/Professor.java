package model;
//

import java.util.Calendar;

public class Professor extends Pessoa{
    private int id;
    private String materia;
    private Turmas turma;

    public Professor(int id, String materia, Turmas turma, String nome, String CPF, Calendar dataNascimento, String telefone, String endereco, char genero) {
        super(nome, CPF, dataNascimento, telefone, endereco, genero);
        this.id = id;
        this.materia = materia;
        this.turma = turma;
    }
    

    public int getId() {
        return id;
    }   

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
