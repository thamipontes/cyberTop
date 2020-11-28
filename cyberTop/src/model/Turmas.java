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
    private String nomeUniversidade;

    public Turmas(int id, String nome, String horario, Boolean tipo, Boolean periodo, int vagas, String nomeUniversidade) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.tipo = tipo;
        this.periodo = periodo;
        this.vagas = vagas;
        this.nomeUniversidade = nomeUniversidade;
    }

    public Turmas(String nome, String horario, Boolean tipo, Boolean periodo, int vagas, String nomeUniversidade) {
        this.nome = nome;
        this.horario = horario;
        this.tipo = tipo;
        this.periodo = periodo;
        this.vagas = vagas;
        this.nomeUniversidade = nomeUniversidade;
    }
    // Atualizar somente
    public Turmas(int id,String nome, String horario, Boolean tipo, Boolean periodo, String nomeUniversidade) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.tipo = tipo;
        this.periodo = periodo;
        this.nomeUniversidade = nomeUniversidade;
    }
  
    public Turmas(int id, String nome, String horario, Boolean tipo, Boolean periodo, int vagas) {
        this.id = id;
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

    public String getNomeUniversidade() {
        return nomeUniversidade;
    }

    public void setNomeUniversidade(String nomeUniversidade) {
        this.nomeUniversidade = nomeUniversidade;
    }

   

    @Override
    public String toString() {
        return "Turmas{" + "id=" + id + ", nome=" + nome + ", horario=" + horario + ", tipo=" + tipo + ", periodo=" + periodo + ", vagas=" + vagas + '}';
    }
    
    
    
    
}
