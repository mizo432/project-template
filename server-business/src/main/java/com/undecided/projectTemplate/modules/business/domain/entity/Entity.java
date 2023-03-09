package com.undecided.projectTemplate.modules.business.domain.entity;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import com.undecided.projectTemplate.shared.value.ValuePreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Entity extends AbstractEntity<Entity> {

    private final EntityName name;
    private final EntityKanaName kanaName;

    public Entity(Identifier<Entity> id, AuditInfo auditInfo, EntityName name,
        EntityKanaName kanaName) {
        super(id, auditInfo);
        ObjectPreconditions.checkNotNull(name, "name");
        ValuePreconditions.checkNotEmpty(name, "name");
        ValuePreconditions.checkNotEmpty(kanaName, "kanaName");
        this.name = name;
        this.kanaName = kanaName;
    }

    public static Entity create(EntityName name, EntityKanaName kanaName) {
        return new Entity(Identifier.newInstance(), AuditInfo.empty(), name, kanaName);

    }

}
