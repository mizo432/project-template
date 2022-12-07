package org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectCode;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectCode;

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
