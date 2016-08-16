package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by mkhimich on 8/16/16.
 */
@Service
@Component
@Repository("userDaoImpl")
public class UserDaoImpl extends GenericDao<User> implements UserDao {
    @Autowired
    private UserDao userDao;

}
