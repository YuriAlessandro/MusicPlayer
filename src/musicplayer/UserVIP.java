package musicplayer;

import exceptions.UserNameWithSpaceException;
import java.io.IOException;


/**
 * Classe que define um usuário com privilégios;
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class UserVIP extends User{
    
    /**
     * Construtor da classe
     * @param userName Nome de usuário
     * @param pwd Senha
     * @param isSave Estado do usuário (se ele está na persistência).
     * @throws IOException Erro na leitura/escrita de arquivos.
     * @throws exceptions.UserNameWithSpaceException Erro de nome de usuário com espaços.
     */
    public UserVIP(String userName, String pwd, boolean isSave) throws IOException, UserNameWithSpaceException {
        super(userName, pwd, isSave);
    }

}
