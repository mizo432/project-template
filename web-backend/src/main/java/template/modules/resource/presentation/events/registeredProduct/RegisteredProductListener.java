package template.modules.resource.presentation.events.registeredProduct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import template.modules.project.domain.model.project.Project;
import template.modules.project.domain.model.project.RegisteredProjectEvent;

@Component
@Slf4j
public class RegisteredProductListener implements ApplicationListener<RegisteredProjectEvent> {

    @Override
    public void onApplicationEvent(RegisteredProjectEvent event) {
        Project project = event.getProject();
        log.debug("registered " + project);

    }

}
