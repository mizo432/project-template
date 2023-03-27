package com.undecided.projectTemplate.resource.infra.daoConverter.project.attribute.projectCode;

import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectCode;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class ProjectCodeConverter implements DomainConverter<ProjectCode, String> {

    @Override
    public String fromDomainToValue(ProjectCode projectCode) {
        return projectCode.getValue();

    }

    @Override
    public ProjectCode fromValueToDomain(String value) {
        return ProjectCode.reconstruct(value);

    }

}
