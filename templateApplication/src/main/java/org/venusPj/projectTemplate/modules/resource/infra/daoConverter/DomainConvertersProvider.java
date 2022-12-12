package org.venusPj.projectTemplate.modules.resource.infra.daoConverter;

import org.seasar.doma.DomainConverters;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.entity.identifier.IdentifierConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.entity.whenNoticed.WhenNoticedConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.entity.whoNoticed.WhoNoticedConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectCode.ProjectCodeConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectName.ProjectNameConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.storyCodePrefix.StoryCodePrefixConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.story.attribute.DescriptionConverter;

@DomainConverters({ProjectNameConverter.class, ProjectCodeConverter.class,
    StoryCodePrefixConverter.class, IdentifierConverter.class, WhenNoticedConverter.class,
    WhoNoticedConverter.class, DescriptionConverter.class})
public class DomainConvertersProvider {

}
