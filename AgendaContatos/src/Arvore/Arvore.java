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
public class Arvore {
    private No raiz;
    
    
    public Arvore() {
    }
    
    public void inserir(Pessoa p){
        if(this.raiz == null){
            this.raiz = new No(p);
        }else{
            if(p.getNome().toLowerCase().compareTo(this.raiz.getChave().getNome()) == -1){
                System.out.println(this.raiz.getChave().getNome());
            }
        }
    }
    
    
}
