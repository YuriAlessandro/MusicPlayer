/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.BancoPlaylist;
import musicplayer.Playlist;

/**
 *
 * @author thiag
 */
public class PlaylistDAO implements GenericDAO{

    @Override
    public void insert(Object o) {
        Playlist p = (Playlist) o;
        BancoPlaylist.getPlaylists().add(p);
    }

    @Override
    public void remove(Object o) {
        Playlist p = (Playlist) o;
        BancoPlaylist.getPlaylists().remove(p);
    }
    
}
