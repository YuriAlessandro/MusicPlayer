/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import musicplayer.User;

/**
 *
 * @author yurialessandro
 */
public class BancoUser {
    public static ArrayList<User> USERS = new ArrayList<User>();
    
    public static void addUser(User p){
        USERS.add(p);
    }
    
    public static void remUser(User p){
        USERS.remove(p);
    }
    
    public static ArrayList<User> getUsers(){
        return USERS;
    }
}
