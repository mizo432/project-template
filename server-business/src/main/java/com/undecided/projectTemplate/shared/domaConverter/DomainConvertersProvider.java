package com.undecided.projectTemplate.shared.domaConverter;

import com.undecided.projectTemplate.business.infra.daoConverter.entity.EntityKanaNameConverter;
import com.undecided.projectTemplate.business.infra.daoConverter.entity.EntityNameConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.projectCode.ProjectCodeConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.projectName.ProjectNameConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.storyCodePrefix.StoryCodePrefixConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.story.attribute.DescriptionConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.identifier.IdentifierConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.whenNoticed.WhenNoticedConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.whoNoticed.WhoNoticedConverter;
import org.seasar.doma.DomainConverters;

@DomainConverters({ProjectNameConverter.class, ProjectCodeConverter.class,
    StoryCodePrefixConverter.class, IdentifierConverter.class, WhenNoticedConverter.class,
    WhoNoticedConverter.class, DescriptionConverter.class, EntityKanaNameConverter.class,
    EntityNameConverter.class})
public class DomainConvertersProvider {

}
