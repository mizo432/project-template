package com.undecided.projectTemplate.modules.resource.infra.dataSource.project;

import static org.assertj.core.api.Assertions.assertThat;

import com.undecided.projectTemplate.modules.resource.domain.story.attribute.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import com.undecided.projectTemplate.modules.resource.domain.project.attribute.ProjectCode;
import com.undecided.projectTemplate.modules.resource.domain.project.attribute.ProjectName;
import com.undecided.projectTemplate.modules.resource.domain.project.attribute.StoryCodePrefix;

class ProjectDataSourceTest {

    @Nested
    @SpringBootTest
    class springTest {

        @Autowired
        ProjectDataSource projectDataSource;


        @Test
        @Transactional
        void selectAll() {
        }

        @Test
        @Transactional
        void insert() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);

            Project actualOptionalProject = projectDataSource.findOneBy(
                project.getProjectId());
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

            Project actualOptionalProject = projectDataSource.findOneBy(
                project.getProjectId());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);
        }

        @Test
        @Transactional
        void delete() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);
            projectDataSource.delete(project.getProjectId());

            Project actualOptionalProject = projectDataSource.findOneBy(
                project.getProjectId());
            assertThat(actualOptionalProject).isNull();

        }

    }
}