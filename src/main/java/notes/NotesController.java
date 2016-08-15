package notes;

import DAO.Note;
import DAO.NoteDao;
import DAO.NoteDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mkhimich on 8/1/16.
 */
@Controller
@RestController
public class NotesController {

    @Inject
    NoteDao noteDao;

    @GetMapping
    public @ResponseBody List<Note> listNotes() {
        return noteDao.findAll();
    }

    @GetMapping("/notes/{id}")
    public @ResponseBody Note getNote(@PathVariable("id") Long id) {
        return noteDao.findById(id);
    }
}
