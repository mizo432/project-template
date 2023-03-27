package com.undecided.projectTemplate.resource.infra.dao.projects;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectAttribute;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectCode;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectName;
import com.undecided.projectTemplate.resource.domain.project.attribute.StoryCodePrefix;
import com.undecided.projectTemplate.resource.domain.story.attribute.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
                    project.getId());
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
                    project.getId());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);

        }

        @Test
        @Transactional
        void delete() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectsDao.insert(project);
            projectsDao.delete(project.getId());

            Project actualOptionalProject = projectsDao.findOneById(
                    project.getId());
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