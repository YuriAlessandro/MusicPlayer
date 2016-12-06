package musicplayer;

import DAO.PlaylistDAO;
import java.util.ArrayList;

/**
 * Classe que determina uma playlist de músicas.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
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
     * Obter lista de músicas da playlist.
     * @return ArrayList contendo a lista de músicas da playlist.
     */
    public ArrayList<Music> getMusics() {
        return musics;
    }
    
    /**
     * Define a lista de músicas da playlist.
     * @param musics ArrayList com as novas músicas da playlist.
     */
    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }
    
    /**
     * Obter nome da playlist.
     * @return Nome da playlist.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Definir nome da playlist.
     * @param name Novo nome da playlist.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Obter dono da playlist.
     * @return Usuário dono da playlist.
     */
    public User getOwner() {
        return owner;
    }
    
    /**
     * Definir dono da playlist.
     * @param owner Usuário que será o novo dono da playlist.
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    /**
     * Obter estado da playlist (se ela foi salva na persistência).
     * @return True, se a playlist está na perssistência. False, caso contrário.
     */
    public boolean isSaved() {
        return saved;
    }
    
    /**
     * Definir se a playlist encontra-se na persistência.
     * @param saved Booleano que define se a música encontra-se na persistência.
     */
    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    
    
}
