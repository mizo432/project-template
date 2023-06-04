package com.undecided.validator.constraintvalidators;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstraintValidatorsUtilsTest {

    @Test
    public void testConstraintValidatorsUtils() throws Exception {
        // set up
        Constructor<ConstraintValidatorsUtils> constructor = ConstraintValidatorsUtils.class
                .getDeclaredConstructor();
        constructor.setAccessible(true);
        // assert
        assertThat(constructor.newInstance())
                .isNotNull();

    }

    @Test
    public void testGetPropertyValueBeanAndPropertyNameNotNull() throws Exception {
        // set up
        FooBean foo = new FooBean();
        foo.setBar("test");

        // test
        Object o = ConstraintValidatorsUtils.getPropertyValue(foo, "bar");

        // assert
        assertThat(o)
                .isNotNull();
    }

    @Test
    public void testGetPropertyValueBeanNull() throws Exception {
        // test
        Object o = ConstraintValidatorsUtils.getPropertyValue(null, "bar");

        // assert
        assertThat(o)
                .isNull();
    }

    @Test
    public void testGetPropertyValuePropertyNameNull() throws Exception {
        // test
        Object o = ConstraintValidatorsUtils.getPropertyValue(new FooBean(),
                null);

        // assert
        assertThat(o).isNull();
    }

    @Test
    public void testIsEmptyValueNull() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty(null);

        // assert
        assertThat(b)
                .isNotNull();
    }

    @Test
    public void testIsEmptyValueBlank() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty("");

        // assert
        assertThat(b).isTrue();
    }

    @Test
    public void testIsEmptyValueNotNull() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty("test");

        // assert
        assertThat(b).isFalse();
    }

    class FooBean {

        private String bar;

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

    }
}
