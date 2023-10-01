package com.undecided.gfw.common.exception;

import com.undecided.test.size.SmallTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemExceptionTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SystemException#SystemException(String, String)}
     *   <li>{@link SystemException#getCode()}
     * </ul>
     */
    @SmallTest
    void testConstructor() {
        assertEquals("Code", (new SystemException("Code", "An error occurred")).getCode());
        assertEquals("Code",
                (new SystemException("Code", "An error occurred", new Throwable())).getCode());
        assertEquals("Code", (new SystemException("Code", new Throwable())).getCode());
    }
}

