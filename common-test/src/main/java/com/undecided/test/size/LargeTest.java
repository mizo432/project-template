package com.undecided.test.size;

import org.junit.platform.commons.annotation.Testable;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Testable
@Documented
public @interface LargeTest {
}
