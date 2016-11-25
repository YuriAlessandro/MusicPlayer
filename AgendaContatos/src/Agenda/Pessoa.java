package Agenda;

import java.time.LocalDate;
import java.time.Period;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yurialessandro
 */
public class Pessoa {

    private String nome;
    private LocalDate dataNasc;
    private String cpf;
    private String tel;

    public Pessoa(String nome, LocalDate dataNasc, String cpf, String tel) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public int calcularIdade(){
        LocalDate anoAtual = LocalDate.now();
        Period idade = Period.between(this.dataNasc, anoAtual);
        return idade.getYears();
    }

}
