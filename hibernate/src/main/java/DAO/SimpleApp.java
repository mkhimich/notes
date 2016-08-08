package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

/**
 * Created by mkhimich on 8/5/16.
 */
public class SimpleApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        NoteDaoImpl noteImpl = (NoteDaoImpl) context.getBean("noteImpl");

        Note note = new Note();
        note.setId(0);
        note.setUsername(1);
        note.setNoteName("Note");
        note.setNoteFull("Note Full");
        noteImpl.persist(note);
        System.out.println("Note : " + note + " added successfully");

        List<Note> notes = noteImpl.findAll();
        System.out.println("The list of all persons = " + notes.size());
    }
}
