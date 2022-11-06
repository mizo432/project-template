package org.venusPj.projectTemplate.modules.resource.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {

    /**
     * Method under test: {@link Product#create(String, String)}
     */
    @Test
    void testCreate() {
        // Arrange
        String name = "Name";
        String storyCodePrefix = "Story Code Prefix";

        // Act
        Product actualCreateResult = Product.create(name, storyCodePrefix);
        System.out.println(actualCreateResult);

        // Assert
        String expectedValue = "Name";
        ProductName name1 = actualCreateResult.getName();
        String actualValue = name1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "Story Code Prefix";
        StoryCodePrefix storyCodePrefix1 = actualCreateResult.getStoryCodePrefix();
        String actualValue1 = storyCodePrefix1.getValue();
        assertEquals(expectedValue1, actualValue1);
    }

    /**
     * Method under test: {@link Product#create(String, String)}
     */
    @Test
    void testCreate2() {
        // Arrange
        String name = "foo";
        String storyCodePrefix = "foo";

        // Act
        Product actualCreateResult = Product.create(name, storyCodePrefix);

        // Assert
        String expectedValue = "foo";
        ProductName name1 = actualCreateResult.getName();
        String actualValue = name1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "foo";
        StoryCodePrefix storyCodePrefix1 = actualCreateResult.getStoryCodePrefix();
        String actualValue1 = storyCodePrefix1.getValue();
        assertEquals(expectedValue1, actualValue1);
    }

}

