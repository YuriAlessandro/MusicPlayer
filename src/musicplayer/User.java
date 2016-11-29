/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import banco.BancoUser;
import java.util.UUID;

/**
 *
 * @author yurialessandro
 */
public abstract class User {
    private String userName;
    private String pwd;
    private long id;

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
        this.generateId();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    private void generateId(){
        UUID uid = UUID.randomUUID();
        this.id = Math.abs(uid.getLeastSignificantBits());
    }
}
