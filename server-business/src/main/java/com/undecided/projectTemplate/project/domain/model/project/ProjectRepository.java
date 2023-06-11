package com.undecided.projectTemplate.project.domain.model.project;

import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

import java.util.List;

public interface ProjectRepository {

    Project findOneById(SnowflakeId id);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(SnowflakeId id);

    Project findOneByCode(ProjectCode projectCode);

}
