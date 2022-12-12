package org.venusPj.projectTemplate.modules.resource.infra.daoConverter.story.attribute;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.Description;

@ExternalDomain
public class DescriptionConverter implements DomainConverter<Description, String> {

    @Override
    public String fromDomainToValue(Description description) {
        return description.getValue();
    }

    @Override
    public Description fromValueToDomain(String value) {
        return Description.reconstruct(value);

    }

}
