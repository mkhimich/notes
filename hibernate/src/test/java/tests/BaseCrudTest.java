package tests;

import DAO.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by mkhimich on 8/16/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public abstract class BaseCrudTest<T extends IModel> {

//    @Before
//    public void generateData(){
//        Note note = new Note(1, "Note 1");
//        Note note2 = new Note(1, "Note 2");
//        Note note3 = new Note(1, "Note 3");
//        Note note4 = new Note(1, "Note 4");
//        Note note5 = new Note(1, "Note 5");
//        noteImpl.persist(note);
//        noteImpl.persist(note2);
//        noteImpl.persist(note3);
//        noteImpl.persist(note4);
//        noteImpl.persist(note5);
//        User user = new User("user1", "user1@gmail.com", "user1password");
//        User user2 = new User("user2", "user2@gmail.com", "user2password");
//        User user3 = new User("user3", "user3@gmail.com", "user3password");
//        User user4 = new User("user4", "user4@gmail.com", "user4password");
//        User user5 = new User("user5", "user5@gmail.com", "user5password");
//        userDaoImpl.persist(user);
//        userDaoImpl.persist(user2);
//        userDaoImpl.persist(user3);
//        userDaoImpl.persist(user4);
//        userDaoImpl.persist(user5);
//    }

    protected abstract DaoInterface<T> getDao();

    protected abstract T getNewPopulatedModel();

    protected abstract T getUpdatedModel(T t);

    @Test
    public void testCreateReadDelete() {
        T populatedModel = getNewPopulatedModel();
        DaoInterface<T> dao = getDao();
        dao.persist(populatedModel);
        long id = populatedModel.getId();
        assertTrue(id > 0);
        T foundModel = dao.findById(id);
        assertNotNull(foundModel);
        assertEquals(populatedModel, foundModel);
        dao.remove(foundModel);

    }

    @Test
    public void testList() {
        int count = 1000;
        DaoInterface<T> dao = getDao();
        List<T> originalList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            T model = getNewPopulatedModel();
            dao.persist(model);
            originalList.add(model);
        }
        List<T> foundList = dao.findAll();
        assertEquals(count, foundList.size());
        for (int i = 0; i < count; i++) {
            assertTrue(foundList.contains(originalList.get(i)));
        }

    }

    @Test
    public void testUpdate() {
        T populatedModel = getNewPopulatedModel();
        DaoInterface<T> dao = getDao();
        dao.persist(populatedModel);

        long id = populatedModel.getId();
        T updatedModel = getUpdatedModel(populatedModel);
        dao.update(updatedModel);

        T foundModel = dao.findById(id);
        assertEquals(updatedModel, foundModel);
    }


}
