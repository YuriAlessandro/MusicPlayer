/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer.persistence;

import exceptions.UserNameWithSpaceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import musicplayer.User;
import musicplayer.UserCommom;
import musicplayer.UserVIP;

/**
 * Classe que garante a persistência dos usuários
 * @author yurialessandro
 * @author Thiago
 */
public class UsersPersistence {
    private static final String PATH = "src/musicplayer/persistence/persistenceDocs/users.txt"; 
    
    /**
     * Salva usuários no arquivo
     * @param u Usuário que deve ser salvo
     * @throws IOException Erro na leitura/escrita de arquivo
     */
    public static void saveUser(User u) throws IOException{
        // Tenta abrir o arquivo para escrita
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(UsersPersistence.PATH, true))) {
            // Escreve o nome do usuário e depois a senha
            buffWrite.append(u.getUserName() + " " + u.getPwd());
            
            // Determina se o usuário é VIP
            if(u instanceof UserVIP) buffWrite.append(" true");
            else buffWrite.append(" false");
            
            // Quebra linha
            buffWrite.append("\n");
        }
    }
    
    /**
     * Lê usuários do arquivo.
     * @throws FileNotFoundException Arquivo não encontrado
     * @throws IOException Erro na leitura/escrita do arquivo
     */
    public static void readUsers() throws FileNotFoundException, IOException{
        // Tenta ler o arquivo para leitura
        try (BufferedReader buffRead = new BufferedReader(new FileReader(UsersPersistence.PATH))) {
            // Lẽ a primeira linha
            String line = buffRead.readLine();
            String data[];
            while(true){
                User u;
                if(line == null) break;
                else{
                    // Concatena a linha por espaço ("\\s+" == " ")
                    data = line.trim().split("\\s+");
                    
                    // Verifica se é um usuário VIP
                    if(data[2].equals("true")){
                        try {
                            u = new UserVIP(data[0], data[1], true);
//                        BancoUser.addUser(u);
                        } catch (UserNameWithSpaceException ex) {
                            Logger.getLogger(UsersPersistence.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        try {
                            u = new UserCommom(data[0], data[1], true);
//                        BancoUser.addUser(u);
                        } catch (UserNameWithSpaceException ex) {
                            Logger.getLogger(UsersPersistence.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                line = buffRead.readLine();
            }
        }
    }

}
