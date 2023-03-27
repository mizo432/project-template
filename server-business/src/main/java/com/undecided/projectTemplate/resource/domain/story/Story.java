package com.undecided.projectTemplate.resource.domain.story;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.story.attribute.StoryAttribute;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Story extends AbstractEntity<Story> {

    private final SnowflakeIdentifier<Project> projectId;
    private final StoryAttribute attribute;

    private Story(SnowflakeIdentifier<Story> id, AuditInfo auditInfo, SnowflakeIdentifier<Project> projectId,
                  StoryAttribute attribute) {
        super(id, auditInfo);
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Story create(SnowflakeIdentifier<Project> projectId, StoryAttribute attribute) {
        return new Story(SnowflakeIdentifier.newInstance(), AuditInfo.empty(), projectId, attribute);

    }

    public static Story reconstruct(Long storyId, LocalDateTime whenNoticed, Long whoNoticed,
                                    Long productId, @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(SnowflakeIdentifier.reconstruct(storyId),
                AuditInfo.reconstruct(whenNoticed, whoNoticed), SnowflakeIdentifier.reconstruct(productId),
                attribute);

    }

    private static Story reconstruct(SnowflakeIdentifier<Story> storyId, AuditInfo auditInfo,
                                     SnowflakeIdentifier<Project> projectId,
                                     @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(storyId, auditInfo, projectId, attribute);

    }

    @Override
    public boolean sameValueAs(Story other) {
        return super.sameValueAs(other)
                && projectId.equals(other.getProjectId())
                && attribute.equals(other.attribute);

    }

}
