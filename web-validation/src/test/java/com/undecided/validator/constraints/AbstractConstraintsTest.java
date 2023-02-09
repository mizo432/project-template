package com.undecided.validator.constraints;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import java.util.Locale;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;

abstract class AbstractConstraintsTest<F> {

    protected static final String MESSAGE_NOT_SUPPORT_ERROR = "validator does not support this type: %s";

    protected static final String MESSAGE_INITIALIZE_ERROR = "failed to initialize validator by invalid argument";

    protected static Validator validator;

    protected F form;

    protected Set<ConstraintViolation<F>> violations;

    @BeforeAll
    public static void beforeClass() {
        Locale.setDefault(Locale.ENGLISH);
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * assertion for failed to initialize.
     *
     * @param ex        validation exception.
     * @param causeType expected type of inner exception.
     */
    protected void assertFailedToInitialize(ValidationException ex,
        Class<? extends Throwable> causeType) {
        assertThatThrownBy(() -> {
            throw ex;
        }).cause().isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MESSAGE_INITIALIZE_ERROR)
            .cause().isInstanceOf(causeType);

    }

    /**
     * assertion for failed to initialize.
     *
     * @param ex        validation exception.
     * @param causeType expected type of inner exception.
     * @param message   expected message of inner exception.
     */
    protected void assertFailedToInitialize(ValidationException ex,
        Class<? extends Throwable> causeType, String message) {
        assertThatThrownBy(() -> {
            throw ex;
        }).cause().isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MESSAGE_INITIALIZE_ERROR)
            .cause().isInstanceOf(causeType).hasMessage(message);

    }

    /**
     * assertion for type not support.
     *
     * @param ex   validation exception.
     * @param type expected not support type.
     */
    protected void assertTypeNotSupport(ValidationException ex, Class<?> type) {
        assertThatThrownBy(() -> {
            throw ex;
        }).cause().isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format(MESSAGE_NOT_SUPPORT_ERROR, type.getName()));
    }
}
