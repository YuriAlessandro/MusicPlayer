package banco;

import java.util.ArrayList;
//import java.util.Collection;
import musicplayer.Music;

/**
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class BancoMusic /*implements GenericDAO*/{
    public static ArrayList<Music> MUSICS = new ArrayList<Music>();
    
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
