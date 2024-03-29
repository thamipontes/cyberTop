/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigInteger;

/**
 *
 * @author thamires
 */
public class Turmas {
    private int id;
    private String nome;
    private String horario;
    private Boolean tipo;
    private Boolean periodo;
    private int vagas;

    public Turmas(int id, String nome, String horario, Boolean tipo, Boolean periodo, int vagas) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.tipo = tipo;
        this.periodo = periodo;
        this.vagas = vagas;
    }
    
    
        public Turmas(String nome, String horario, Boolean tipo, Boolean periodo, int vagas) {
        this.nome = nome;
        this.horario = horario;
        this.tipo = tipo;
        this.periodo = periodo;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public Boolean getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Boolean periodo) {
        this.periodo = periodo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    
    
}
