package DAO;

import banco.BancoMusic;
import musicplayer.Music;

/**
 * Classe que implementa a interface GenericDAO para acesso ao banco de músicas.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class MusicDAO implements GenericDAO{
    /**
     * Insere uma música no banco de músicas.
     * @param o Música a ser inserida.
     */
    @Override
    public void insert(Object o) {
        Music m = (Music) o;
        BancoMusic.getMusics().add(m);
    }
    /**
     * Remove uma música do banco de músicas.
     * @param o Música a ser removida.
     */
    @Override
    public void remove(Object o) {
        Music m = (Music) o;
        BancoMusic.getMusics().remove(m);
    }
    
}
