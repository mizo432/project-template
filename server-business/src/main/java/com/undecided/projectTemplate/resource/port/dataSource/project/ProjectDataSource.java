package com.undecided.projectTemplate.resource.port.dataSource.project;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.ProjectRepository;
import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.resource.port.dao.projects.ProjectsDao;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDataSource implements ProjectRepository {

    private final ProjectsDao projectsDao;

    public ProjectDataSource(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    @Override
    @Cacheable(value = "project", key = "'id/' + #id")
    public Project findOneBy(SnowflakeIdentifier<Project> id) {
        return projectsDao.findOneById(id);

    }

    @Override
    public List<Project> selectAll() {
        return projectsDao.selectAll();

    }

    @Override
    @CachePut(value = "project", key = "'id/' + #project.id")
    public Project insert(Project project) {
        projectsDao.insert(project);
        return project;

    }

    @Override
    @CachePut(value = "project", key = "'id/' + #project.id")
    public Project update(Project project) {
        projectsDao.update(project);
        return project;

    }

    @Override
    @CacheEvict(value = "project", key = "'id/' + #id")
    public void delete(SnowflakeIdentifier<Project> id) {
        projectsDao.delete(id);

    }

    @Override
    public Project findOneByCode(ProjectCode projectCode) {
        return projectsDao.findOneByCode(projectCode);
    }

}
