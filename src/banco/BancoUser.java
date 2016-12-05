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
    
    public static Tree getUsers(){
        return USERS;
    }
}
