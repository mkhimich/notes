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
