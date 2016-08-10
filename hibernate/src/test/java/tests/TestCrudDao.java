package tests;

import DAO.Note;
import DAO.NoteDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mkhimich on 8/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class TestCrudDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    NoteDaoImpl getNoteImpl;

    @Inject
    ApplicationContext context = new ClassPathXmlApplicationContext("test-config.xml");

    private NoteDaoImpl noteImpl;

    @Before
    public void testSetup() {
        createDeleteDB();
    }

//    public static void main(String[] args) {
//        createDeleteDB();
//    }

    private void createDeleteDB() {
        Note note = new Note(1, "Note 1");
        getNoteImpl.persist(note);
        Note note2 = new Note(1, "Note 2");
        Note note3 = new Note(1, "Note 3");
        Note note4 = new Note(1, "Note 4");
        Note note5 = new Note(1, "Note 5");
        getNoteImpl.persist(note2);
        getNoteImpl.persist(note3);
        getNoteImpl.persist(note4);
        getNoteImpl.persist(note5);


    }

    @After
    public void testTearDown() {

    }

    @Test
    public void testTableSize() {
        assertEquals("Not all 5 notes saved ", getNoteImpl.findAll().size(), 5);
    }

    @Test
    public void testCreate(){
        Note note = new Note(1, "Note Created");
        getNoteImpl.persist(note);
        assertTrue("note is null", note.getId()> 0);
        Note found = getNoteImpl.findById(note.getId());
        assertEquals(note.getNoteName(), found.getNoteName());
        assertEquals(note.getUserId(), found.getUserId());
        System.out.println(note.getCreated());
        System.out.println(found.getCreated());
        assertEquals(note, found);
    }

}
