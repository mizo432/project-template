package org.venusPj.projectTemplate.shared.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class AuditInfoTest {

    /**
     * Method under test: {@link AuditInfo#reconstruct(LocalDateTime, String)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        int year = 1;
        int month = 1;
        int dayOfMonth = 1;
        int hour = 1;
        int minute = 1;
        LocalDateTime whenNoticed = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String whoNoticed = "Who Noticed";

        // Act
        AuditInfo actualReconstructResult = AuditInfo.reconstruct(whenNoticed, whoNoticed);

        // Assert
        String expectedValue = "Who Noticed";
        WhoNoticed whoNoticed1 = actualReconstructResult.getWhoNoticed();
        String actualValue = whoNoticed1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedToStringResult = "01:01";
        WhenNoticed whenNoticed1 = actualReconstructResult.getWhenNoticed();
        LocalDateTime value = whenNoticed1.getValue();
        LocalTime toLocalTimeResult = value.toLocalTime();
        String actualToStringResult = toLocalTimeResult.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }

    /**
     * Method under test: {@link AuditInfo#of(String)}
     */
    @Test
    void testOf() {
        // Arrange
        String whoNoticed = "Who Noticed";

        // Act
        AuditInfo actualOfResult = AuditInfo.of(whoNoticed);

        // Assert
        String expectedValue = "Who Noticed";
        WhoNoticed whoNoticed1 = actualOfResult.getWhoNoticed();
        String actualValue = whoNoticed1.getValue();
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Method under test: {@link AuditInfo#of(WhoNoticed)}
     */
    @Test
    void testOf2() {
        // Arrange
        String whoNoticed = "Who Noticed";
        WhoNoticed reconstructResult = WhoNoticed.reconstruct(whoNoticed);

        // Act
        AuditInfo actualOfResult = AuditInfo.of(reconstructResult);
        System.out.println("actualOfResult = " + actualOfResult);

        // Assert
        WhoNoticed actualWhoNoticed = actualOfResult.getWhoNoticed();
        assertSame(reconstructResult, actualWhoNoticed);

    }
}

