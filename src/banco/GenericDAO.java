/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Collection;

/**
 *
 * @author yurialessandro
 */
public interface GenericDAO {
    public void insert(Object o);
    public void remove(Object o);
    public Collection getDAO(Object o);
}
