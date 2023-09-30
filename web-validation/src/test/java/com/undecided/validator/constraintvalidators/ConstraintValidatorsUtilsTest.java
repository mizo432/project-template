package com.undecided.validator.constraintvalidators;

import com.undecided.test.size.SmallTest;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstraintValidatorsUtilsTest {

    @SmallTest
    public void testConstraintValidatorsUtils() throws Exception {
        // set up
        Constructor<ConstraintValidatorsUtils> constructor = ConstraintValidatorsUtils.class
                .getDeclaredConstructor();
        constructor.setAccessible(true);
        // assert
        assertThat(constructor.newInstance())
                .isNotNull();

    }

    @SmallTest
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

    @SmallTest
    public void testGetPropertyValueBeanNull() throws Exception {
        // test
        Object o = ConstraintValidatorsUtils.getPropertyValue(null, "bar");

        // assert
        assertThat(o)
                .isNull();
    }

    @SmallTest
    public void testGetPropertyValuePropertyNameNull() throws Exception {
        // test
        Object o = ConstraintValidatorsUtils.getPropertyValue(new FooBean(),
                null);

        // assert
        assertThat(o).isNull();
    }

    @SmallTest
    public void testIsEmptyValueNull() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty(null);

        // assert
        assertThat(b)
                .isNotNull();
    }

    @SmallTest
    public void testIsEmptyValueBlank() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty("");

        // assert
        assertThat(b).isTrue();
    }

    @SmallTest
    public void testIsEmptyValueNotNull() throws Exception {
        // test
        boolean b = ConstraintValidatorsUtils.isEmpty("test");

        // assert
        assertThat(b).isFalse();
    }

    static class FooBean {

        private String bar;

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

    }
}
