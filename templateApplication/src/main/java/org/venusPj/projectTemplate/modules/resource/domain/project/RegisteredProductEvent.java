package org.venusPj.projectTemplate.modules.resource.domain.project;

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
