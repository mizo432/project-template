package org.venusPj.projectTemplate.modules.resource.domain.project;

import java.util.List;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

public interface ProjectRepository {

    Project findOneBy(Identifier<Project> projectId);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(Identifier<Project> projectId);

}
