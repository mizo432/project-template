package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import com.undecided.projectTemplate.shared.idHolder.ProjectIdHolder;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import com.undecided.projectTemplate.shared.value.ValuePreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Entity extends AbstractEntity<Entity> {

    private final UlidIdentifier<Project> projectIdentifier;

    private final EntityName name;
    private final EntityKanaName kanaName;

    private final EntityType type;

    @VisibleForTesting
    Entity(UlidIdentifier<Entity> id, UlidIdentifier<Project> projectIdentifier,
        AuditInfo auditInfo,
        EntityName name,
        EntityKanaName kanaName, EntityType type) {
        super(id, auditInfo);
        ObjectPreconditions.checkNotNull(name, "name");
        ValuePreconditions.checkNotEmpty(name, "name");
        ValuePreconditions.checkNotEmpty(kanaName, "kanaName");
        ObjectPreconditions.checkNotNull(type, "type");
        ObjectPreconditions.checkNotNull(projectIdentifier, "projectIdentifier");
        this.projectIdentifier = projectIdentifier;
        this.name = name;
        this.kanaName = kanaName;
        this.type = type;

    }

    public Entity() {
        this(UlidIdentifier.newInstance(), UlidIdentifier.empty(), AuditInfo.empty(),
            EntityName.empty(),
            EntityKanaName.empty(), EntityType.UNKNOWN);
    }

    public static Entity create(@NotNull EntityName name, @NotNull EntityKanaName kanaName) {
        return new Entity(UlidIdentifier.newInstance(), ProjectIdHolder.operatingIdentifier(),
            AuditInfo.empty(), name, kanaName, EntityType.UNKNOWN);

    }

    public boolean isEmpty() {
        return projectIdentifier.isEmpty() && name.isEmpty() && auditInfo.isEmpty()
            && kanaName.isEmpty() && type.isUnknown();
    }

}
