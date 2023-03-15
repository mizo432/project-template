package com.undecided.validator.constraintvalidators;

import static com.undecided.validator.constraintvalidators.ConstraintValidatorsUtils.reportFailedToInitialize;

import com.undecided.validator.constraints.ByteSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.nio.charset.Charset;

public class ByteSizeValidator implements
    ConstraintValidator<ByteSize, CharSequence> {

    /**
     * The charset used in parse to a string.
     */
    private Charset charset;

    /**
     * Byte length must be higher or equal to.
     */
    private long min;

    /**
     * Byte length must be lower or equal to.
     */
    private long max;

    /**
     * Initialize validator.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     * @throws IllegalArgumentException failed to get a charset by name, or min and max are
     *                                  invalid.
     * @see jakarta.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(ByteSize constraintAnnotation) {
        try {
            charset = Charset.forName(constraintAnnotation.charset());
        } catch (IllegalArgumentException e) {
            throw reportFailedToInitialize(e);
        }
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        if (min < 0) {
            throw reportFailedToInitialize(new IllegalArgumentException("min["
                + min + "] must not be negative value."));
        }
        if (max < 0) {
            throw reportFailedToInitialize(new IllegalArgumentException("max["
                + max + "] must not be negative value."));
        }
        if (max < min) {
            throw reportFailedToInitialize(new IllegalArgumentException("max["
                + max + "] must be higher or equal to min[" + min + "]."));
        }
    }

    /**
     * Validate execute.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code true} if {@code value} length is between the specified minimum and maximum, or
     * null. otherwise {@code false}.
     * @see jakarta.validation.ConstraintValidator#isValid(java.lang.Object,
     * jakarta.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(CharSequence value,
        ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        long byteLength = value.toString().getBytes(charset).length;
        return min <= byteLength && byteLength <= max;
    }
}
