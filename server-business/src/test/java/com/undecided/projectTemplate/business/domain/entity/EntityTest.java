package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    /**
     * Method under test:
     * {@link Entity#Entity(UlidIdentifier, UlidIdentifier, AuditInfo, EntityName, EntityKanaName,
     * EntityType)}
     */
    @Test
    void testConstructor8() {
        UlidIdentifier<Entity> id = UlidIdentifier.empty();
        UlidIdentifier<Project> emptyResult = UlidIdentifier.empty();
        AuditInfo emptyResult1 = AuditInfo.empty();
        EntityName name = EntityName.of("42");
        EntityKanaName ofResult = EntityKanaName.of("42");
        Entity actualEntity = new Entity(id, emptyResult, emptyResult1, name, ofResult,
                EntityType.UNKNOWN);

        assertSame(emptyResult1, actualEntity.getAuditInfo());
        assertFalse(actualEntity.isEmpty());
        assertSame(emptyResult, actualEntity.getId());
        assertSame(ofResult, actualEntity.getKanaName());
        assertEquals(EntityType.UNKNOWN, actualEntity.getType());
    }


    /**
     * Method under test: {@link Entity#create(EntityName, EntityKanaName)}
     */
    @Test
    void testCreate2() {
        assertThrows(IllegalArgumentException.class, () -> Entity.create(null, null));
    }

    /**
     * Method under test: {@link Entity#create(EntityName, EntityKanaName)}
     */
    @Test
    void testCreate3() {
        assertThrows(IllegalArgumentException.class, () -> Entity.create(EntityName.empty(), null));
    }

}

