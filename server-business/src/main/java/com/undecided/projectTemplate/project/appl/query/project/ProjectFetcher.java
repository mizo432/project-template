package com.undecided.projectTemplate.project.appl.query.project;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.ProjectRepository;
import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
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

    public Project findOneBy(SnowflakeId projectId) {
        return projectRepository.findOneById(projectId);

    }

    public Project findOneByCode(ProjectCode projectCode) {
        return projectRepository.findOneByCode(projectCode);

    }
}
