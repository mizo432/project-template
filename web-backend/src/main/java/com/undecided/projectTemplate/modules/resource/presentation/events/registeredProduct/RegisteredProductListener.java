package com.undecided.projectTemplate.modules.resource.presentation.events.registeredProduct;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.RegisteredProjectEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisteredProductListener implements ApplicationListener<RegisteredProjectEvent> {

    @Override
    public void onApplicationEvent(RegisteredProjectEvent event) {
        Project project = event.getProject();
        log.debug("registered " + project);

    }

}
