package template.shared.application;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import template.modules.security.appl.command.InitializeAuthDataCommand;

@Component
@AllArgsConstructor
public class TemplateApplicationRunner implements ApplicationRunner {

    private final InitializeAuthDataCommand initializeAuthDataCommand;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        initializeAuthDataCommand.execute();
    }
}
