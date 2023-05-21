package com.undecided.projectTemplate.business.domain.model.entity;

import com.undecided.projectTemplate.business.domain.model.entity.attribute.EntityAttribute;
import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
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

    private final SnowflakeIdentifier<ModelEntity> id;

    private final EntityAttribute attribute;
    private final AuditInfo auditInfo;

    private final SnowflakeIdentifier<Project> projectId;

    public ModelEntity() {
        this(SnowflakeIdentifier.empty(),
                SnowflakeIdentifier.empty(),
                AuditInfo.empty(),
                EntityAttribute.empty());
    }

    @VisibleForTesting
    ModelEntity(SnowflakeIdentifier<ModelEntity> id, SnowflakeIdentifier<Project> projectId,
                AuditInfo auditInfo, EntityAttribute attribute) {
        ValuePreconditions.checkNotEmpty(projectId, "projectId");
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
        this.projectId = projectId;

    }


    public static ModelEntity create(@NotNull EntityAttribute attribute) {
        return new ModelEntity(SnowflakeIdentifier.newInstance(),
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
