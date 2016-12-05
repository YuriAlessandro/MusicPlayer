package musicplayer;

/**
 * Classe que define uma música.
 * 
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class Music {
    private String name;
    private String path;
    private boolean saved;
    private boolean fromPlaylist;
    
    /**
     * Construtor da classe música.
     * 
     */
    public Music() {
    }
    
    /**
     * Construtor da classe música.
     * @param name Nome da música.
     * @param path Diretório da música.
     * @param isSaved True, se música já salva na persistência.
     * @param fromPlaylist True, se música é de uma playlist.
     */
    public Music(String name, String path, boolean isSaved, boolean fromPlaylist) {
        this.name = name;
        this.path = path;
        this.saved = isSaved;
        this.fromPlaylist = fromPlaylist;
    }
    
    /**
     * Obter nome da música
     * @return Nome da música
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
    public String getPath() {
        return path;
    }
    
    /**
     * 
     * @param path 
     */
    public void setPath(String path) {
        this.path = path;
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
     * @param isSaved 
     */
    public void setIsSaved(boolean isSaved) {
        this.saved = isSaved;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isFromPlaylist() {
        return fromPlaylist;
    }
    
    
}
