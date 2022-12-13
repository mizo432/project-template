package org.venusPj.projectTemplate.modules.resource.infra.dao.projects;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectCode;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectName;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.StoryCodePrefix;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.Description;

class ProjectsDaoTest {

    @SpringBootTest
    @Nested
    class springBoot {


        @Autowired
        ProjectsDao projectsDao;

        @Test
        @Transactional
        void insert() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectsDao.insert(project);

            Project actualOptionalProject = projectsDao.findOneById(
                project.getProjectId());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);

        }

        @Test
        @Transactional
        void update() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectsDao.insert(project);
            projectsDao.update(project);

            Project actualOptionalProject = projectsDao.findOneById(
                project.getProjectId());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);

        }

        @Test
        @Transactional
        void delete() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectsDao.insert(project);
            projectsDao.delete(project.getProjectId());

            Project actualOptionalProject = projectsDao.findOneById(
                project.getProjectId());
            assertThat(actualOptionalProject).isNull();

        }

        @Test
        @Transactional
        void selectAll() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectsDao.insert(project);

            List<Project> actualProjects = projectsDao.selectAll();
            System.out.println(actualProjects);
            assertThat(actualProjects).isNotNull().hasSize(1);

        }

    }

}