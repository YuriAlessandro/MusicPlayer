package DAO;

import banco.BancoUser;
import musicplayer.User;

/**
 * Classe que implementa a interface GenericDAO para acesso ao banco de usuários.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class UserDAO implements GenericDAO{
    /**
     * Insere um usuário no banco de usuários.
     * @param o Usuário a ser inserido.
     */
    @Override
    public void insert(Object o) {
        User u = (User) o;
        BancoUser.getUsers().insert(u);
    }
    /**
     * Remove um usuário do banco de usuários.
     * @param o Usuário a ser removido.
     */
    @Override
    public void remove(Object o) {
        User u = (User) o;
        BancoUser.getUsers().remove(u);
    }
    
}
