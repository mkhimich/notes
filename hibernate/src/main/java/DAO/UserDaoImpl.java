package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

/**
 * Created by mkhimich on 8/16/16.
 */
@Service
@Component
@Repository("userDaoImpl")
public class UserDaoImpl extends GenericDao<User> implements UserDao {
    @Autowired
    private UserDao userDao;

    public User findByUserName(String nickname){
        System.out.println("select t from " + entityClass.getAnnotation(Entity.class).name() + " t WHERE nickname = " + nickname);
        User user = null;
        try {
            user = (User) entityManager.createQuery("select t from " + entityClass.getAnnotation(Entity.class).name() + " t WHERE t.nickname = :entered").setMaxResults(1).
                    setParameter("entered", nickname).getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
