package com.undecided.projectTemplate.modules.resource.usecase.query;

import java.util.List;
import org.springframework.stereotype.Service;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.project.ProjectRepository;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

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
