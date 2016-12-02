/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import java.util.ArrayList;
import musicplayer.User;

/**
 * Classe que implementa a TAD Árvore Binaria de Busca, utilizando um nó de usuário. 
 * Será utilizada para armazenagem de Users na agenda de contatos.
 * @see Node 
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 * @version 20160411
 *
 */
public class Tree {
    private Node root;

    /**
     * Construtor da árvore. Ela será iniciada sempre vazia e naturalmente crescera conforme
     * as inserções forem sendo feitas.
     */
    public Tree() {
    }

    /**
     * Insere novos usuários na árvore. Implementado de forma recursiva.
     * @see Pessoa 
     * @param p Novo usuário a ser adicionado na árvore.
     */
    public void insert(User p) {
        if (this.root == null) {
                this.root = new Node(p);
        } else {
            // O novo maior que a raíz:
            if(p.getId() > this.root.getKey().getId()){
//            if (p.getUserName().compareToIgnoreCase(this.root.getKey().getUserName()) > 0) {
                if (this.root.getRst() == null)
                        this.root.setRst(new Node(p));
                else {
                        this.insert(this.root.getRst(), p);
                }
                this.updateHeight(this.root);
            }
            // O novo menor que a root:
            else if (p.getId() < this.root.getKey().getId()) {
                if (this.root.getLst() == null)
                        this.root.setLst(new Node(p));
                else {
                        this.insert(this.root.getLst(), p);
                }
                this.updateHeight(this.root);
            }
            // O novo igual a root:
            else {
                // POSSIVEL LOCAL PARA JOGAR EXCEPTION:
                System.err.println("Usuário já existe.");
            }
        }

    }

    /**
     * Método auxiliar da recursão do método de inserir da árvore.
     * @param n No base para recursão.
     * @param p Novo usuário a ser adicionado.
     */
    private void insert(Node n, User p) {
        // O novo maior que a raíz:
        if (p.getId() > this.root.getKey().getId()) {
            if (n.getRst() == null)
                    n.setRst(new Node(p));
            else {
                    this.insert(n.getRst(), p);
            }
            this.updateHeight(n);
        }
        // O novo menor que a root:
        else if (p.getId() < this.root.getKey().getId()) {
            if (n.getLst() == null)
                    n.setLst(new Node(p));
            else {
                    this.insert(n.getLst(), p);
            }
            this.updateHeight(n);
        }
        // O novo igual a root:
        else {
            System.err.println("Usuário já existe.");
        }
    }

