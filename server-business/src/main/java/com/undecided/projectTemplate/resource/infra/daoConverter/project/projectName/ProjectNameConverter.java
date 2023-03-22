package com.undecided.projectTemplate.resource.infra.daoConverter.project.projectName;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectName;

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
