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
@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "USERNAME", nullable = false)
    private String username;
    //Note name, can be empty
    @Column(name = "NOTE_NAME")
    private String noteName;

    //Full note, can be empty (if noteName is populated)
    @Column(name = "NOTE_FULL")
    private String noteFull;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public void setNoteFull(String noteFull) {
        this.noteFull = noteFull;
    }

}
