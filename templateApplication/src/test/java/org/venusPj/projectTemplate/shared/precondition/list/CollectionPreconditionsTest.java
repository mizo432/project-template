package org.venusPj.projectTemplate.shared.precondition.list;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.shared.precondition.collection.CollectionPreconditions;

class CollectionPreconditionsTest {

    /**
     * Method under test: {@link CollectionPreconditions#checkNotEmpty(Collection, Supplier)}
     */
    @Test
    @SuppressWarnings("unchecked")
    void testCheckNotEmpty3() {

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add("42");
        Supplier<RuntimeException> supplier = (Supplier<RuntimeException>) mock(Supplier.class);
        when(supplier.get()).thenReturn(new RuntimeException());
        CollectionPreconditions.checkNotEmpty(objectList, supplier);
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkNotEmpty(Collection, Supplier)}
     */
    @Test
    @SuppressWarnings("unchecked")
    void testCheckNotEmpty4() {
        ArrayList<Object> referenceCollection = new ArrayList<>();
        Supplier<RuntimeException> supplier = (Supplier<RuntimeException>) mock(Supplier.class);
        when(supplier.get()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class,
            () -> CollectionPreconditions.checkNotEmpty(referenceCollection, supplier));
        verify(supplier).get();
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkNotEmpty(Collection)}
     */
    @Test
    void testCheckNotEmpty5() {
        assertThrows(IllegalArgumentException.class,
            () -> CollectionPreconditions.checkNotEmpty(new ArrayList<>()));
    }

    /**
     * Method under test: {@link CollectionPreconditions#checkNotEmpty(Collection)}
     */
    @Test
    void testCheckNotEmpty7() {
        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add("42");
        CollectionPreconditions.checkNotEmpty(objectList);
    }
}

