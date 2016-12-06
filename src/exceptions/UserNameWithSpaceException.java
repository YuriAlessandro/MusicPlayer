package exceptions;

/**
 * Classe que implementa a exceção de quando um usuário tenta ser adicionado com o nome
 * contendo espaços.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public class UserNameWithSpaceException extends Exception{
    /**
     * Construtor da classe.
     * @param msg Message descrevendo a exceção.
     */
    public UserNameWithSpaceException(String msg){
        super(msg);
    }
    
}
