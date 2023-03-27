package com.undecided.projectTemplate.resource.domain.project;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;

import java.util.List;

public interface ProjectRepository {

    Project findOneBy(SnowflakeIdentifier<Project> projectId);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(SnowflakeIdentifier<Project> projectId);

}
