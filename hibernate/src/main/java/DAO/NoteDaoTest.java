package DAO;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mkhimich on 8/2/16.
 */
public class NoteDaoTest {
     @Autowired
     public static NoteDaoImpl noteDaoImpl;

    public static void main(String[] args) {
        NoteDaoImpl noteDao = new NoteDaoImpl();
        printNotes(noteDao);
        //updating note
        Note note = noteDaoImpl.findById(0L);
        note.setNoteName("Updated Note Name");
        noteDao.persist(note);

        Note anotherNote = noteDaoImpl.findById(1L);
        noteDao.remove(anotherNote);

        printNotes(noteDao);
    }

    private static void printNotes(NoteDaoImpl noteDao) {
        //sout all notes
        for (Note note: noteDao.findAll()){
            System.out.println("Note id:" + note.getId() + " For user " + note.getUsername() + " with: " + note.getNoteName() + " " + note.getNoteFull());
        }
    }
}
