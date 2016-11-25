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

/**
 *
 * @author yurialessandro
 */
public interface GenericDAO {
    public void inserirPessoa(Pessoa p);
    public void inserirFornecedor(Fornecedor f);
    public void inserirEmpregado(Empregado e);
    public void inserirSetor(Setor s);
    public void listarPessoas();
    public void listarFornecedores();
    public void listarEmpregados();
    public void listarSetores();
}
