package com.undecided.projectTemplate.modules.resource.infra.daoConverter;

import com.undecided.projectTemplate.modules.resource.infra.daoConverter.entity.identifier.IdentifierConverter;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.entity.whenNoticed.WhenNoticedConverter;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.entity.whoNoticed.WhoNoticedConverter;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.project.projectCode.ProjectCodeConverter;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.project.projectName.ProjectNameConverter;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.project.storyCodePrefix.StoryCodePrefixConverter;
import org.seasar.doma.DomainConverters;
import com.undecided.projectTemplate.modules.resource.infra.daoConverter.story.attribute.DescriptionConverter;

@DomainConverters({ProjectNameConverter.class, ProjectCodeConverter.class,
    StoryCodePrefixConverter.class, IdentifierConverter.class, WhenNoticedConverter.class,
    WhoNoticedConverter.class, DescriptionConverter.class})
public class DomainConvertersProvider {

}
