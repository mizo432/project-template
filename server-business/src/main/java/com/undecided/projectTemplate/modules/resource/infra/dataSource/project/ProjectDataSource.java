package com.undecided.projectTemplate.modules.resource.infra.dataSource.project;

import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.project.ProjectRepository;
import com.undecided.projectTemplate.modules.resource.infra.dao.projects.ProjectsDao;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ProjectDataSource implements ProjectRepository {

    private final ProjectsDao projectsDao;

    public ProjectDataSource(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    @Override
    @Cacheable(value = "project", key = "'projectId/' + #projectId")
    public Project findOneBy(UlidIdentifier<Project> projectId) {
        return projectsDao.findOneById(projectId);

    }

    @Override
    public List<Project> selectAll() {
        return projectsDao.selectAll();

    }

    @Override
    @CachePut(value = "project", key = "'projectId/' + #project.projectId")
    public Project insert(Project project) {
        projectsDao.insert(project);
        return project;

    }

    @Override
    @CachePut(value = "project", key = "'projectId/' + #project.projectId")
    public Project update(Project project) {
        projectsDao.update(project);
        return project;

    }

    @Override
    @CacheEvict(value = "project", key = "'projectId/' + #projectId")
    public void delete(UlidIdentifier<Project> projectId) {
        projectsDao.delete(projectId);

    }

}
