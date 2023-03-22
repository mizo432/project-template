package com.undecided.projectTemplate.resource.buisiness.query;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.ProjectRepository;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectFetcher {

    private final ProjectRepository projectRepository;


    public ProjectFetcher(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> selectAll() {
        return projectRepository.selectAll();

    }

    public Project findOneBy(UlidIdentifier<Project> projectId) {
        return projectRepository.findOneBy(projectId);

    }
}