package musicplayer;

import DAO.PlaylistDAO;
import banco.BancoPlaylist;
import java.util.ArrayList;

/**
 * Classe que determina uma playlist de músicas.
 * @author Yuri Alessandro Martins
 * @author Thiago
 */
public class Playlist {
    
    private ArrayList<Music> musics;
    private String name;
    private User owner;
    private boolean saved;
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    
    /**
     * Construtor da classe playlist
     * @param name Nome da playlist
     * @param u Dono da playlist
     * @param b True, se playlist já está salva na persistência.
     */
    public Playlist(String name, User u, boolean b) {
        this.musics = new ArrayList<>();
        this.name = name;
        this.owner = u;
        this.saved = b;
//        this.addOnBanco();
    }
    
    /**
     * Adiciona uma nova música à playlist
     * @param m Música para adicionar.
     */
    public void addMusic(Music m) {
        musics.add(m);
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Music> getMusics() {
        return musics;
    }
    
    /**
     * 
     * @param musics 
     */
    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }
    
    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return 
     */
    public User getOwner() {
        return owner;
    }
    
    /**
     * 
     * @param owner 
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isSaved() {
        return saved;
    }
    
    /**
     * 
     * @param saved 
     */
    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    
    
}
