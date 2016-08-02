package DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkhimich on 8/2/16.
 */
public class NoteDaoImpl extends JpaDao<Note> implements GeneralDao<Note> {

    List<Note> notes;

    public NoteDaoImpl(){
        notes = new ArrayList<>();
        Note noteOne = new Note();
        noteOne.setId(0);
        noteOne.setNoteFull("My Full Note");
        noteOne.setNoteName("My Note");
        noteOne.setUsername("mkh");

        Note noteTwo = new Note();
        noteTwo.setId(1);
        noteTwo.setNoteFull("My Full Note 2");
        noteTwo.setNoteName("My Note 2");
        noteTwo.setUsername("mkh 2");
        notes.add(noteOne);
        notes.add(noteTwo);
    }

//    @Override
//    public List<Note> getAllNotes() {
//        return notes;
//    }
//
//    @Override
//    public Note getNote(int id) {
//        return notes.get(id);
//    }
//
//    @Override
//    public void updateNote(Note note) {
//        int noteIndex = notes.indexOf(note);
//        notes.get(noteIndex).setNoteName(note.getNoteName());
//        notes.get(noteIndex).setNoteFull(note.getNoteFull());
//        System.out.println("Note with id = " + note.getId() + " was successfully updated" );
//    }
//
//    @Override
//    public void deleteNote(Note note) {
//        notes.remove(note);
//        System.out.println("Note with id = " + note.getId() + " was successfully removed" );
//    }
//
//    @Override
//    public void deleteNote(int id) {
//        notes.remove(id);
//        System.out.println("Note with id = " + id + " was successfully removed" );
//    }


    @Override
    public List<Note> findAll() {
        return notes;
    }
}
