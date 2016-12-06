package DAO;


/**
 * Interface para acesso aos bancos de dados do sistema.
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public interface GenericDAO {
    /**
     * Insere um objeto no banco de dados.
     * @param o Objeto a ser inserido
     */
    public void insert(Object o);
    /**
     * Remove um objeto do banco de dados.
     * @param o Objeto a ser removido.
     */
    public void remove(Object o);
}
