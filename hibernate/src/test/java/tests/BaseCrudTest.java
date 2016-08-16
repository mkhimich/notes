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
