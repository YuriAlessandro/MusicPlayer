package banco;

import BST.Tree;
import musicplayer.User;

/**
 *
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoUser /*implements GenericDAO*/ {
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
