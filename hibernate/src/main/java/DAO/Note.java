package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mkhimich on 8/1/16.
 */
@Entity(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int user_id;
    //Note name, can be empty
    @Column(name = "note")
    private String noteName;

    //Full note, can be empty (if noteName is populated)
    @Column(name = "NOTE_FULL")
    private String noteFull;

    public Note(int username, String noteName, String noteFull) {
        this.user_id = username;
        this.noteName = noteName;
        this.noteFull = noteFull;
    }

    public Note() {

    }

    public Note(int id, int user_id, String noteName, String noteFull) {
        this.id = id;
        this.user_id = user_id;
        this.noteName = noteName;
        this.noteFull = noteFull;
    }

    public int getId() {
        return id;
    }

    public int getUsername() {
        return user_id;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getNoteFull() {
        return noteFull;
    }

    //For testing purposes only
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(int user_id) {
        this.user_id = user_id;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public void setNoteFull(String noteFull) {
        this.noteFull = noteFull;
    }

}
