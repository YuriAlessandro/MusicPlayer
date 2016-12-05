package musicplayer;

import java.io.IOException;

/**
 * Classe que define um usuário sem privilégios
 * @author Yuri Alessandro Martins
 * @author Thiago
 */
public class UserCommom extends User{
    
    /**
     * Construtor da classe
     * @param userName Nome do usuário comum
     * @param pwd Senha do usuário
     * @param isSave True, se está salvo na persistência
     * @throws IOException Erro na leitura/escrita de arquivos
     */
    public UserCommom(String userName, String pwd, boolean isSave) throws IOException {
        super(userName, pwd, isSave);
    }

}
