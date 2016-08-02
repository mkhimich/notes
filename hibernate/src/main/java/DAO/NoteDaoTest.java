package DAO;

/**
 * Created by mkhimich on 8/2/16.
 */
public class NoteDaoTest {
    public static void main(String[] args) {
        NoteDao noteDao = new NoteDaoImpl();
        printNotes(noteDao);


        //updating note
        Note note = noteDao.getAllNotes().get(0);
        note.setNoteName("Updated Note Name");
        noteDao.updateNote(note);

        Note anotherNote = noteDao.getNote(1);
        noteDao.deleteNote(anotherNote);

        printNotes(noteDao);
    }

    private static void printNotes(NoteDao noteDao) {
        //sout all notes
        for (Note note: noteDao.getAllNotes()){
            System.out.println("Note id:" + note.getId() + " For user " + note.getUsername() + " with: " + note.getNoteName() + " " + note.getNoteFull());
        }
    }
}
