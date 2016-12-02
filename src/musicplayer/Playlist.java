/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import banco.BancoPlaylist;
import java.util.ArrayList;

/**
 *
 * @author elton
 */
public class Playlist {

    private ArrayList<Music> musics;
    private String name;
    private User owner;

    public Playlist(String name, User u) {
        this.musics = new ArrayList<>();
        this.name = name;
        this.owner = u;
        this.addOnBanco();
    }

    public void addMusic(Music m) {
        musics.add(m);
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    private void addOnBanco(){
        BancoPlaylist.addMusic(this);
    }
    
}
