package DAO;

import java.util.List;

/**
 * Created by mkhimich on 8/2/16.
 */
public interface GeneralDao<E> {
    void persist(E entity);
    void remove(E entity);
    E findById(Long id);
    List<E> findAll();
}
