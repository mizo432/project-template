package com.undecided.projectTemplate.modules.project.domain.model.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RegisteredProductEvent extends
        ApplicationEvent {

    private final Project project;

    public RegisteredProductEvent(Object source, Project project) {
        super(source);
        this.project = project;
    }
}