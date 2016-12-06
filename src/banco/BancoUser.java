package banco;

import BST.Tree;
import musicplayer.User;

/**
 * Classe que funciona como o banco de usuários da aplicação.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoUser {
    public static Tree USERS = new Tree();
    /**
     * Obter o banco de usuários.
     * @return Banco de usuários.
     */
    public static Tree getUsers(){
        return USERS;
    }
}
