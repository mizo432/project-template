package com.undecided.projectTemplate.modules.resource.infra.daoConverter.project.storyCodePrefix;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import com.undecided.projectTemplate.modules.resource.domain.project.attribute.StoryCodePrefix;

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
