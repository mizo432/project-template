package org.venusPj.projectTemplate.shared.precondition.collection;

import static com.tngtech.archunit.thirdparty.com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Range;
import org.venusPj.projectTemplate.shared.test.TestSize;

@Tag(TestSize.SMALL)
class CollectionPreconditionsTest {

    /**
     * Method under test: {@link CollectionPreconditions#checkAllItemPresent(Collection)}
     */
    @Test
    void testCheckAllItemPresent() {
        // Arrange
        Collection<Object> referenceCollection = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkAllItemPresent(referenceCollection));
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkAllItemPresent(Collection)}
     */
    @Test
    void testCheckAllItemPresent2() {
        // Arrange
        ArrayList<Object> objectList = newArrayList();
        Object e = null;
        objectList.add(e);

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkAllItemPresent(objectList));
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkSize(Collection, Range)}
     */
    @Test
    void testCheckSize() {
        // Arrange
        ArrayList<Object> referenceCollection = new ArrayList<>();
        Range<Integer> sizeRange = Range.closed(Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkSize(referenceCollection, sizeRange));
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkSize(Collection, Range)}
     */
    @Test
    void testCheckSize2() {
        // Arrange
        Collection<Object> referenceCollection = null;
        Range<Integer> sizeRange = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkSize(referenceCollection, sizeRange));
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkSize(Collection, Range)}
     */
    @Test
    void testCheckSize3() {
        // Arrange
        ArrayList<Object> referenceCollection = new ArrayList<>();
        Range<Integer> sizeRange = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkSize(referenceCollection, sizeRange));
    }

}

