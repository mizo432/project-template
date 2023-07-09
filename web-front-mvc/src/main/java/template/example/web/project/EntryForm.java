package template.example.web.project;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import template.modules.project.domain.model.project.Project;

@Getter
@Setter
@ToString
public class EntryForm {
    private Project project = new Project();

}
