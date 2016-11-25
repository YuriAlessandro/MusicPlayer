/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.imd.modelo;

import br.imd.controle.DAO;

/**
 *
 * @author yurialessandro
 */
public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String sexo;
    private int anoNascimento;

    public Pessoa(String nome, String endereco, String telefone, String sexo, int anoNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.sexo = sexo;
        this.anoNascimento = anoNascimento;
        DAO d = new DAO();
        d.inserirPessoa(this);
    }
    
    public int calcularIdade(int ano){
        return (ano - this.anoNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    
    
}
