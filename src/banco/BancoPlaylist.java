package banco;

import java.util.ArrayList;
import musicplayer.Playlist;

/**
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoPlaylist /*implements GenericDAO*/ {
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
