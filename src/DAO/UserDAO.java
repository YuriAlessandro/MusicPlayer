/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.BancoUser;
import musicplayer.User;

/**
 *
 * @author thiag
 */
public class UserDAO implements GenericDAO{

    @Override
    public void insert(Object o) {
        User u = (User) o;
        BancoUser.getUsers().insert(u);
    }

    @Override
    public void remove(Object o) {
        User u = (User) o;
        BancoUser.getUsers().remove(u);
    }
    
}
