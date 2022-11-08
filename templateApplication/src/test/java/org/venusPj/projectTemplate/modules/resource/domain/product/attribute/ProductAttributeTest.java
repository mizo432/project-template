package org.venusPj.projectTemplate.modules.resource.domain.product.attribute;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class ProductAttributeTest {

    /**
     * Method under test:
     * {@link ProductAttribute#create(ProductName, ProductCode, StoryCodePrefix)}
     */
    @Test
    void testCreate() {
        // Arrange
        String value = "42";
        ProductName ofResult = ProductName.of(value);
        String value1 = "42";
        ProductCode ofResult1 = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix ofResult2 = StoryCodePrefix.of(value2);

        // Act
        ProductAttribute actualCreateResult = ProductAttribute.create(ofResult, ofResult1,
            ofResult2);

        System.out.println(actualCreateResult);

        // Assert
        ProductCode actualCode = actualCreateResult.getCode();
        assertSame(ofResult1, actualCode);
        StoryCodePrefix actualStoryCodePrefix = actualCreateResult.getStoryCodePrefix();
        assertSame(ofResult2, actualStoryCodePrefix);
        ProductName actualName = actualCreateResult.getName();
        assertSame(ofResult, actualName);
    }
}

