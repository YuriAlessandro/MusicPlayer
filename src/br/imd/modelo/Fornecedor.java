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
public class Fornecedor extends Pessoa {

    private double valorCredito;
    private double valorDivida;

    public Fornecedor(double valorCredito, double valorDivida, String nome, String endereco, String telefone, String sexo, int anoNascimento) {
        super(nome, endereco, telefone, sexo, anoNascimento);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
        DAO d = new DAO();
        d.inserirFornecedor(this);
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public double obterSaldo() {
        return (this.valorCredito - this.valorDivida);
    }

}
