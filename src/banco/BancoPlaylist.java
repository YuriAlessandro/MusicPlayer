/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import musicplayer.Playlist;

/**
 *
 * @author yurialessandro
 */
public class BancoPlaylist {
    public static ArrayList<Playlist> PLAYLISTS = new ArrayList<Playlist>();
    
    public static void addMusic(Playlist p){
        PLAYLISTS.add(p);
    }
    
    public static void remMusic(Playlist p){
        PLAYLISTS.remove(p);
    }
    
    public static ArrayList<Playlist> getMusics(){
        return PLAYLISTS;
    }
}
