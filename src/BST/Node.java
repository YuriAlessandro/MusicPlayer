/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import musicplayer.User;

/**
 * Classe que representa o nó de uma árvore. Nesse caso, o nó possui uma key (User) e dois filhos:
 * A sub-árvore a esquerda e a sub-árvore a direita.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 * @see Arvore
 * @version 20160211
 *
 */

public class Node {
    private User key;
    private Node lst; // Sub-árvore a esquerda
    private Node rst; // Sub-árvore a direita
    private int height;

    /**
     * Construtor de um nó. Ele inicia o nó com a chave e determina que os dois filhos do nó serão nulos.
     * Além disso, determina que a altura do nó na árvore será 1.
     * @param key Usuário que será armazenado no nó.
     */
    public Node(User key) {
        this.key = key;
        this.rst = null;
        this.lst = null;
        this.height = 1;
    }

    /**
     * Obtem a chave de um nó.
     * @return Usuário armazenado no nó.
     */
    public User getKey() {
        return key;
    }

    /**
     * Determina a chave de um nó.
     * @param key Novo usuário a ser armazenado no nó.
     */
    public void setKey(User key) {
        this.key = key;
    }

    /**
     * Obtem a sub-árvore a esquerda de um nó (filho esquerdo).
     * @return Sub-árvore a esquerda de um nó.
     */
    public Node getLst() {
        return lst;
    }

    /**
     * Determina um novo filho esquerdo de um nó.
     * @param lst Novo nó que será a sub-árvore a esquerda do nó.
     */
    public void setLst(Node lst) {
        this.lst = lst;
    }

    /**
     * Obtem a sub-árvore a direita de um nó (filho direito).
     * @return Sub-árvore a direita de um nó.
     */
    public Node getRst() {
        return rst;
    }

    /**
     * Determina um novo filho direito de um nó.
     * @param rst Novo nó que será a sub-árvore a direita do nó.
     */
    public void setRst(Node rst) {
        this.rst = rst;
    }

    /**
     * Obtem a altura de um nó.
     * @return Altura do nó.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Determina a altura de um nó.
     * @param height Nova altura do nó.
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
