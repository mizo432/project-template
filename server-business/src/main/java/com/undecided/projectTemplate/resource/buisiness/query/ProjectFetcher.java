package com.undecided.projectTemplate.resource.buisiness.query;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.ProjectRepository;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFetcher {

    private final ProjectRepository projectRepository;


    public ProjectFetcher(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> selectAll() {
        return projectRepository.selectAll();

    }

    public Project findOneBy(SnowflakeIdentifier<Project> projectId) {
        return projectRepository.findOneBy(projectId);

    }
}
