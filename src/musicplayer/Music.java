/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import banco.BancoMusic;

/**
 *
 * @author yurialessandro
 */
public class Music {
    private String name;
    private String path;
    private boolean isSaved;

    public Music() {
        BancoMusic.addMusic(this);
    }

    public Music(String name, String path, boolean isSaved) {
        this.name = name;
        this.path = path;
        this.isSaved = isSaved;
      
        BancoMusic.addMusic(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
    
    
    
}
