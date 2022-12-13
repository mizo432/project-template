package org.venusPj.projectTemplate.modules.resource.infra.dataSource.project;

import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectRepository;
import org.venusPj.projectTemplate.modules.resource.infra.dao.projects.ProjectsDao;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Component
public class ProjectDataSource implements ProjectRepository {

    private final ProjectsDao projectsDao;

    public ProjectDataSource(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    @Override
    @Cacheable(value = "project", key = "'projectId/' + #projectId")
    public Project findOneBy(Identifier<Project> projectId) {
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
    public void delete(Identifier<Project> projectId) {
        projectsDao.delete(projectId);

    }

}
