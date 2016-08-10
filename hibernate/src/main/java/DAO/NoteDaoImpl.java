package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by mkhimich on 8/2/16.
 */
@Service
@Component
@Repository("noteDaoImpl")
public class NoteDaoImpl extends GenericDao<Note> implements NoteDao {
    @Autowired
    private NoteDao noteDao;

    public NoteDao getNoteDao(){
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void addNote(Note note){
        getNoteDao().persist(note);
    }

}
