package template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.undecided")
public class WebFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFrontApplication.class, args);

    }

}
