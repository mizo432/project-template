package template.modules.story.domain.model;

import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import template.modules.story.domain.model.attribute.StoryAttribute;
import template.shared.entity.AuditInfo;
import template.shared.entity.DddEntity;
import template.shared.entity.id.SnowflakeId;

import java.time.LocalDateTime;

import static com.undecided.primitive.object.Objects2.isNull;

@Entity(immutable = true)
@Getter
@ToString()
public class Story implements DddEntity<Story> {

    @Id
    protected final SnowflakeId id;

    protected final AuditInfo auditInfo;

    private final SnowflakeId projectId;
    private final StoryAttribute attribute;

    Story(SnowflakeId id, AuditInfo auditInfo,
          SnowflakeId projectId,
          StoryAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Story create(SnowflakeId projectId, StoryAttribute attribute) {
        return new Story(SnowflakeId.newInstance(), AuditInfo.EMPTY_VALUE, projectId,
                attribute);

    }

    public static Story reconstruct(Long storyId, LocalDateTime whenNoticed, Long whoNoticed,
                                    Long productId, @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return reconstruct(SnowflakeId.reconstruct(storyId),
                AuditInfo.reconstruct(whenNoticed, whoNoticed),
                SnowflakeId.reconstruct(productId),
                attribute);

    }

    private static Story reconstruct(SnowflakeId storyId, AuditInfo auditInfo,
                                     SnowflakeId projectId, StoryAttribute attribute) {
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
