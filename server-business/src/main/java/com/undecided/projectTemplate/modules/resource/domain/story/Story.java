package com.undecided.projectTemplate.modules.resource.domain.story;

import com.undecided.projectTemplate.modules.resource.domain.project.AbstractProjectResource;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.story.attribute.StoryAttribute;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Story extends AbstractProjectResource<Story> {

    private final StoryAttribute attribute;

    private Story(UlidIdentifier<Story> id, AuditInfo auditInfo, UlidIdentifier<Project> projectId,
        StoryAttribute attribute) {
        super(id, auditInfo, projectId);
        this.attribute = attribute;

    }

    public static Story create(UlidIdentifier<Project> projectId, StoryAttribute attribute) {
        return new Story(UlidIdentifier.newInstance(), AuditInfo.empty(), projectId, attribute);

    }

    public static Story reconstruct(String storyId, LocalDateTime whenNoticed, String whoNoticed,
        String productId, @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(UlidIdentifier.reconstruct(storyId),
            AuditInfo.reconstruct(whenNoticed, whoNoticed), UlidIdentifier.reconstruct(productId),
            attribute);

    }

    public static Story reconstruct(UlidIdentifier<Story> storyId, AuditInfo auditInfo,
        UlidIdentifier<Project> projectId,
        @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(storyId, auditInfo, projectId, attribute);

    }

    @Override
    public boolean sameValueAs(Story other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
