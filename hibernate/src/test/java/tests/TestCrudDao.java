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

import static org.junit.Assert.*;

/**
 * Created by mkhimich on 8/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class TestCrudDao {

    @Inject
    NoteDaoImpl getNoteImpl;

    private NoteDaoImpl noteImpl;

    @Before
    public void testSetup() {
        createDeleteDB();
    }

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
    public void testCreateDeleteNote(){
        Note note = new Note(1, "Note Created");
        getNoteImpl.persist(note);
        assertTrue("note is null", note.getId()> 0);
        Note found = getNoteImpl.findById(note.getId());
        assertEquals(note.getNoteName(), found.getNoteName());
        assertEquals(note.getUserId(), found.getUserId());
        assertEquals(note, found);
        long id = found.getId();
        getNoteImpl.deleteById(id);
        assertNull(getNoteImpl.findById(id));
    }

    @Test
    public void testUpdateNote(){
        long defaultID = 4L;
        String updatedNote = "Updated Note";
        Note note = getNoteImpl.findById(defaultID);
        assertNotEquals(note.getNoteName(), updatedNote);
        note.setNoteName("Updated Note");
        getNoteImpl.update(note);
        Note found = getNoteImpl.findById(defaultID);
        assertEquals(found.getNoteName(), updatedNote);
    }

    @Test
    public void testListAndIncrementation(){
        int size = getNoteImpl.findAll().size();
        Note note = new Note(1, "New Note");
        getNoteImpl.persist(note);
        assertNotNull(getNoteImpl.findById((long) size));
        assertEquals(size + 1 , getNoteImpl.findAll().size());
    }


}
