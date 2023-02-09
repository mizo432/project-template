package com.undecided.validator.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.undecided.validator.constraints.ByteMax.List;
import com.undecided.validator.constraintvalidators.ByteMaxValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {ByteMaxValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface ByteMax {

    /**
     * Error message or message key
     *
     * @return error message or message key
     */
    String message() default "{com.undecided.validator.constraints.ByteMax.message}";

    /**
     * Constraint groups
     *
     * @return constraint groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload
     *
     * @return payload
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * @return value the element's byte length must be lower or equal to
     */
    long value();

    /**
     * @return the charset name used in parse to a string
     */
    String charset() default "UTF-8";

    /**
     * Defines several {@link ByteMax} annotations on the same element.
     *
     * @see ByteMax
     */
    @Documented
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER,
        TYPE_USE})
    @Retention(RUNTIME)
    @interface List {

        /**
         * <code>@ByteMax</code> annotations
         *
         * @return annotations
         */
        ByteMax[] value();
    }

}
