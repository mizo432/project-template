package com.undecided.projectTemplate.modules.project.domain.model.project;

import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

import java.util.List;

public interface ProjectRepository {

    Project findOneBy(SnowflakeId<Project> id);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(SnowflakeId<Project> id);

    Project findOneByCode(ProjectCode projectCode);

}
