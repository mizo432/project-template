package com.undecided.validator.constraintvalidators;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class ConstraintValidatorsUtils {

    /**
     * Default constructor
     */
    private ConstraintValidatorsUtils() {
        // do nothing for Default constructor
    }

    /**
     * Wrap the exception in {@link IllegalArgumentException} with initialize error messages.
     *
     * @param cause caused throwable
     * @return wrapped exception
     */
    static IllegalArgumentException reportFailedToInitialize(Throwable cause) {
        return new IllegalArgumentException("failed to initialize validator by invalid argument",
            cause);
    }

    /**
     * Wrap the exception in {@link IllegalArgumentException} with unexpected type messages.
     *
     * @param value validation target value
     * @return wrapped exception
     */
    static IllegalArgumentException reportUnexpectedType(Object value) {
        return new IllegalArgumentException(String.format(
            "validator does not support this type: %s", value.getClass()
                .getName()));
    }

    /**
     * Check string is null or empty.
     *
     * @param value string to check
     * @return {@code true} if string is null or empty. otherwise {@code false}.
     */
    static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    /**
     * Get property value in bean by name.
     *
     * @param bean         bean which holds a specified property
     * @param propertyName property name
     * @return property value. if failed to get, return null.
     */
    static Object getPropertyValue(Object bean, String propertyName) {
        if (bean == null || isEmpty(propertyName)) {
            return null;
        }

        try {
            PropertyDescriptor property = new PropertyDescriptor(propertyName, bean
                .getClass());
            Method getter = property.getReadMethod();
            return getter.invoke(bean);
        } catch (Exception e) {
            throw reportFailedToInitialize(e);
        }
    }
}
