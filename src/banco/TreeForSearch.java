package banco;

import SuffixTree.SuffixTree;
import java.util.ArrayList;

/**
 * Classe que utiliza a árvore de sufixos para armazenar as músicas a 
 * serem buscadas.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class TreeForSearch {
    private static final SuffixTree TREE = SuffixTree.getInstance();
    /**
     * Insere uma palavra na ávore de sufixos. No caso, o nome de uma música.
     * @param s Nome da música a ser inserida.
     */
    public static void insert(String s){
        TREE.insert(s);
    }
    /**
     * Busca as músicas na árvore que possuem determinada palavra como sufixo.
     * @param s Palavra representando o sufixo que se deseja procurar.
     * @return ArrayList preenchida com as músicas resultantes da busca.
     */
    public static ArrayList<String> search(String s){
        return TREE.search(s);
    }
}
