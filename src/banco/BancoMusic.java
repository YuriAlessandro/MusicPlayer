/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Collection;
import musicplayer.Music;

/**
 *
 * @author yurialessandro
 */
public class BancoMusic /*implements GenericDAO*/{
    public static ArrayList<Music> MUSICS = new ArrayList<Music>();
    
    public static void addMusic(Music m){
        MUSICS.add(m);
    }
    
    public static void remMusic(Music m){
        MUSICS.remove(m);
    }
    
    public static ArrayList<Music> getMusics(){
        return MUSICS;
    }

//    @Override
//    public void insert(Object o) {
//        Music m = (Music) o;
//        MUSICS.add(m);
//    }
//
//    @Override
//    public void remove(Object o) {
//        Music m = (Music) o;
//        MUSICS.remove(m);
//    }
//
//    @Override
//    public Collection getDAO(Object o) {
//        return MUSICS;
//    }

}
