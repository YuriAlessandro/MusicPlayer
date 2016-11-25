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
public class Empregado extends Pessoa{
    private Setor setor;
    private double salarioBase;
    private int imposto;

    public Empregado(Setor setor, double salarioBase, int imposto, String nome, String endereco, String telefone, String sexo, int anoNascimento) {
        super(nome, endereco, telefone, sexo, anoNascimento);
        this.setor = setor;
        this.salarioBase = salarioBase;
        this.imposto = imposto;
        DAO d = new DAO();
        d.inserirEmpregado(this);
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getImposto() {
        return imposto;
    }

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }
    
    public double calcularSalario(){
        return (this.salarioBase - ((this.salarioBase * imposto)/100));
    }
}