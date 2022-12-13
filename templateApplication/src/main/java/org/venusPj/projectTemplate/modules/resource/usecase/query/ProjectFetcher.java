package org.venusPj.projectTemplate.modules.resource.usecase.query;

import java.util.List;
import org.springframework.stereotype.Service;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectRepository;

@Service
public class ProjectFetcher {

    private final ProjectRepository projectRepository;


    public ProjectFetcher(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> selectAll() {
        return projectRepository.selectAll();
    }
}
