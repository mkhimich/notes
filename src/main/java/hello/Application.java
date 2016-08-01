package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mkhimich on 8/1/16.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    HelloService mockMessageService() {
        return new HelloService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        HelloController printer = context.getBean(HelloController.class);
        printer.printMessage();
    }
}