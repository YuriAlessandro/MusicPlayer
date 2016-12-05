package SuffixTree;

/**
 * Classe que representa o nó de uma árvore de sufixos. O nó possui um atributo 
 * para indicar se ele representa o último caractere de uma palavra na árvore, e 
 * um array de nós, sendo um Nó para cada elemento do alfabeto definido na árvore.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 * @see SuffixTree
 * @version 20161203
 *
 */
public class Node {
    private boolean is_word; // Indica se o nó é o último caractere de uma palavra
    // Esse atributo é protected pois ele precisa ser acessado por SuffixTree
    protected Node[] next; // Array de nós
    
    /**
     * Construtor de um nó. Ele inicia o nó com o indicador de fim de palavra sendo falso 
     * e aloca os nós necessários para o array de nós, ou seja, 69 nós (1 para cada elemento do 
     * alfabeto da árvore).
     */
    public Node(){
        is_word = false;
        next = new Node[69];
    }
    /**
     * Altera o indicador de fim de palavra de um nó, definindo ele como verdadeiro
     */
    public void setNodeWordTrue(){
        this.is_word = true;
    }
    /**
     * Retorna o atributo do nó que indica fim de palavra.
     * @return valor booleano de is_word
     */
    public boolean isWord(){
        return this.is_word;
    }
}
