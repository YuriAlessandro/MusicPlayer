package banco;

import java.util.ArrayList;
import musicplayer.Music;

/**
 * Classe que funciona como o banco de músicas da aplicação.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoMusic {
    public static ArrayList<Music> MUSICS = new ArrayList<Music>();
    /**
     * Obter o banco de músicas.
     * @return Banco de músicas.
     */
    public static ArrayList<Music> getMusics(){
        return MUSICS;
    }
}
