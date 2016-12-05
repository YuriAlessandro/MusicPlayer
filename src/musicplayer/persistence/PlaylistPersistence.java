/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.persistence;

import DAO.MusicDAO;
import DAO.PlaylistDAO;
import banco.BancoMusic;
import banco.BancoPlaylist;
import banco.BancoUser;
import banco.TreeForSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import musicplayer.Music;
import musicplayer.Playlist;
import musicplayer.User;
import musicplayer.UserVIP;

/**
 * Arquivo que garante a persitência das playlists
 * @author Yuri Alessandro Martins
 * @author Thiago
 */
public class PlaylistPersistence {
    
    private final static PlaylistDAO playlistDAO = new PlaylistDAO();
    private final static MusicDAO musicDAO = new MusicDAO();
    
    /**
     * Salva todas as playlists no arquivo, se necessário
     * @throws IOException Erro na leitura/escrita de arquivo
     */
    public static void savePlaylists() throws IOException{
        // Para cada Playlist no banco de playlists
        for(Playlist p: BancoPlaylist.PLAYLISTS){
            // Se a playlist já não foi salva.
            if(!p.isSaved()){
                // Nome do arquivo
                String name = "playlist_" + p.getName();
                // Diretório
                String path = "src/musicplayer/persistence/persistenceDocs/" + name;
                // Tenta abrir o arquivo para escrita
                try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
                    buffWrite.write(p.getOwner().getUserName() + "\n" + p.getName() + "\n");
                    // Para cada música dessa playlist, salvar os dados da música
                    for(Music m : p.getMusics()){
                        buffWrite.write(m.getName() + "~~~" + m.getPath() + "\n");
                    }
                }
            }
        }
    }
    
    /**
     * Lê os arquivos de todas as playlists
     * @throws FileNotFoundException Arquivo não encontrado
     * @throws IOException Erro na leitura/escrita de arquivos
     */
    public static void readPlaylists() throws FileNotFoundException, IOException{
        // Recebe o diretório onde estão os arquivos de playlist
        File dir = new File("src/musicplayer/persistence/persistenceDocs/");
        // Todo arquivo encontrado que começar com 'playlist_' deverá ser lido
        File[] foundFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String string) {
                return string.startsWith("playlist_");
            }
        });
        // Para todos os arquivos encontrados
        for(File file : foundFiles){
            // Tentar abrir o arquivo para leitura
            try (BufferedReader buffRead = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                String line;
                
                // Lendo a primeira linha: criador da playlist
                line = buffRead.readLine();
                String data[] = line.split("~~~");
                User u;
                u = BancoUser.USERS.searchByName(data[0]);
                
                UserVIP owner = (UserVIP) u;
                
                // Segunda linha: nome da playlist
                line = buffRead.readLine();
                data = line.split("~~~");
                Playlist p = new Playlist(data[0], owner, true);
                playlistDAO.insert(p);
                
                // Para as outras linhas:
                line = buffRead.readLine();
                String musicsData[] = line.split("~~~");                
                while(true){
                    // Lendo as informações das músicas das playlists:
                    Music m;
                    if(line == null) break;
                    else{
                        musicsData = line.split("~~~");
                        m = new Music(musicsData[0], musicsData[1], true, true);
                        musicDAO.insert(m);
//                        TreeForSearch.insert(m.getName());
                        p.addMusic(m);
                    }
                    line = buffRead.readLine();
                }
            }
        }
    }
}
