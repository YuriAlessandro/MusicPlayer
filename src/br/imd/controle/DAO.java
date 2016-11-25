/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.imd.controle;

import br.imd.modelo.Empregado;
import br.imd.modelo.Fornecedor;
import br.imd.modelo.Pessoa;
import br.imd.modelo.Setor;
import java.util.ArrayList;

/**
 *
 * @author yurialessandro
 */
public class DAO implements GenericDAO {

    public static ArrayList<Pessoa> pessoas = new ArrayList<>();
    public static ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    public static ArrayList<Empregado> empregados = new ArrayList<>();
    public static ArrayList<Setor> setores = new ArrayList<>();

    @Override
    public void inserirPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    @Override
    public void inserirFornecedor(Fornecedor f) {
        this.fornecedores.add(f);
    }

    @Override
    public void inserirEmpregado(Empregado e) {
        this.empregados.add(e);
    }

    @Override
    public void inserirSetor(Setor s) {
        this.setores.add(s);
    }

    @Override
    public void listarPessoas() {
        for (Pessoa p : this.pessoas) {
            System.out.println(p.getNome() + ", " + p.getEndereco()
                    + ", " + p.getSexo() + ", " + p.calcularIdade(2016));
        }
    }

    @Override
    public void listarFornecedores() {
        for (Fornecedor f : this.fornecedores) {
            System.out.println(f.getNome() + ", " + f.getEndereco()
                    + ", " + f.getSexo() + ", " + f.calcularIdade(2016) + ","
                    + f.obterSaldo());
        }
    }

    @Override
    public void listarEmpregados() {
        for (Empregado e : this.empregados) {
            System.out.println(e.getNome() + ", " + e.getEndereco()
                    + ", " + e.getSexo() + ", " + e.calcularIdade(2016) + ","
                    + e.calcularSalario());
        }
    }

    @Override
    public void listarSetores() {
        for (Setor s : this.setores) {
            System.out.println(s.getCodigoSetor() + " - " + s.getDescricaoSetor());
        }
    }

}
