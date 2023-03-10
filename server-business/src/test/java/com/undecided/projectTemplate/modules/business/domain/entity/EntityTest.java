package com.undecided.projectTemplate.modules.business.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
import org.junit.jupiter.api.Test;

class EntityTest {

    /**
     * Method under test:
     * {@link Entity#Entity(Identifier, Identifier, AuditInfo, EntityName, EntityKanaName,
     * EntityType)}
     */
    @Test
    void testConstructor8() {
        Identifier<Entity> id = Identifier.empty();
        Identifier<Project> emptyResult = Identifier.empty();
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

