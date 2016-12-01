/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

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
    }

    public void addMusic(Music m) {
        musics.add(m);
    }
}
