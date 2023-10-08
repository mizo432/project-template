package template.modules.admin.appl.query.project;

import template.modules.admin.domain.model.project.Project;

import java.util.List;

public interface ProjectQuery {

    List<Project> selectAchievable();

}
