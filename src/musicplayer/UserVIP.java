package musicplayer;

import exceptions.UserNameWithSpaceException;
import java.io.IOException;


/**
 * Classe que define um usuário com privilégios;
 * @author Yuri Alessandro Martins
 * @author Thiago
 */
public class UserVIP extends User{
    
    /**
     * Construtor da classe
     * @param userName
     * @param pwd
     * @param isSave
     * @throws IOException 
     * @throws exceptions.UserNameWithSpaceException 
     */
    public UserVIP(String userName, String pwd, boolean isSave) throws IOException, UserNameWithSpaceException {
        super(userName, pwd, isSave);
    }

}
