package template.modules.admin.presentation.web.project;

import lombok.Data;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;

@Data
public class ProjectForm {
    private Long projectId;
    private String projectName;
    private String projectCode;
    private String storyCodePrefix;

    public Project convertToInsertModel() {
        return Project.create(ProjectAttribute.create(projectName, projectCode, storyCodePrefix));
    }
}
