package banco;

import java.util.ArrayList;
import musicplayer.Playlist;

/**
 * Classe que funciona como o banco de playlists da aplicação.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoPlaylist{
    public static ArrayList<Playlist> PLAYLISTS = new ArrayList<Playlist>();
    /**
     * Obter o banco de playlists.
     * @return Banco de playlists.
     */
    public static ArrayList<Playlist> getPlaylists(){
        return PLAYLISTS;
    }
}
