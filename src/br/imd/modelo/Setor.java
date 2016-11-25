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
public class Setor {

    private int codigoSetor;
    private String descricaoSetor;

    public Setor(int codigoSetor, String descricaoSetor) {
        this.codigoSetor = codigoSetor;
        this.descricaoSetor = descricaoSetor;
        DAO d = new DAO();
        d.inserirSetor(this);
    }

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
    }

}
