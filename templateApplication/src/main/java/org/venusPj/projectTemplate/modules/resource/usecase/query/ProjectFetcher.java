package org.venusPj.projectTemplate.modules.resource.usecase.query;

import java.util.List;
import org.springframework.stereotype.Service;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectRepository;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Service
public class ProjectFetcher {

    private final ProjectRepository projectRepository;


    public ProjectFetcher(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> selectAll() {
        return projectRepository.selectAll();
        
    }

    public Project findOneBy(Identifier<Project> projectId) {
        return projectRepository.findOneBy(projectId);

    }
}