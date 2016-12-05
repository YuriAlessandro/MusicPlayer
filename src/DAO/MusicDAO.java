/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.BancoMusic;
import musicplayer.Music;

/**
 *
 * @author thiag
 */
public class MusicDAO implements GenericDAO{

    @Override
    public void insert(Object o) {
        Music m = (Music) o;
        BancoMusic.getMusics().add(m);
    }

    @Override
    public void remove(Object o) {
        Music m = (Music) o;
        BancoMusic.getMusics().remove(m);
    }
    
}
