package com.undecided.projectTemplate.resource.infra.daoConverter.project.attribute.storyCodePrefix;

import com.undecided.projectTemplate.resource.domain.project.attribute.StoryCodePrefix;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class StoryCodePrefixConverter implements DomainConverter<StoryCodePrefix, String> {

    @Override
    public String fromDomainToValue(StoryCodePrefix storyCodePrefix) {
        return storyCodePrefix.getValue();

    }

    @Override
    public StoryCodePrefix fromValueToDomain(String value) {
        return StoryCodePrefix.reconstruct(value);

    }

}
