package com.undecided.validator.constraintvalidators;

import static com.undecided.validator.constraintvalidators.ConstraintValidatorsUtils.reportFailedToInitialize;

import com.undecided.validator.constraints.ByteMin;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.nio.charset.Charset;

public class ByteMinValidator implements
    ConstraintValidator<ByteMin, CharSequence> {

    /**
     * The charset used in parse to a string.
     */
    private Charset charset;

    /**
     * Byte length must be higher or equal to.
     */
    private long min;

    /**
     * Initialize validator.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     * @throws IllegalArgumentException failed to get a charset by name, or value is invalid.
     * @see jakarta.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(ByteMin constraintAnnotation) {
        try {
            charset = Charset.forName(constraintAnnotation.charset());
        } catch (IllegalArgumentException e) {
            throw reportFailedToInitialize(e);
        }
        min = constraintAnnotation.value();
        if (min < 0) {
            throw reportFailedToInitialize(new IllegalArgumentException("value["
                + min + "] must not be negative value."));
        }
    }

    /**
     * Validate execute.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code true} if {@code value} is higher or equal to, or null. otherwise
     * {@code false}.
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
        return min <= byteLength;
    }
}
