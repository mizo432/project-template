package com.undecided.projectTemplate.business.domain.entity.event;

import com.undecided.projectTemplate.business.domain.entity.EntityKanaName;
import com.undecided.projectTemplate.business.domain.entity.EntityName;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
// @Entity(immutable = true)
// @Table(schema = "tm", name = "events")
public class Event extends AbstractEntity<Event> {

    private EntityKanaName kanaName;
    private EntityName name;

    Event(UlidIdentifier<Event> id, AuditInfo auditInfo, EntityKanaName kanaName,
        EntityName name) {
        super(id, auditInfo);
        this.kanaName = kanaName;
        this.name = name;

    }

    public static Event create(UlidIdentifier<Event> id, AuditInfo auditInfo,
        EntityKanaName kanaName,
        EntityName name) {
        return new Event(id, auditInfo, kanaName, name);
    }

}