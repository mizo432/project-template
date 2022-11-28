package org.venusPj.projectTemplate.modules.resource.domain.partyRole.user.attribbute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserCodeTest {

    /**
     * Method under test: {@link UserCode#asString()}
     */
    @Test
    void testAsString() {
        // Arrange
        String value = "42";
        UserCode ofResult = UserCode.of(value);

        // Act
        String actualAsStringResult = ofResult.asString();

        // Assert
        String expectedAsStringResult = "42";
        assertEquals(expectedAsStringResult, actualAsStringResult);
    }

    /**
     * Method under test: {@link UserCode#of(String)}
     */
    @Test
    void testOf() {
        // Arrange
        String value = "42";

        // Act
        UserCode actualOfResult = UserCode.of(value);

        // Assert
        String expectedValue = "42";
        String actualValue = actualOfResult.getValue();
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Method under test: {@link UserCode#of(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOf2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Argument for @NotNull parameter 'reference' of org/venusPj/projectTemplate/shared/precondition/string/StringPreconditions.checkNotEmpty must not be null
        //       at org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.$$$reportNull$$$0(StringPreconditions.java)
        //       at org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkNotEmpty(StringPreconditions.java)
        //       at org.venusPj.projectTemplate.modules.resource.domain.partyRole.user.attribbute.UserCode.of(UserCode.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        String value = null;

        // Act
        UserCode.of(value);
    }

    /**
     * Method under test: {@link UserCode#of(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOf3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: ユーザーコードが空白です。ユーザーコードに空白は許容されません。
        //       at org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkNotEmpty(StringPreconditions.java:21)
        //       at org.venusPj.projectTemplate.modules.resource.domain.partyRole.user.attribbute.UserCode.of(UserCode.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        String value = "";

        // Act
        UserCode.of(value);
    }

    /**
     * Method under test: {@link UserCode#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String value = "42";

        // Act
        UserCode actualReconstructResult = UserCode.reconstruct(value);

        // Assert
        String expectedValue = "42";
        String actualValue = actualReconstructResult.getValue();
        assertEquals(expectedValue, actualValue);
    }
}

