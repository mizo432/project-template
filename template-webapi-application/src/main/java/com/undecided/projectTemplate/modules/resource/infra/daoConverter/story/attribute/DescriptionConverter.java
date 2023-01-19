package com.undecided.projectTemplate.modules.resource.infra.daoConverter.story.attribute;

import com.undecided.projectTemplate.modules.resource.domain.story.attribute.Description;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

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
