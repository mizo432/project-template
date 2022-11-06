package org.venusPj.projectTemplate.modules.tenant.domain.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TenantIdTest {

    /**
     * Method under test: {@link TenantId#of(String)}
     */
    @Nested
    class of {

        @Test
        void _引数に42を設定すると値が42になる() {
            // Arrange
            String value = "42";

            // Act
            TenantId actualOfResult = TenantId.of(value);

            // Assert
            String expectedValue = "42";
            String actualValue = actualOfResult.getValue();
            assertEquals(expectedValue, actualValue);
        }

        @Test
        void _引数にnullを設定するとIllegalArgumentExceptionを投げる() {
            // Arrange
            String value = null;

            // Act and Assert
            assertThrows(NullPointerException.class, () -> TenantId.of(value));
        }

    }

    /**
     * Method under test: {@link TenantId#canEqual(Object)}
     */
    @Nested
    class canEqual {

        @Test
        void testCanEqual() {
            // Arrange
            String value = "42";
            TenantId tenantId = new TenantId(value);
            String other = "Other";

            // Act
            boolean actualCanEqualResult = tenantId.canEqual(other);

            // Assert
            boolean expectedCanEqualResult = false;
            assertEquals(expectedCanEqualResult, actualCanEqualResult);
        }

        @Test
        void testCanEqual2() {
            // Arrange
            String value = "42";
            TenantId tenantId = new TenantId(value);
            String value1 = "42";
            TenantId other = new TenantId(value1);

            // Act
            boolean actualCanEqualResult = tenantId.canEqual(other);

            // Assert
            boolean expectedCanEqualResult = true;
            assertEquals(expectedCanEqualResult, actualCanEqualResult);
        }

    }


    /**
     * Method under test: {@link TenantId#newInstance()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewInstance() {
        TenantId actualNewInstanceResult = TenantId.newInstance();

        System.out.println(actualNewInstanceResult);
        System.out.println(TenantId.newInstance());
        System.out.println(TenantId.newInstance());

        // Assert
        assertFalse(actualNewInstanceResult.isEmpty());

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TenantId#TenantId(String)}
     *   <li>{@link TenantId#toString()}
     *   <li>{@link TenantId#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange
        String value = "42";

        // Act
        TenantId actualTenantId = new TenantId(value);
        String actualToStringResult = actualTenantId.toString();

        // Assert
        String expectedValue = "42";
        String actualValue = actualTenantId.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedToStringResult = "TenantId(value=42)";
        assertEquals(expectedToStringResult, actualToStringResult);
    }
}

