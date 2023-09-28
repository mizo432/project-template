package template.modules.project.domain.model.business.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import template.modules.project.domain.model.business.entity.attribute.EntityAttribute;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.ValuePreconditions;

@Getter
@ToString
@EqualsAndHashCode
@Entity(immutable = true)
@Table(schema = "business", name = "model_entities")
public class ModelEntity {

    public static final ModelEntity EMPTY_ENTITY = new ModelEntity();
    
    private final SnowflakeId id;

    private final EntityAttribute attribute;
    private final AuditInfo auditInfo;

    private final SnowflakeId projectId;

    public ModelEntity() {
        this(SnowflakeId.EMPTY_VALUE,
                SnowflakeId.EMPTY_VALUE,
                AuditInfo.EMPTY_VALUE,
                EntityAttribute.EMPTY_VALUE);
    }

    @VisibleForTesting
    ModelEntity(SnowflakeId id, SnowflakeId projectId,
                AuditInfo auditInfo, EntityAttribute attribute) {
        ValuePreconditions.checkNotEmpty(projectId, "projectId");
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
        this.projectId = projectId;

    }


    public static ModelEntity create(@NotNull EntityAttribute attribute, SnowflakeId id) {
        return new ModelEntity(SnowflakeId.newInstance(),
                id, AuditInfo.EMPTY_VALUE, attribute);

    }

    public boolean isEmpty() {
        return id.isEmpty() && attribute.isEmpty() && projectId.isEmpty();

    }

}
