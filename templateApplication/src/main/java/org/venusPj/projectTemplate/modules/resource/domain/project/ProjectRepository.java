package org.venusPj.projectTemplate.modules.resource.domain.project;

import java.util.List;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

public interface ProjectRepository {

    Project findOnBy(Identifier<Project> projectId);

    List<Project> selectAll();

    void insert(Project project);

    void update(Project project);

    void delete(Identifier<Project> projectId);

}
