package com.undecided.projectTemplate.story.domain.story;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.DddEntity;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import com.undecided.projectTemplate.story.domain.story.attribute.StoryAttribute;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.time.LocalDateTime;

import static com.undecided.primitive.object.Objects2.isNull;

@Entity(immutable = true)
@Getter
@ToString()
public class Story implements DddEntity<Story> {

    @Id
    protected final SnowflakeIdentifier<Story> id;

    protected final AuditInfo auditInfo;

    private final SnowflakeIdentifier<Project> projectId;
    private final StoryAttribute attribute;

    Story(SnowflakeIdentifier<Story> id, AuditInfo auditInfo,
          SnowflakeIdentifier<Project> projectId,
          StoryAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Story create(SnowflakeIdentifier<Project> projectId, StoryAttribute attribute) {
        return new Story(SnowflakeIdentifier.newInstance(), AuditInfo.empty(), projectId,
                attribute);

    }

    public static Story reconstruct(Long storyId, LocalDateTime whenNoticed, Long whoNoticed,
                                    Long productId, @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return reconstruct(SnowflakeIdentifier.reconstruct(storyId),
                AuditInfo.reconstruct(whenNoticed, whoNoticed),
                SnowflakeIdentifier.reconstruct(productId),
                attribute);

    }

    private static Story reconstruct(SnowflakeIdentifier<Story> storyId, AuditInfo auditInfo,
                                     SnowflakeIdentifier<Project> projectId, StoryAttribute attribute) {
        return new Story(storyId, auditInfo, projectId, attribute);

    }

    @Override
    public boolean sameIdAs(Story other) {
        if (isNull(other)) {
            return false;
        }
        return id.equals(other.id);
    }

    @Override
    public boolean sameValueAs(Story other) {
        return sameIdAs(other)
                && projectId.equals(other.getProjectId())
                && attribute.equals(other.attribute);

    }

}
