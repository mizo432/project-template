package com.undecided.projectTemplate.modules.business.domain.model.entity;

import com.undecided.projectTemplate.modules.business.domain.model.entity.attribute.EntityAttribute;
import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.idHolder.ProjectIdHolder;
import com.undecided.projectTemplate.shared.value.ValuePreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Getter
@ToString
@EqualsAndHashCode
@Entity(immutable = true)
@Table(schema = "business", name = "model_entities")
public class ModelEntity {

    private final SnowflakeId<ModelEntity> id;

    private final EntityAttribute attribute;
    private final AuditInfo auditInfo;

    private final SnowflakeId<Project> projectId;

    public ModelEntity() {
        this(SnowflakeId.empty(),
                SnowflakeId.empty(),
                AuditInfo.empty(),
                EntityAttribute.empty());
    }

    @VisibleForTesting
    ModelEntity(SnowflakeId<ModelEntity> id, SnowflakeId<Project> projectId,
                AuditInfo auditInfo, EntityAttribute attribute) {
        ValuePreconditions.checkNotEmpty(projectId, "projectId");
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
        this.projectId = projectId;

    }


    public static ModelEntity create(@NotNull EntityAttribute attribute) {
        return new ModelEntity(SnowflakeId.newInstance(),
                ProjectIdHolder.operatingIdentifier(),
                AuditInfo.empty(), attribute);

    }

    public static ModelEntity empty() {
        return new ModelEntity();
    }

    public boolean isEmpty() {
        return id.isEmpty() && attribute.isEmpty() && projectId.isEmpty();

    }

}
