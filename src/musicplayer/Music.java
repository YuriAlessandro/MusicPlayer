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
     */
    public Music() {
    }
    
    /**
     * Construtor da classe música.
     * @param name Nome da música.
     * @param path Diretório da música.
     * @param isSaved True, se a música já está salva na persistência.
     * @param fromPlaylist True, se a música é de uma playlist.
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
     * Definir novo nome para a música
     * @param name Novo nome da música.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Obter o caminho da música.
     * @return Caminho da música.
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Deifinir novo caminho da música.
     * @param path Novo caminho da música.
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Obter estado da música (se ela está salva na persistência).
     * @return True, se a música já está salva na persistência. False, caso contrário.
     */
    public boolean isSaved() {
        return saved;
    }
    
    /**
     * Definir se a música já está salva na persistência.
     * @param isSaved Booleano indicando se a música já está salva na persistência.
     */
    public void setIsSaved(boolean isSaved) {
        this.saved = isSaved;
    }
    
    /**
     * Obter estado da música (se ela faz parte de alguma playlist).
     * @return True, se a música pertence a alguma playlist. False, caso contrário.
     */
    public boolean isFromPlaylist() {
        return fromPlaylist;
    }
    
    
}
