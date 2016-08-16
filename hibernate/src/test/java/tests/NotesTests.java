package tests;

import DAO.DaoInterface;
import DAO.Note;
import DAO.NoteDao;
import org.junit.Test;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mkhimich on 8/4/16.
 */
public class NotesTests extends BaseCrudTest<Note> {

    @Inject
    NoteDao noteDao;

    @Test
    public void testList() {
        int count = 1000;
        List<Note> originalNotes = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Note note = getNewPopulatedModel();
            noteDao.persist(note);
            originalNotes.add(note);
        }
        List<Note> noteList = noteDao.findAll();
        assertEquals(count, noteList.size());
        for (int i = 0; i < count; i++) {
            assertTrue(noteList.contains(originalNotes.get(i)));
        }

    }

//    @Test
//    public void testTableSize() {
//        assertEquals("Not all 5 notes saved ", noteImpl.findAll().size(), 5);
//    }
//
//    @Test
//    public void testCreateDeleteNote(){
//        Note note = new Note(1, "Note Created");
//        noteImpl.persist(note);
//        assertTrue("note is null", note.getId()> 0);
//        Note found = noteImpl.findById(note.getId());
//        assertEquals(note.getNoteName(), found.getNoteName());
//        assertEquals(note.getUserId(), found.getUserId());
//        assertEquals(note, found);
//        long id = found.getId();
//        noteImpl.deleteById(id);
//        assertNull(noteImpl.findById(id));
//    }
//
//
//
//    @Test
//    public void testUpdateNote(){
//        long defaultID = 4L;
//        String updatedNote = "Updated Note";
//        Note note = noteImpl.findById(defaultID);
//        assertNotEquals(note.getNoteName(), updatedNote);
//        note.setNoteName("Updated Note");
//        noteImpl.update(note);
//        Note found = noteImpl.findById(defaultID);
//        assertEquals(found.getNoteName(), updatedNote);
//    }
//
//    @Test
//    public void testListAndIncrementation(){
//        int size = noteImpl.findAll().size();
//        Note note = new Note(1, "New Note");
//        noteImpl.persist(note);
//        assertNotNull(noteImpl.findById((long) size));
//        assertEquals(size + 1 , noteImpl.findAll().size());
//    }


    @Override
    protected DaoInterface<Note> getDao() {
        return noteDao;
    }

    int counter = 0;

    @Override
    protected Note getNewPopulatedModel() {
        return new Note(1, "Note " + counter++);
    }

    @Override
    protected Note getUpdatedModel(Note note) {
        note.setNoteName(note.getNoteName() + " updated");
        note.setUserId(note.getUserId() + 1);
        return note;
    }
}
