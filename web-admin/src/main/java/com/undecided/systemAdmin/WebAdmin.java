package com.undecided.systemAdmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class WebAdmin {

    public static void main(String[] args) {
        SpringApplication.run(WebAdmin.class, args);

    }

}