    /**
     * Remover um usuário da árvore. Método implementado de forma iterativa.
     * @param p Usuário que deverá ser removido
     * @return True, se o usuário foi removido com sucesso, False, caso contrário.
     */
    public boolean remove(User p) {

        if (this.root == null)
                return false;
        if (this.searchDepth(p.getId()) == null)
                return false;

        Node node_father = null; // Pai do nó a ser removido
        Node node_current = this.root; // Nó a ser removido
        ArrayList<Node> list = new ArrayList<>(); // Lista para atualizar altura depois

        // Busca do nó a ser removido
        while (p.getId()!= node_current.getKey().getId()) {
            node_father = node_current;
            list.add(node_father); // Nós do caminho são adicionados na lista
            if (p.getId() > node_current.getKey().getId())
                node_current = node_current.getRst();
            else
                node_current = node_current.getLst();			
        }

        // Remoção de nó folha
        if (node_current.getLst() == null && node_current.getRst() == null){

            if (node_current == this.root){
                this.setRoot(null);
            } else {
                if(node_current == node_father.getLst())
                    node_father.setLst(null);
                else
                    node_father.setRst(null);
            }

        //Remoção de nó com apenas 1 filho
        } else if (node_current.getLst() == null || node_current.getRst() == null) {

            if (node_current == this.root){
                if(node_current.getLst() != null)
                    this.setRoot(node_current.getLst());
                else 
                    this.setRoot(node_current.getRst());
            } else {
                if(node_current == node_father.getLst()){
                    if(node_current.getLst() != null)
                        node_father.setLst(node_current.getRst());
                    else
                        node_father.setLst(node_current.getLst());
                } else {
                    if(node_current.getRst() != null)
                        node_father.setRst(node_current.getRst());
                    else
                        node_father.setRst(node_current.getLst());
                }
            }			
        // Remoção de nó com 2 filhos
        } else {
            Node node_subs_father = node_current; // Pai do nó substituto
            Node node_subs = node_current.getRst(); // Nó que vai substituir o nó removido
            ArrayList<Node> local_list = new ArrayList<>(); // Lista local para atualizar altura da SAD do nó a ser removido

            // Busca do nó substituto
            while(node_subs.getLst() != null){
                node_subs_father = node_subs;
                local_list.add(node_subs_father);
                node_subs = node_subs.getLst();
            }
            list.add(node_subs);

            if(node_current == this.root){
                this.setRoot(node_subs);	
            } else {
                if (node_father.getLst() == node_current)
                    node_father.setLst(node_subs);
                else
                    node_father.setRst(node_subs);
            }

            node_subs.setLst(node_current.getLst());
            if(node_current.getRst() != node_subs)
                node_subs.setRst(node_current.getRst());
            node_subs_father.setLst(null);

            // Atualiza a altura dos nós da SAD do nó a ser removido
            while (!local_list.isEmpty()) {
                this.updateHeight(local_list.get(local_list.size() - 1)); 
                local_list.remove(local_list.size() - 1);
            }				

        }

        // Atualiza a altura dos nós Node caminho até o nó que foi removido
        while (!list.isEmpty()) {
            this.updateHeight(list.get(list.size() - 1)); 
            list.remove(list.size() - 1);
        }

        node_current = null;
        return true;
    }
    /**
     * Atualiza a altura de um determinado nó.
     * @param n Nó cuja altura deverá ser atualizada.
     */
    private void updateHeight(Node n) {
        int hR, hL;

        hL = (n.getLst() == null) ? 0 : n.getLst().getHeight();
        hR = (n.getRst() == null) ? 0 : n.getRst().getHeight();

        if (hL < hR)
            n.setHeight(hR + 1);
        else
            n.setHeight(hL + 1);
    }

    /**
     * Percorre a árvore utilizando notação Pré-Fixa. Enquanto passa pelos nós,
     * eles são exibidos na saída do terminal. Método recursivo.
     */
    public void preOrderTraversal() {
        if (this.root != null)
            this.preOrderTraversal(this.root);
        else
            System.out.println("Vazia");
    }

    /**
     * Método auxiliar da recursão do método de percorrer a árvore de forma Pré-Fixa. 
     * @param n Nó base para a recursão.
     */
    private void preOrderTraversal(Node n) {
        System.out.println(n.getKey().getId());
        if (n.getLst() != null)
            this.preOrderTraversal(n.getLst());
        if (n.getRst() != null)
            this.preOrderTraversal(n.getRst());
    }

    /**
     * Percorre uma árvore utilizando notação Pós-Fixa. Enquanto passa pelo nós,
     * eles são exibidos na saída do terminal. Método recursivo.
     */
    public void postOrderTraversal() {
        if (this.root != null)
            this.postOrderTraversal(this.root);
        else
            System.out.println("Vazia");
    }

    /**
     * Método auxiliar da recursão do método de percorrer a árvore de forma Pos-Fixa.
     * @param n Nó base da recursão.
     */
    private void postOrderTraversal(Node n) {
        if (n.getLst() != null)
            this.postOrderTraversal(n.getLst());
        if (n.getRst() != null)
            this.postOrderTraversal(n.getRst());
        System.out.println(n.getKey().getId());
    }

    /**
     * Percorre a árvore utilizando notação In-Fixa.
     */
    public void inOrderTraversal() {
        if (this.root != null)
            this.inOrderTraversal(this.root);
        else
            System.out.println("Vazia");
    }

    /**
     * Método auxiliar para recursão do método de percorrer a órvore de forma In-Fixa.
     * @param n Nó base da recursão.
     */
    private void inOrderTraversal(Node n) {
        if (n.getLst() != null)
            this.inOrderTraversal(n.getLst());
        System.out.println(n.getKey().getId());
        if (n.getRst() != null)
            this.inOrderTraversal(n.getRst());
    }

