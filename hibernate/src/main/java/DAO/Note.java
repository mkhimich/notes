package DAO;

import javax.persistence.*;

/**
 * Created by mkhimich on 8/1/16.
 */
@Entity(name = "notes")
public class Note implements IModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;
    //Note name, can be empty
    @Column(name = "note")
    private String noteName;

    @Column(name = "add_date", nullable = false)
    private long created;

    @PrePersist
    private void onCreate() {
        created = System.currentTimeMillis();
    }

//    //Full note, can be empty (if noteName is populated)
//    @Column(name = "note_full")
//    private String noteFull;

    public Note(long userId, String noteName) {
        this.userId = userId;
        this.noteName = noteName;
    }

    public Note() {

    }

    public Note(long id, long userId, String noteName) {
        this.id = id;
        this.userId = userId;
        this.noteName = noteName;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getCreated() {
        return created;
    }

    public String getNoteName() {
        return noteName;
    }

    //For testing purposes only
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (userId != note.userId) return false;
        return noteName != null ? noteName.equals(note.noteName) : note.noteName == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (noteName != null ? noteName.hashCode() : 0);
        return result;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
