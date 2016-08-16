package tests;

import DAO.*;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mkhimich on 8/16/16.
 */
public class UsersTests extends BaseCrudTest<User> {

    @Inject
    UserDao userDao;

    @Inject
    NoteDao noteDao;

    @Override
    protected DaoInterface<User> getDao() {
        return userDao;
    }

    int counter = 0;

    @Override
    protected User getNewPopulatedModel() {
        counter++;
        return new User("nickname" + counter, "email@email.com" + counter, "password" + counter);
    }

    @Override
    protected User getUpdatedModel(User user) {
        String upd = "updated";
        user.setNickname(user.getNickname() + upd);
        user.setEmail(user.getEmail() + upd);
        user.setPassword(user.getPassword() + upd);
        return user;
    }

    @Test
    public void testNoteIntegration(){
        User user = getNewPopulatedModel();
        userDao.persist(user);
        User user2 = getNewPopulatedModel();
        userDao.persist(user2);

        Note note = new Note(user.getId(), "note0 for user 1");
        Note note1 = new Note(user.getId(), "note1 for user 1");
        Note note2 = new Note(user2.getId(), "note0 for user 2");
        Note note3 = new Note(user2.getId(), "note1 for user 2");
        noteDao.persist(note);
        noteDao.persist(note1);
        noteDao.persist(note2);
        noteDao.persist(note3);

        assertEquals(userDao.findAll().size(), 2);
        assertEquals(noteDao.findAll().size(), 4);

        List<Note> noteList = noteDao.findUserNotes(user.getId());
        assertEquals(note,noteList.get(0));
        assertEquals(note1,noteList.get(1));
        assertEquals(2, noteList.size());

        List<Note> user2Notes = noteDao.findUserNotes(user2.getId());
        assertEquals(note2,user2Notes.get(0));
        assertEquals(note3,user2Notes.get(1));
        assertEquals(2, user2Notes.size());

    }
}
