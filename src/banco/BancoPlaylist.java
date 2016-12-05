package banco;

import java.util.ArrayList;
import musicplayer.Playlist;

/**
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoPlaylist{
    public static ArrayList<Playlist> PLAYLISTS = new ArrayList<Playlist>();
    
    public static ArrayList<Playlist> getPlaylists(){
        return PLAYLISTS;
    }
}
