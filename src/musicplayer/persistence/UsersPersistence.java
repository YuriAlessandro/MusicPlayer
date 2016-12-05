/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.persistence;

import banco.BancoUser;
import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import musicplayer.User;
import musicplayer.UserCommom;
import musicplayer.UserVIP;

/**
 *
 * @author yurialessandro
 */
public class UsersPersistence {
    private static final String PATH = "src/musicplayer/persistence/persistenceDocs/users.txt"; 
    
    public static void saveUser(User u) throws IOException{
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(UsersPersistence.PATH, true))) {
            buffWrite.append(u.getUserName() + " " + u.getPwd());
            
            if(u instanceof UserVIP) buffWrite.append(" true");
            else buffWrite.append(" false");
            
            buffWrite.append("\n");
        }
    }
    
    public static void readUsers() throws FileNotFoundException, IOException{
        try (BufferedReader buffRead = new BufferedReader(new FileReader(UsersPersistence.PATH))) {
            String line = buffRead.readLine();
            String data[];
            while(true){
                User u;
                if(line == null) break;
                else{
                    data = line.trim().split("\\s+");
                    
                    if(data[2].equals("true")){
                        u = new UserVIP(data[0], data[1], true);
//                        BancoUser.addUser(u);
                    }else{
                        u = new UserCommom(data[0], data[1], true);
//                        BancoUser.addUser(u);
                    }
                }
                
                line = buffRead.readLine();
            }
        }
    }

}
