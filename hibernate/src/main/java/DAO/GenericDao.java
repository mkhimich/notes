package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mkhimich on 8/2/16.
 */
@Transactional
@Component
public abstract class GenericDao<E> implements DaoInterface<E> {

    protected Class<E> entityClass;

    @PersistenceContext()
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
    @Transactional
    public E persist(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    public E update(E entity) {
        return entityManager.merge(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long id){
        entityManager.remove(findById(id));
    }

    public E findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<E> findAll(){
        return entityManager.createQuery("select t from " + entityClass.getAnnotation(Entity.class).name() + " t").getResultList();
    }
}
