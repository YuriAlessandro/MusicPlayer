/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import BST.Tree;
import musicplayer.User;

/**
 *
 * @author yurialessandro
 */
public class BancoUser {
    public static Tree USERS = new Tree();
    
    public static void addUser(User p){
        USERS.insert(p);
    }
    
    public static void remUser(User p){
        USERS.remove(p);
    }
    
    public static Tree getUsers(){
        return USERS;
    }
}
