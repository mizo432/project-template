package com.undecided.projectTemplate.resource.infra.dao.projects;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDaoImpl implements ProjectsDao {
    @Override
    public Project findOneById(SnowflakeIdentifier<Project> id) {
        return null;
    }

    @Override
    public List<Project> selectAll() {
        return new ArrayList<>();
    }

    @Override
    public Result<Project> insert(Project project) {
        return null;
    }

    @Override
    public Result<Project> update(Project project) {
        return null;
    }

    @Override
    public int delete(SnowflakeIdentifier<Project> id) {
        return 0;
    }
}
