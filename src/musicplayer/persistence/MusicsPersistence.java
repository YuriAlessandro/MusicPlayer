/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.persistence;

import banco.BancoMusic;
import banco.TreeForSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import musicplayer.Music;
import musicplayer.User;

/**
 *
 * @author yurialessandro
 */
public class MusicsPersistence {
    private static final String PATH = "src/musicplayer/persistence/persistenceDocs/musics.txt";
    
    public static void saveMusics(User u) throws IOException{
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(MusicsPersistence.PATH, true))) {
            
            for(Music m : BancoMusic.MUSICS){
                if(!m.isIsSaved()){
                    buffWrite.append(u.getUserName() + "~~" + m.getName() + "~~" + m.getPath());
                    buffWrite.append("\n");
                }
            }
        }
    }
    
    public static void readMusics(User u) throws FileNotFoundException, IOException{
        try (BufferedReader buffRead = new BufferedReader(new FileReader(MusicsPersistence.PATH))) {
            String line = buffRead.readLine();
            String data[];
            
            while(true){
                Music m;
                if(line == null) break;
                else{
                    data = line.trim().split("~~");
                    
                    if(data[0].equals(u.getUserName())){
                        m = new Music(data[1], data[2], true, false);
                        TreeForSearch.insert(m.getName());
                    }
                }
                
                line = buffRead.readLine();
            }
        }
    }
}
