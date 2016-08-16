package DAO;

import java.util.List;

/**
 * Created by mkhimich on 8/2/16.
 */
public interface DaoInterface<E extends IModel> {
    E persist(E entity);
    void remove(E entity);
    E findById(Long id);
    E update(E entity);
    List<E> findAll();
}
