package com.undecided.projectTemplate.modules.resource.presentation.events.registeredProduct;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.RegisteredProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisteredProductListener implements ApplicationListener<RegisteredProductEvent> {

    @Override
    public void onApplicationEvent(RegisteredProductEvent event) {
        Project project = event.getProject();
        log.debug("regstered " + project);

    }

}
