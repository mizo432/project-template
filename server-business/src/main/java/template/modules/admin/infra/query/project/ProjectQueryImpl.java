package template.modules.admin.infra.query.project;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import template.modules.admin.appl.query.project.ProjectQuery;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.ProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectQueryImpl implements ProjectQuery {
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> selectAchievable() {
        return projectRepository.selectAchievable();
    }
}
