package musicplayer;

import exceptions.UserNameWithSpaceException;
import java.io.IOException;

/**
 * Classe que define um usuário sem privilégios
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class UserCommom extends User{
    
    /**
     * Construtor da classe
     * @param userName Nome do usuário comum
     * @param pwd Senha do usuário
     * @param isSave True, se está salvo na persistência
     * @throws IOException Erro na leitura/escrita de arquivos
     * @throws exceptions.UserNameWithSpaceException Erro de nome de usuário com espaços.
     */
    public UserCommom(String userName, String pwd, boolean isSave) throws IOException, UserNameWithSpaceException {
        super(userName, pwd, isSave);
    }

}