    /**
     * Busca da árvore em largura. Esse método consiste em realizar a busca a partir da raiz
     * sempre visitando os nós vizinhos de cada nó por onde a busca passa.
     * @param id Id.
     * @return Nó do usuário que foi procurado. null se o usuário não estiver na árvore.
     */
    public Node searchBreadth(long id) {
        if (this.root == null)
            return null;

        ArrayList<Node> list = new ArrayList<>();
        list.add(this.root);

        while (!list.isEmpty()) {
            if (id == list.get(0).getKey().getId())
                return list.get(0);
            if (list.get(0).getLst() != null)
                list.add(list.get(0).getLst());
            if (list.get(0).getRst() != null)
                list.add(list.get(0).getRst());
            list.remove(0);
        }

        return null;
    }

    /**
     * Busca binaria da Arvore Binaria de Busca padrão.
     * @param id
     * @return Nó do usuário que foi buscado. null se o usuário não estiver na árvore.
     */
    public Node searchDepth(long id) {
        return this.searchDepth(this.root, id);
    }

    private Node searchDepth(Node n, long id) {
        if (n != null) {
            if (id == n.getKey().getId()) {
                return n;
            } else if (id > n.getKey().getId()) {
                if (n.getRst() != null)
                    return searchDepth(n.getRst(), id);
            } else {
                if (n.getLst() != null)
                    return searchDepth(n.getLst(), id);
            }
        }

        return null;
    }

    /**
     * Obtem a profundidade de um determinado nó na árvore.
     * @param n Nó do qual se deseja saber sua profundidade na árvore.
     * @return Profundidade do nó.
     */
    public int getDepth(Node n) {
        if (n == null || this.root == null)
            return 0;

        Node node_aux = this.root;
        int depth = 0;

        while (node_aux != null) {
            if (node_aux == n)
                return depth;
            else {
                depth++;
                if (n.getKey().getId() > node_aux.getKey().getId())
                    node_aux = node_aux.getRst();
                else
                    node_aux = node_aux.getLst();
            }
        }

        return -1;
    }

    /**
     * Obtem a altura de um determinado nó na árvore.
     * @param n Nó do qual se deseja saber a sua altura na árvore.
     * @return Altura do nó.
     */
    public int getHeight(Node n) {
        if (n == null)
            return 0;
        return n.getHeight();
    }

    /**
     * Obtem o menor nó da árvore. Neste caso, o usuário com nome lexicograficamente menor.
     * @return Menor nó da árvore.
     */
    public Node getLeast() {
        if (this.root == null)
            return null;

        Node n = this.root;

        while (n.getLst() != null)
            n = n.getLst();

        return n;
    }

    /**
     * Obtem o maior nó da árvore. Neste caso, o usuário com nome lexicograficamente maior.
     * @return Maior nó da árvore.
     */
    public Node getGreatest() {
        if (this.root == null)
            return null;

        Node n = this.root;

        while (n.getRst() != null)
            n = n.getRst();

        return n;
    }

    /**
     * Obtem a raíz da árvore.
     * @return Raíz da árvore.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Determina a raíz da árvore.
     * @param root Novo nó raiz.
     */
    public void setRoot(Node root) {
        this.root = root;
    }
    
    public User validateUser(String name, String pwd){

        ArrayList<Node> list = new ArrayList<>();
        list.add(this.root);

        while (!list.isEmpty()) {
            if (name.compareToIgnoreCase(list.get(0).getKey().getUserName()) == 0 &&
                    pwd.compareTo(list.get(0).getKey().getPwd()) == 0){
                return list.get(0).getKey();
            }
            if (list.get(0).getLst() != null)
                list.add(list.get(0).getLst());
            if (list.get(0).getRst() != null)
                list.add(list.get(0).getRst());
            list.remove(0);
        }

        return null;
    }
    
    public User searchByName(String name){
        if (this.root == null)
            return null;

        ArrayList<Node> list = new ArrayList<>();
        list.add(this.root);

        while (!list.isEmpty()) {
            if (name.equals(list.get(0).getKey().getUserName()))
                return list.get(0).getKey();
            if (list.get(0).getLst() != null)
                list.add(list.get(0).getLst());
            if (list.get(0).getRst() != null)
                list.add(list.get(0).getRst());
            list.remove(0);
        }

        return null;
    }
}
