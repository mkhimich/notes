package DAO;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mkhimich on 8/2/16.
 */
public abstract class JpaDao<E> implements GeneralDao<E> {

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    public void persist(E entity) {
        entityManager.persist(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    public E findById(Long id) {
        return entityManager.find(entityClass, id);
    }
}
