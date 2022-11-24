package org.venusPj.projectTemplate.modules.resource.domain.project;

import java.util.List;

public interface ProjectRepository {

    Project findOnBy(ProjectId projectId);

    List<Project> selectAll();

    void insert(Project project);

    void update(Project project);

    void delete(ProjectId projectId);

}
