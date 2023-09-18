package com.undecided.test.size;


import org.junit.jupiter.api.Tag;
import org.junit.platform.commons.annotation.Testable;

import java.lang.annotation.*;

/**
 * 1000ms
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Testable
@Documented
@Tag("MEDIUM")
public @interface MediumTest {
}
