package com.undecided.projectTemplate.shared.domaConverter;

import com.undecided.projectTemplate.business.infra.daoConverter.entity.EntityKanaNameConverter;
import com.undecided.projectTemplate.business.infra.daoConverter.entity.EntityNameConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.attribute.projectCode.ProjectCodeConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.attribute.projectName.ProjectNameConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.project.attribute.storyCodePrefix.StoryCodePrefixConverter;
import com.undecided.projectTemplate.resource.infra.daoConverter.story.attribute.DescriptionConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.identifier.SnowflakeIdentifierConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.whenNoticed.WhenNoticedConverter;
import com.undecided.projectTemplate.shared.domaConverter.entity.whoNoticed.WhoNoticedConverter;
import org.seasar.doma.DomainConverters;

@DomainConverters({ProjectNameConverter.class, ProjectCodeConverter.class,
        StoryCodePrefixConverter.class, SnowflakeIdentifierConverter.class, WhenNoticedConverter.class,
        WhoNoticedConverter.class, DescriptionConverter.class, EntityKanaNameConverter.class,
        EntityNameConverter.class})
public class DomainConvertersProvider {

}
