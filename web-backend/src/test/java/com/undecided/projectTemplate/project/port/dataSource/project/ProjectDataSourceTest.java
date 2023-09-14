package com.undecided.projectTemplate.project.port.dataSource.project;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.attribute.ProjectAttribute;
import template.modules.admin.domain.model.project.attribute.ProjectCode;
import template.modules.admin.domain.model.project.attribute.ProjectName;
import template.modules.admin.domain.model.project.attribute.StoryCodePrefix;
import template.modules.project.port.dataSource.project.ProjectDataSource;
import template.shared.type.description.Description;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectDataSourceTest {

    @SpringBootTest
    @Nested
    class springBoot {


        @Autowired
        ProjectDataSource projectDataSource;

        @Test
        @Transactional
        void insert() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);

            Project actualOptionalProject = projectDataSource.findOneById(
                    project.getProjectTd());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);

        }

        @Test
        @Transactional
        void update() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);
            projectDataSource.update(project);

            Project actualOptionalProject = projectDataSource.findOneById(
                    project.getProjectTd());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);

        }

        @Test
        @Transactional
        void delete() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);
            projectDataSource.delete(project.getProjectTd());

            Project actualOptionalProject = projectDataSource.findOneById(
                    project.getProjectTd());
            assertThat(actualOptionalProject).isNull();

        }

        @Test
        @Transactional
        void selectAll() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);

            List<Project> actualProjects = projectDataSource.selectAll();
            System.out.println(actualProjects);
            assertThat(actualProjects).isNotNull().hasSize(1);

        }

    }

}