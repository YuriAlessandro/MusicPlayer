package banco;

import SuffixTree.SuffixTree;
import java.util.ArrayList;

/**
 *
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class TreeForSearch {
    private static final SuffixTree TREE = new SuffixTree();
    
    public static void insert(String s){
        TREE.insert(s);
    }
    
    public static ArrayList<String> search(String s){
        return TREE.search(s);
    }
}
