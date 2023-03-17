package com.undecided.projectTemplate.modules.resource.domain.project;

import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import java.util.List;

public interface ProjectRepository {

    Project findOneBy(UildIdentifier<Project> projectId);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(UildIdentifier<Project> projectId);

}
