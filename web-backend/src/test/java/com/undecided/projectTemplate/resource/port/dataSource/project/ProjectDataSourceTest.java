package com.undecided.projectTemplate.resource.port.dataSource.project;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectAttribute;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectName;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.StoryCodePrefix;
import com.undecided.projectTemplate.modules.resource.port.dataSource.project.ProjectDataSource;
import com.undecided.projectTemplate.modules.story.domain.story.attribute.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

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
                    project.getId());
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
                    project.getId());
            assertThat(actualOptionalProject).isNotNull();
            System.out.println(actualOptionalProject);
        }

        @Test
        @Transactional
        void delete() {
            Project project = Project.create(ProjectAttribute.create(ProjectName.of("ProjectName"),
                    ProjectCode.of("PRJ"), StoryCodePrefix.of("APL"), Description.of("description")));
            projectDataSource.insert(project);
            projectDataSource.delete(project.getId());

            Project actualOptionalProject = projectDataSource.findOneBy(
                    project.getId());
            assertThat(actualOptionalProject).isNull();

        }

    }
}