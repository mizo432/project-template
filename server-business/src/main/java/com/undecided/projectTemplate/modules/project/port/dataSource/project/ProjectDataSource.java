package com.undecided.projectTemplate.modules.project.port.dataSource.project;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.modules.project.domain.model.project.ProjectRepository;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDataSource implements ProjectRepository {
    @Override
    public Project findOneById(SnowflakeId id) {
        return null;
    }

    @Override
    public List<Project> selectAll() {
        return null;
    }

    @Override
    public Project insert(Project project) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public void delete(SnowflakeId id) {

    }

    @Override
    public Project findOneByCode(ProjectCode projectCode) {
        return null;
    }
}
