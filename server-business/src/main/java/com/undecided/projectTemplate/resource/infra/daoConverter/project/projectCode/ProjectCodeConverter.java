package com.undecided.projectTemplate.resource.infra.daoConverter.project.projectCode;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectCode;

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
