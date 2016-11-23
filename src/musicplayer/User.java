/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import banco.BancoUser;

/**
 *
 * @author yurialessandro
 */
public abstract class User {
    private String userName;
    private String pwd;

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
        BancoUser.addUser(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
}
