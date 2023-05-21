package com.undecided.projectTemplate.project.domain.model.project;

import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;

import java.util.List;

public interface ProjectRepository {

    Project findOneBy(SnowflakeIdentifier<Project> id);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(SnowflakeIdentifier<Project> id);

    Project findOneByCode(ProjectCode projectCode);

}
