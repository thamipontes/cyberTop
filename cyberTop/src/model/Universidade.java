/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thamires
 */
public class Universidade {
    private int id;
    private String nome;
    private String estado;
    private String campus;

    public Universidade(int id, String nome, String estado, String campus) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.campus = campus;
    }

    public Universidade(String nome, String estado, String campus) {
        this.nome = nome;
        this.estado = estado;
        this.campus = campus;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   
    
    
    
    @Override
    public String toString() {
        return "Universidade{" + "id=" + id + ", nome=" + nome + ", campus=" + campus + '}';
    }   
    
    
}
