package banco;

import java.util.Collection;

/**
 *
 * @author Yuri Alessandro Martins
 * @author Thiago César M. D. de Lucena
 */
public interface GenericDAO {
    public void insert(Object o);
    public void remove(Object o);
    public Collection getDAO(Object o);
}
