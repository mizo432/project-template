package org.venusPj.projectTemplate.modules.resource.domain.story;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.modules.resource.domain.product.ProductId;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.StoryAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.StoryStatus;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.StoryType;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.WhenNoticed;
import org.venusPj.projectTemplate.shared.entity.WhoNoticed;

class StoryTest {

    /**
     * Method under test:
     * {@link Story#reconstruct(String, LocalDateTime, String, String, StoryAttribute)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String storyId = "42";
        int year = 1;
        int month = 1;
        int dayOfMonth = 1;
        int hour = 1;
        int minute = 1;
        LocalDateTime whenNoticed = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String whoNoticed = "Who Noticed";
        String productId = "42";
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.ユーザーストーリー;
        StoryStatus status = StoryStatus.凍結;
        StoryAttribute reconstructResult = StoryAttribute.reconstruct(code, name, description, type,
            status);

        // Act
        Story actualReconstructResult = Story.reconstruct(storyId, whenNoticed, whoNoticed,
            productId, reconstructResult);

        // Assert
        StoryAttribute actualAttribute = actualReconstructResult.getAttribute();
        assertSame(reconstructResult, actualAttribute);
        String expectedValue = "42";
        StoryId id = actualReconstructResult.getId();
        String actualValue = id.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        ProductId productId1 = actualReconstructResult.getProductId();
        String actualValue1 = productId1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Who Noticed";
        AuditInfo auditInfo = actualReconstructResult.getAuditInfo();
        WhoNoticed whoNoticed1 = auditInfo.getWhoNoticed();
        String actualValue2 = whoNoticed1.getValue();
        assertEquals(expectedValue2, actualValue2);
        String expectedToStringResult = "0001-01-01";
        WhenNoticed whenNoticed1 = auditInfo.getWhenNoticed();
        LocalDateTime value = whenNoticed1.getValue();
        LocalDate toLocalDateResult = value.toLocalDate();
        String actualToStringResult = toLocalDateResult.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }

    /**
     * Method under test:
     * {@link Story#reconstruct(String, LocalDateTime, String, String, StoryAttribute)}
     */
    @Test
    void testReconstruct2() {
        // Arrange
        String storyId = "foo";
        int year = 1;
        int month = 1;
        int dayOfMonth = 1;
        int hour = 1;
        int minute = 1;
        LocalDateTime whenNoticed = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String whoNoticed = "foo";
        String productId = "foo";
        StoryAttribute attribute = null;

        // Act and Assert
        assertThrows(NullPointerException.class,
            () -> Story.reconstruct(storyId, whenNoticed, whoNoticed, productId, attribute));
    }

    /**
     * Method under test:
     * {@link Story#reconstruct(String, LocalDateTime, String, String, StoryAttribute)}
     */
    @Test
    void testReconstruct3() {
        // Arrange
        String storyId = "Story Id";
        int year = 1;
        int month = 1;
        int dayOfMonth = 1;
        int hour = 1;
        int minute = 1;
        LocalDateTime whenNoticed = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String whoNoticed = "Who Noticed";
        String productId = "42";
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.ユーザーストーリー;
        StoryStatus status = StoryStatus.凍結;
        StoryAttribute reconstructResult = StoryAttribute.reconstruct(code, name, description, type,
            status);

        // Act
        Story actualReconstructResult = Story.reconstruct(storyId, whenNoticed, whoNoticed,
            productId, reconstructResult);

        System.out.println(actualReconstructResult);

        // Assert
        StoryAttribute actualAttribute = actualReconstructResult.getAttribute();
        assertSame(reconstructResult, actualAttribute);
        String expectedValue = "Story Id";
        StoryId id = actualReconstructResult.getId();
        String actualValue = id.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        ProductId productId1 = actualReconstructResult.getProductId();
        String actualValue1 = productId1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Who Noticed";
        AuditInfo auditInfo = actualReconstructResult.getAuditInfo();
        WhoNoticed whoNoticed1 = auditInfo.getWhoNoticed();
        String actualValue2 = whoNoticed1.getValue();
        assertEquals(expectedValue2, actualValue2);
        String expectedToStringResult = "0001-01-01";
        WhenNoticed whenNoticed1 = auditInfo.getWhenNoticed();
        LocalDateTime value = whenNoticed1.getValue();
        LocalDate toLocalDateResult = value.toLocalDate();
        String actualToStringResult = toLocalDateResult.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }

    /**
     * Method under test:
     * {@link Story#reconstruct(String, LocalDateTime, String, String, StoryAttribute)}
     */
    @Test
    void testReconstruct4() {
        // Arrange
        String storyId = "42";
        int year = 1;
        int month = 1;
        int dayOfMonth = 1;
        int hour = 1;
        int minute = 1;
        LocalDateTime whenNoticed = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String whoNoticed = null;
        String productId = "42";
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.ユーザーストーリー;
        StoryStatus status = StoryStatus.凍結;
        StoryAttribute reconstructResult = StoryAttribute.reconstruct(code, name, description, type,
            status);

        // Act
        Story actualReconstructResult = Story.reconstruct(storyId, whenNoticed, whoNoticed,
            productId, reconstructResult);

        // Assert
        StoryAttribute actualAttribute = actualReconstructResult.getAttribute();
        assertSame(reconstructResult, actualAttribute);
        String expectedValue = "42";
        StoryId id = actualReconstructResult.getId();
        String actualValue = id.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        ProductId productId1 = actualReconstructResult.getProductId();
        String actualValue1 = productId1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedToStringResult = "0001-01-01";
        AuditInfo auditInfo = actualReconstructResult.getAuditInfo();
        WhenNoticed whenNoticed1 = auditInfo.getWhenNoticed();
        LocalDateTime value = whenNoticed1.getValue();
        LocalDate toLocalDateResult = value.toLocalDate();
        String actualToStringResult = toLocalDateResult.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }
}

