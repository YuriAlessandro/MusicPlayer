/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.persistence;

import banco.BancoPlaylist;
import banco.BancoUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import musicplayer.Music;
import musicplayer.Playlist;
import musicplayer.User;
import musicplayer.UserVIP;

/**
 *
 * @author yurialessandro
 */
public class PlaylistPersistence {
//    private static String PATH = "src/musicplayer/persistence/persistenceDocs/";
    
    public static void savePlaylists() throws IOException{
        for(Playlist p: BancoPlaylist.PLAYLISTS){
            if(!p.isSaved()){
                String name = "playlist_" + p.getName();
                String path = "src/musicplayer/persistence/persistenceDocs/" + name;
                try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
                    buffWrite.write(p.getOwner().getUserName() + "\n" + p.getName() + "\n");
                    for(Music m : p.getMusics()){
                        buffWrite.write(m.getName() + "~~~" + m.getPath() + "\n");
                    }
                }
            }
        }
    }
    
    public static void readPlaylists() throws FileNotFoundException, IOException{
        File dir = new File("src/musicplayer/persistence/persistenceDocs/");
        File[] foundFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String string) {
                return string.startsWith("playlist_");
            }
        });
        
        for(File file : foundFiles){
            try (BufferedReader buffRead = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                String line;
                
                // First line: Playlist owner:
                line = buffRead.readLine();
                String data[] = line.split("~~~");
                User u;
//                System.err.println("LINE 1:" + data[0]);
                u = BancoUser.USERS.searchByName(data[0]);
                
                UserVIP owner = (UserVIP) u;
                
                // Second line: Playlist name:
                line = buffRead.readLine();
                data = line.split("~~~");
//                System.err.println("LINE 2:" + data[0]);
                Playlist p = new Playlist(data[0], owner, true);
                
                // Others lines:
                line = buffRead.readLine();
                String musicsData[] = line.split("~~~");                
                while(true){
                    // Others lines: Musics informations:
                    Music m;
                    if(line == null) break;
                    else{
                        musicsData = line.split("~~~");
//                        System.err.println("adicionei uma música...");
//                        System.err.println(musicsData[0] + "-" + musicsData[1]);
                        m = new Music(musicsData[0], musicsData[1], true, true);
                        p.addMusic(m);
                    }
                    line = buffRead.readLine();
                }
            }
        }
    }
}
