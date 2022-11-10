package org.venusPj.projectTemplate.shared.precondition.array;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class ArrayPreconditionsTest {

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty() {
        ArrayPreconditions.checkNotEmpty(new Object[]{"Reference Array"});
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty2() {
        assertThrows(IllegalArgumentException.class, () ->
            ArrayPreconditions.checkNotEmpty(null));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty3() {
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkNotEmpty(new Object[]{}));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[], Supplier)}
     */
    @Test
    void testCheckNotEmpty4() {
        ArrayPreconditions.checkNotEmpty(new Object[]{"Reference Array"},
            (Supplier<RuntimeException>) mock(Supplier.class));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[], Supplier)}
     */
    @Test
    void testCheckNotEmpty5() {
        ArrayPreconditions.checkNotEmpty(null, (Supplier<RuntimeException>) mock(Supplier.class));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[], Supplier)}
     */
    @Test
    void testCheckNotEmpty6() {
        Supplier<RuntimeException> supplier = (Supplier<RuntimeException>) mock(Supplier.class);
        when(supplier.get()).thenReturn(new RuntimeException());
        ArrayPreconditions.checkNotEmpty(new Object[]{}, supplier);
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[], Supplier)}
     */
    @Test
    void testCheckNotEmpty7() {
        Supplier<RuntimeException> supplier = (Supplier<RuntimeException>) mock(Supplier.class);
        when(supplier.get()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class,
            () -> ArrayPreconditions.checkNotEmpty(new Object[]{}, supplier));
        verify(supplier).get();
    }
}

