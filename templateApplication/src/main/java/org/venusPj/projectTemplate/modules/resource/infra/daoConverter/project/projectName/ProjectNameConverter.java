package org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectName;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectName;

@ExternalDomain
public class ProjectNameConverter implements DomainConverter<ProjectName, String> {


    @Override
    public String fromDomainToValue(ProjectName projectName) {
        return projectName.getValue();
    }

    @Override
    public ProjectName fromValueToDomain(String value) {
        return ProjectName.reconstruct(value);

    }
}
