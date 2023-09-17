package template.modules.admin.presentation.web.project;

import lombok.Data;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;

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
}
