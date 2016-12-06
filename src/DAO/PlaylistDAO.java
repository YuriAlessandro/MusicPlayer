package DAO;

import banco.BancoPlaylist;
import musicplayer.Playlist;

/**
 * Classe que implementa a interface GenericDAO para acesso ao banco de playlists.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class PlaylistDAO implements GenericDAO{
    /**
     * Insere uma playlist no banco de playlists.
     * @param o Playlist a ser inserida.
     */
    @Override
    public void insert(Object o) {
        Playlist p = (Playlist) o;
        BancoPlaylist.getPlaylists().add(p);
    }
    /**
     * Remove uma playlist do banco de playlists.
     * @param o Playlist a ser removida.
     */
    @Override
    public void remove(Object o) {
        Playlist p = (Playlist) o;
        BancoPlaylist.getPlaylists().remove(p);
    }
    
}
