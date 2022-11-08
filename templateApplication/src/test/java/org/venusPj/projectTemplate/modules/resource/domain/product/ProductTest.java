package org.venusPj.projectTemplate.modules.resource.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.modules.resource.domain.product.attribute.ProductAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.product.attribute.ProductCode;
import org.venusPj.projectTemplate.modules.resource.domain.product.attribute.ProductName;
import org.venusPj.projectTemplate.modules.resource.domain.product.attribute.StoryCodePrefix;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.WhenNoticed;
import org.venusPj.projectTemplate.shared.entity.WhoNoticed;

class ProductTest {

    /**
     * Method under test: {@link Product#Product(ProductId, AuditInfo, ProductAttribute)}
     */
    @Test
    void testConstructor() {
        // Arrange
        ProductId newInstanceResult = ProductId.newInstance();
        AuditInfo emptyResult = AuditInfo.empty();
        String value = "42";
        ProductName ofResult = ProductName.of(value);
        String value1 = "42";
        ProductCode ofResult1 = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix ofResult2 = StoryCodePrefix.of(value2);
        ProductAttribute createResult = ProductAttribute.create(ofResult, ofResult1, ofResult2);

        // Act
        Product actualProduct = new Product(newInstanceResult, emptyResult, createResult);

        System.out.println(actualProduct);

        // Assert
        ProductAttribute attribute = actualProduct.getAttribute();
        assertSame(createResult, attribute);
        ProductId actualId = actualProduct.getId();
        assertSame(newInstanceResult, actualId);
        AuditInfo auditInfo = actualProduct.getAuditInfo();
        assertSame(emptyResult, auditInfo);
        StoryCodePrefix storyCodePrefix = attribute.getStoryCodePrefix();
        assertSame(ofResult2, storyCodePrefix);
        ProductName name = attribute.getName();
        assertSame(ofResult, name);
        ProductCode code = attribute.getCode();
        assertSame(ofResult1, code);
        String expectedValue = "42";
        String actualValue = name.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        String actualValue1 = code.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = null;
        WhoNoticed whoNoticed = auditInfo.getWhoNoticed();
        String actualValue2 = whoNoticed.getValue();
        assertEquals(expectedValue2, actualValue2);
        String expectedValue3 = "42";
        String actualValue3 = storyCodePrefix.getValue();
        assertEquals(expectedValue3, actualValue3);
        LocalDateTime expectedValue4 = null;
        WhenNoticed whenNoticed = auditInfo.getWhenNoticed();
        LocalDateTime actualValue4 = whenNoticed.getValue();
        assertEquals(expectedValue4, actualValue4);
    }

    /**
     * Method under test: {@link Product#create(Product)}
     */
    @Test
    void testCreate() {
        // Arrange
        String value = "42";
        ProductName name = ProductName.of(value);
        String value1 = "42";
        ProductCode code = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProductAttribute createResult = ProductAttribute.create(name, code, storyCodePrefix);
        Product product = Product.create(createResult);
        Product product1 = Product.create(product);
        Product product2 = Product.create(product1);
        Product product3 = Product.create(product2);
        Product product4 = Product.create(product3);
        Product product5 = Product.create(product4);

        // Act
        Product actualCreateResult = Product.create(product5);

        // Assert
        ProductAttribute actualAttribute = actualCreateResult.getAttribute();
        assertSame(createResult, actualAttribute);
    }

    /**
     * Method under test: {@link Product#create(ProductAttribute)}
     */
    @Test
    void testCreate3() {
        // Arrange
        String value = "42";
        ProductName name = ProductName.of(value);
        String value1 = "42";
        ProductCode code = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProductAttribute createResult = ProductAttribute.create(name, code, storyCodePrefix);

        // Act
        Product actualCreateResult = Product.create(createResult);

        // Assert
        ProductAttribute actualAttribute = actualCreateResult.getAttribute();
        assertSame(createResult, actualAttribute);
    }

    /**
     * Method under test: {@link Product#sameValueAs(Product)}
     */
    @Test
    void testSameValueAs() {
        // Arrange
        String value = "42";
        ProductName name = ProductName.of(value);
        String value1 = "42";
        ProductCode code = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProductAttribute attribute = ProductAttribute.create(name, code, storyCodePrefix);
        Product product = Product.create(attribute);
        Product product1 = Product.create(product);
        Product product2 = Product.create(product1);
        Product product3 = Product.create(product2);
        Product createResult = Product.create(product3);
        Product other = null;

        // Act
        boolean actualSameValueAsResult = createResult.sameValueAs(other);

        // Assert
        boolean expectedSameValueAsResult = false;
        assertEquals(expectedSameValueAsResult, actualSameValueAsResult);
    }

    /**
     * Method under test: {@link Product#sameValueAs(Product)}
     */
    @Test
    void testSameValueAs2() {
        // Arrange
        String value = "42";
        ProductName name = ProductName.of(value);
        String value1 = "42";
        ProductCode code = ProductCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProductAttribute attribute = ProductAttribute.create(name, code, storyCodePrefix);
        Product product = Product.create(attribute);
        Product product1 = Product.create(product);
        Product product2 = Product.create(product1);
        Product product3 = Product.create(product2);
        Product createResult = Product.create(product3);
        String value3 = "42";
        ProductName name1 = ProductName.of(value3);
        String value4 = "42";
        ProductCode code1 = ProductCode.of(value4);
        String value5 = "42";
        StoryCodePrefix storyCodePrefix1 = StoryCodePrefix.of(value5);
        ProductAttribute attribute1 = ProductAttribute.create(name1, code1, storyCodePrefix1);
        Product other = Product.create(attribute1);

        // Act
        boolean actualSameValueAsResult = createResult.sameValueAs(other);

        // Assert
        boolean expectedSameValueAsResult = false;
        assertEquals(expectedSameValueAsResult, actualSameValueAsResult);
    }
}

