package org.venusPj.projectTemplate.modules.resource.domain.story;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.modules.resource.domain.product.ProductId;
import org.venusPj.projectTemplate.modules.resource.domain.product.ProductResource;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.StoryAttribute;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Story extends ProductResource<StoryId, Story> {

    private final StoryAttribute attribute;

    private Story(StoryId id, AuditInfo auditInfo, ProductId productId, StoryAttribute attribute) {
        super(id, auditInfo, productId);
        this.attribute = attribute;

    }

    public static Story create(ProductId productId, StoryAttribute attribute) {
        return new Story(StoryId.newInstance(), AuditInfo.empty(), productId, attribute);

    }

    public static Story reconstruct(String storyId, LocalDateTime whenNoticed, String whoNoticed,
        String productId, @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(StoryId.reconstruct(storyId),
            AuditInfo.reconstruct(whenNoticed, whoNoticed), ProductId.reconstruct(productId),
            attribute);

    }

    public static Story reconstruct(StoryId storyId, AuditInfo auditInfo, ProductId productId,
        @NotNull StoryAttribute attribute) {
        ObjectPreconditions.checkNotNull(attribute, "attribute");
        return new Story(storyId, auditInfo, productId, attribute);

    }

    @Override
    public boolean sameValueAs(Story other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
