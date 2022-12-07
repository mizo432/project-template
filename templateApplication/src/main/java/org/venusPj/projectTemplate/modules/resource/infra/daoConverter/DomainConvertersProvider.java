package org.venusPj.projectTemplate.modules.resource.infra.daoConverter;

import org.seasar.doma.DomainConverters;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectCode.ProjectCodeConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.projectName.ProjectNameConverter;
import org.venusPj.projectTemplate.modules.resource.infra.daoConverter.project.storyCodePrefix.StoryCodePrefixConverter;

@DomainConverters({ProjectNameConverter.class, ProjectCodeConverter.class,
    StoryCodePrefixConverter.class})
public class DomainConvertersProvider {

}
