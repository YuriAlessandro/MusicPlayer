package musicplayer.persistence;

import DAO.MusicDAO;
import banco.BancoMusic;
import banco.TreeForSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import musicplayer.Music;
import musicplayer.User;

/**
 * Classe responsável pela persistência de músicas
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class MusicsPersistence {
    private static final String PATH = "src/musicplayer/persistence/persistenceDocs/musics.txt";
    private static MusicDAO musicDAO = new MusicDAO();
    
    /**
     * Salva músicas em um arquivo
     * @param u Usuário que adicionou a música.
     * @throws IOException Erro na escrita do arquivo.
     */
    public static void saveMusics(User u) throws IOException{
        // Tenta abrir o arquivo para escrita.
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(MusicsPersistence.PATH, true))) {
            // Para as músicas do banco, salva os dados no arquivo.
            for(Music m : BancoMusic.MUSICS){
                // Apenas se as músicas não estiverem salvas.
                if(!m.isSaved()){
                    buffWrite.append(u.getUserName() + "~~" + m.getName() + "~~" + m.getPath());
                    buffWrite.append("\n");
                }
            }
        }
    }
    
    /**
     * Lê usuários de um arquivo e os adiciona no banco.
     * @param u Usuário que está conectado à aplicação
     * @throws FileNotFoundException Não encontrou o arquivo a ser lido
     * @throws IOException Falha na leitura/escrita de arquivo
     */
    public static void readMusics(User u) throws FileNotFoundException, IOException{
        // Tenta abrir o arquivo para leitura
        try (BufferedReader buffRead = new BufferedReader(new FileReader(MusicsPersistence.PATH))) {
            String line = buffRead.readLine();
            String data[];
            
            // Lê todas as músicas do arquivo, tratando suas informações
            while(true){
                Music m;
                if(line == null) break;
                else{
                    data = line.trim().split("~~");
                    
                    if(data[0].equals(u.getUserName())){
                        m = new Music(data[1], data[2], true, false);
                        musicDAO.insert(m);
                        TreeForSearch.insert(m.getName());
                    }
                }
                
                line = buffRead.readLine();
            }
        }
    }
}
