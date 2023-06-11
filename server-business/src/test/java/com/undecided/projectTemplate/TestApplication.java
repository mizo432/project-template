package com.undecided.projectTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

    }

    @Test
    void createApplicationModuleModel() {
        ApplicationModules modules = ApplicationModules.of(TestApplication.class);
        modules.forEach(System.out::println);
    }

    @Test
    void writeDocumentationSnippets() {
        ApplicationModules modules = ApplicationModules.of(TestApplication.class);
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml()
                .writeModuleCanvases();
    }
}
