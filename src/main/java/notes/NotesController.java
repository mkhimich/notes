package notes;

import DAO.Note;
import DAO.NoteDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = {"/welcome"})
    public ModelAndView welcomePage(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        model.addObject("msg", "You've been logged out successfully.");
        model.setViewName("login");

        return model;

    }
}
