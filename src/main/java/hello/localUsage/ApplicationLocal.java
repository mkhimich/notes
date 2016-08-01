package hello.localUsage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mkhimich on 8/1/16.
 */
@Configuration
@ComponentScan
public class ApplicationLocal {

    @Bean
    HelloService mockMessageService() {
        return new HelloService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationLocal.class);
//        HelloPrinter printer = context.getBean(HelloPrinter.class);
//        printer.printMessage();
//    }
}