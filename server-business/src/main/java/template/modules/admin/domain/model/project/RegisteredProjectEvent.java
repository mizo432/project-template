package template.modules.admin.domain.model.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RegisteredProjectEvent extends
        ApplicationEvent {

    private final Project project;

    public RegisteredProjectEvent(Object source, Project project) {
        super(source);
        this.project = project;
    }
}
