package DAO;

import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

/**
 * Created by mkhimich on 8/4/16.
 */
@Repository("noteDao")
public interface NoteDao extends DaoInterface<Note> {
    List<Note> findUserNotes(long id);
}
