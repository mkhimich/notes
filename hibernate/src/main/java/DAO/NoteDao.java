package DAO;

import java.util.List;

/**
 * Created by mkhimich on 8/2/16.
 */
public interface NoteDao {
    public List<Note> getAllNotes();
    public Note getNote(int id);
    public void updateNote(Note note);
    public void deleteNote(Note note);
    public void deleteNote(int id);
}
