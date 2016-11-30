/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import banco.BancoUser;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import musicplayer.persistence.UsersPersistence;

/**
 *
 * @author yurialessandro
 */
public abstract class User {
    private String userName;
    private String pwd;
    private long id;
    private boolean isSave;

    public User(String userName, String pwd, boolean isSave) throws IOException{
        this.userName = userName;
        this.pwd = pwd;
        this.isSave = isSave;
        this.generateId();
        this.addOnDataBase();
        if(!isSave) this.addOnPersistence();
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
    
    private void writeUserInFile(FileWriter file){
        PrintWriter printUsers = new PrintWriter(file);
        
        printUsers.printf(this.getUserName() + " " + this.getPwd());
        
        if(this instanceof UserVIP){
            printUsers.printf(" true%n");
        }else printUsers.printf(" false%n");
            
    }
    
    private void addOnDataBase(){
        BancoUser.addUser(this);
    }

    private void addOnPersistence() throws IOException {
        UsersPersistence.saveUser(this);
    }
}
