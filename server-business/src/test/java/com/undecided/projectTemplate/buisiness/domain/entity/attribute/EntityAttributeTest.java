package com.undecided.projectTemplate.buisiness.domain.entity.attribute;

import com.undecided.projectTemplate.modules.product.domain.model.business.entity.attribute.EntityAttribute;
import com.undecided.projectTemplate.modules.product.domain.model.business.entity.attribute.EntityType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EntityAttributeTest {

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.UNKNOWN);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.UNKNOWN, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct2() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("foo", "foo",
                EntityType.UNKNOWN);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.UNKNOWN, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct3() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("", "Kana Name",
                EntityType.UNKNOWN);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.UNKNOWN, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct4() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "",
                EntityType.UNKNOWN);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.UNKNOWN, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct5() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.RESOURCE);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.RESOURCE, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct6() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.EVENT);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.EVENT, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct7() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.MO);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.MO, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct8() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.MA);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.MA, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct9() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.VE);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.VE, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct10() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.HDR);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.HDR, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct11() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.DTL);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.DTL, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct12() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.LAPUTA);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.LAPUTA, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

    /**
     * Method under test: {@link EntityAttribute#reconstruct(String, String, EntityType)}
     */
    @Test
    void testReconstruct13() {
        EntityAttribute actualReconstructResult = EntityAttribute.reconstruct("Name", "Kana Name",
                EntityType.TURBO);
        assertFalse(actualReconstructResult.isEmpty());
        assertEquals(EntityType.TURBO, actualReconstructResult.getType());
        assertFalse(actualReconstructResult.getName().isEmpty());
        assertFalse(actualReconstructResult.getKanaName().isEmpty());
    }

}

