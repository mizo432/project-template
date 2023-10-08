package template.modules.admin.presentation.web.project;

import lombok.Data;
import org.jetbrains.annotations.VisibleForTesting;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;

import java.util.List;

import static com.undecided.primitive.list.Lists2.newArrayList;

/**
 * プロジェクトフォーム
 */
@Data
public class ProjectForm {
    private Long projectId;
    private String projectName;
    private String projectCode;
    private String storyCodePrefix;


    /**
     * 新規登録プロジェクトモデルに変換する
     *
     * @return プロジェクト
     */
    public Project convertToInsertModel() {
        return Project.create(ProjectAttribute.create(projectName, projectCode, storyCodePrefix));
    }

    public static List<ProjectForm> convertFromProjectListToList(List<Project> projectList) {
        final List<ProjectForm> result = newArrayList();
        for (final Project project : projectList) {
            result.add(convertFromProject(project));
        }
        return result;
    }

    @VisibleForTesting
    static ProjectForm convertFromProject(final Project project) {
        ProjectForm form = new ProjectForm();
        form.projectId = project.getProjectTd().getValue();
        form.projectCode = project.getAttribute().getProjectCode().asString();
        form.projectName = project.getAttribute().getProjectName().asString();
        form.storyCodePrefix = project.getAttribute().getStoryCodePrefix().asString();
        return form;

    }
}
