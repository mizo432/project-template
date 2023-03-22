package com.undecided.projectTemplate.resource.domain.project;

import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.util.List;

public interface ProjectRepository {

    Project findOneBy(UlidIdentifier<Project> projectId);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(UlidIdentifier<Project> projectId);

}
