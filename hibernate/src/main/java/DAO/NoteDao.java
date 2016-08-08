package DAO;

import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by mkhimich on 8/4/16.
 */
@Repository("noteDao")
public interface NoteDao extends DaoInterface<Note> {

}
