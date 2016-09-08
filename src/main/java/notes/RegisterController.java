package notes;

/**
 * Created by mkhimich on 8/29/16.
 */
import DAO.User;
import DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
                                      Map<String, Object> model) {

        System.out.println("username: " + user.getNickname());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        userDao.persist(user);
        return "login";
    }
}