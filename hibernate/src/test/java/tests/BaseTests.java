package tests;

import DAO.NoteDao;
import DAO.NoteDaoImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by mkhimich on 8/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hibernatetest.cfg.xml")
public class BaseTests {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Inject
    NoteDao noteDao;

    @Before
    public void testSetup() {

    }
    @After
    public void testTearDown() {

    }

    @Test
    public void generalTest() {
        Assert.assertEquals("1+1=2", (1 + 1), 2);

    }

}
