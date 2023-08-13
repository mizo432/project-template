package template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans
        ({@ComponentScan("com.undecided")})
public class WebBackend {

    public static void main(String[] args) {
        SpringApplication.run(WebBackend.class, args);

    }


}
