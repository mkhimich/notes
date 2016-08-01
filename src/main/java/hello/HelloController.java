package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mkhimich on 8/1/16.
 */
@Component
public class HelloController {
    final private HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}

