package SuffixTree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa uma árvore de sufixos. A árvore possui como atributo um nó, 
 * que armazena a raiz da árvore. Além disso, há dois hash maps que são utilizados para 
 * armazenar o alfabeto da árvore, sendo um deles para mapear cada caractere possível do 
 * alfabeto para um número inteiro (índice), e o outro para fazer o mesmo mapeamento de forma inversa.
 * Há ainda um ArrayList utilizado para armazenar os resultado da última busca realizada.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de 
 * @see Node
 * @version 20161203
 *
 */
public class SuffixTree {

    private static HashMap<Character, Integer> alphabet = new HashMap<>();
    private static HashMap<Integer, Character> alphabet_inverse = new HashMap<>();
    private ArrayList<String> search_results = new ArrayList<>();

    private Node root;
    
    /**
     * Construtor da árvore. Um novo nó é instanciado para servir de raiz da árvore 
     * e os caracteres do alfabeto são adicionado aos hash maps.
     * @see setAlphabet()
     */
    public SuffixTree(){
        this.root = new Node();
        this.setAlphabet();
    }
    /**
     * Retorna a raiz da árvore.
     * @return Raiz da árvore
     */
    public Node getRoot(){
        return this.root;
    }
    /**
     * Método publico para inserção de uma palavra na árvore de sufixos. Esse método 
     * chama o método insert privado, que utiliza recursão para realizar a inserção.
     * @param word Palavra a ser inserida na árvore.
     */
    public void insert(String word){
        this.insert(word, this.root, 0);
    }
    /**
     * Método privado para inserção de uma palavra na árvore de sufixos utilizando recursão.
     * @param word Palavra a ser inserida.
     * @param node Nó da árvore que representa o caractere da palavra que está sendo considerado.
     * @param index Índice, ou seja, caractere da palavra que está sendo considerado.
     */
    private void insert(String word, Node node, int index){
        if(index == word.length()){
            node.setNodeWordTrue();
        } else {
            if (node.next[alphabet.get(word.charAt(index))] == null){
                node.next[alphabet.get(word.charAt(index))] = new Node();
            }
            this.insert(word, node.next[alphabet.get(word.charAt(index))], index+1);
        }
    }
    /**
     * Metódo de busca para encontrar palavras que começam com determinada sequência 
     * de caracteres. Em caso de sucesso, a busca retorna um ArrayList contendo os 
     * resultados da busca.
     * @param word Palavra que representa o sufixo que se deseja procurar.
     * @return Um ArrayList contendo o resultado da busca.
     */
    public ArrayList<String> search(String word){
        this.search_results.clear();
        int index = 0;
        Node node = this.root;
        
        // Palavra "vazia"
        if (word.equals("")) 
            return null;
        // Caso o nó que representa a primeira letra da palavra seja nulo 
        // (não há elementos da árvore contendo a palavra como sufixo)
        if (node.next[alphabet.get(word.charAt(index))] == null)
            return null;
        
        while(index < word.length() && node.next[alphabet.get(word.charAt(index))] != null) {
            node = node.next[alphabet.get(word.charAt(index++))];
        }
        
        // Caso não haja nenhum elemento na árvore tendo a palavra como sufixo 
        if (index < word.length() && node.next[alphabet.get(word.charAt(index))] == null){
            System.out.println("ENTROU");
            return null;
        }
            
        
        
        // Nesse momento, node contém o último caractere da árvore que corresponde com uma substring da palavra
        /* Exemplos:
        
            Árvore tem: ABCD
        
            Palavra procurada: ABCD
            Node: D
            Index: 4
        
            Palavra procurada: ABC
            Node: C
            Index: 3
        
            Palavra procurada: ABCDEF
            Node: D
            Index: 4
         */
        
        if(index < word.length() )
            word = word.substring(0, index);
        
        
        // Chamada do método privado que coloca os resultados da busca eno ArrayList search_results
        this.printSearch(node, word);
        return this.search_results;
    }
    /**
     * Método que coloca no ArrayList search_results os resultado da busca, ou seja,
     * todas as palavras na árvore que começam com determinado sufixo. Funciona de maneira recursiva.
     * @param node Nó que representa algum caractere de uma palavra que possui o sufixo procurado na busca.
     * @param word Palavra a ser impressa caso o nó represente o fim de uma palavra na árvore.
     */
    private void printSearch(Node node, String word){
        // Se o nó indica o final de uma palavra, a palavra é impressa.
        if(node.isWord()){
            search_results.add(word);
        }
        
        for (int i = 0; i < 69; i++){
            if(node.next[i] != null)
                this.printSearch(node.next[i], word + alphabet_inverse.get(i));
        }
    }
    /**
     * Método que adiciona os elementos do alfabeto aos hash maps, tanto para o 
     * de mapeamento direto (caractere para índice) quanto para o de mapeamento inverso
     * (índice para caractere).
     */
    private void setAlphabet(){
        // Alfabeto - total 69
        //    ABCDEFGHIJKLMNOPQRSTUVWXYZ
        //    abcdefghijklmnopqrstuvwxyz
        //    0 1 2 3 4 5 6 7 8 9
        //    space - . _ ( ) " 

        char char_index = 65;
        for(int i = 0; i < 62; i++){ // Upper case letters, lower case letter and numbers
            if (char_index == 91) char_index = 97;
            if (char_index == 123) char_index = 48;
            alphabet.put(char_index, i);
            alphabet_inverse.put(i, char_index++);
        }
        alphabet.put(' ', 62);
        alphabet.put('-', 63);
        alphabet.put('_', 64);
        alphabet.put('.', 65);
        alphabet.put('(', 66);
        alphabet.put(')', 67);
        alphabet.put('"', 68);
        
        alphabet_inverse.put(62, ' ');
        alphabet_inverse.put(63, '-');
        alphabet_inverse.put(64, '_');
        alphabet_inverse.put(65, '.');
        alphabet_inverse.put(66, '(');
        alphabet_inverse.put(67, ')');
        alphabet_inverse.put(68, '"');
    }
    
}
