package org.venusPj.projectTemplate.modules.resource.infra.dao.projects;

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
                ProjectCode.of("ProjectCode"), StoryCodePrefix.of("APL")));
            projectsDao.insert(project);

        }

    }

}