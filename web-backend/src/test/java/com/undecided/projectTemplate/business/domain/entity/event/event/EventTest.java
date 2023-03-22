package com.undecided.projectTemplate.business.domain.entity.event.event;

import com.undecided.projectTemplate.business.domain.entity.EntityKanaName;
import com.undecided.projectTemplate.business.domain.entity.EntityName;
import com.undecided.projectTemplate.business.domain.entity.event.Event;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class EventTest {

    /**
     * Method under test:
     * {@link Event#create(UlidIdentifier, AuditInfo, EntityKanaName, EntityName)}
     */
    @Test
    void testCreate() {
        UlidIdentifier<Event> emptyResult = UlidIdentifier.empty();
        AuditInfo emptyResult1 = AuditInfo.empty();
        EntityKanaName ofResult = EntityKanaName.of("42");
        EntityName ofResult1 = EntityName.of("42");
        Event actualAnyResult = Event.create(emptyResult, emptyResult1, ofResult, ofResult1);
        assertEquals(emptyResult1, actualAnyResult.getAuditInfo());
        assertSame(ofResult1, actualAnyResult.getName());
        assertSame(emptyResult, actualAnyResult.getId());
        assertSame(ofResult, actualAnyResult.getKanaName());
    }
}

