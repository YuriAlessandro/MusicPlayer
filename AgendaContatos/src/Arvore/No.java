/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

import Agenda.Pessoa;

/**
 *
 * @author yurialessandro
 */
public class No {

    private Pessoa chave;
    private No sae; // Sub-árvores a esquerda
    private No sad; // Sub-árvore a direita
    private int altura;

    public No(Pessoa chave) {
        this.chave = chave;
        this.sad = null;
        this.sae = null;
        this.altura = 1;
    }

    public Pessoa getChave() {
        return chave;
    }

    public void setChave(Pessoa chave) {
        this.chave = chave;
    }

    public No getSae() {
        return sae;
    }

    public void setSae(No sae) {
        this.sae = sae;
    }

    public No getSad() {
        return sad;
    }

    public void setSad(No sad) {
        this.sad = sad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
