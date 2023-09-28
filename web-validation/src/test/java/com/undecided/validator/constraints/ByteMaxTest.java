package com.undecided.validator.constraints;

import com.undecided.test.size.SmallTest;
import com.undecided.validator.constraints.ByteMaxTest.ByteMaxTestForm;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ByteMaxTest extends AbstractConstraintsTest<ByteMaxTestForm> {

    private static final String MESSAGE_VALIDATION_ERROR = "must be less than or equal to %d bytes";

    @BeforeEach
    public void before() {
        form = new ByteMaxTestForm();
    }

    /**
     * input null value. expected valid.
     */
    @SmallTest
    public void testInputNull() {

        violations = validator.validate(form);

        assertThat(violations).isEmpty();
    }

    /**
     * specify max value. expected valid if input value encoded in UTF-8 is grater than or equal max
     * value.
     */
    @SmallTest
    public void testSpecifyMaxValue() {

        {
            form.setStringProperty("ああa");
            violations = validator.validate(form);
//            assertThat(violations).containsAnyElementsOf(new Const), containsInAnyOrder(hasProperty("message", is(
//                String.format(MESSAGE_VALIDATION_ERROR, 6)))));
        }

        {
            form.setStringProperty("ああ");

            violations = validator.validate(form);
            assertThat(violations)
                    .isEmpty();
        }
    }

    /**
     * Validation group encoding shift-jis.
     */
    private interface SpecifyCharset {

    }

    /**
     * Validation group encoding unsupported.
     */
    private interface IllegalCharset {

    }

    ;

    /**
     * Validation group value negative.
     */
    private interface NegativeValue {

    }

    ;

    /**
     * Validation group unexpected type.
     */
    private interface UnexpectedType {

    }

    ;

    public static class ByteMaxTestForm {

        @ByteMax(6)
        @ByteMax(value = 6, charset = "shift-jis", groups = {
                SpecifyCharset.class})
        @ByteMax(value = 6, charset = "illegal-charset", groups = {
                IllegalCharset.class})
        @ByteMax(value = -1, groups = {NegativeValue.class})
        private String stringProperty;

        @ByteMax(6)
        private StringBuilder stringBuilderProperty;

        @ByteMax(value = 6, groups = {UnexpectedType.class})
        private Integer intProperty;

        private List<@ByteMax(6) String> listProperty;

        public String getStringProperty() {
            return stringProperty;
        }

        public void setStringProperty(String stringProperty) {
            this.stringProperty = stringProperty;
        }

        public StringBuilder getStringBuilderProperty() {
            return stringBuilderProperty;
        }

        public void setStringBuilderProperty(
                StringBuilder stringBuilderProperty) {
            this.stringBuilderProperty = stringBuilderProperty;
        }

        public Integer getIntProperty() {
            return intProperty;
        }

        public void setIntProperty(Integer intProperty) {
            this.intProperty = intProperty;
        }

        public List<String> getListProperty() {
            return listProperty;
        }

        public void setListProperty(List<String> listProperty) {
            this.listProperty = listProperty;
        }
    }
}
