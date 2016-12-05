/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import SuffixTree.SuffixTree;
import java.util.ArrayList;

/**
 *
 * @author yurialessandro
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
