package org.venusPj.projectTemplate.learning.constructor.factoryMethod;

public class AnyClass {

    private final String value;

    private AnyClass(String value) {
        this.value = value;

    }

    static AnyClass createAnyClass(String value) {
        return new AnyClass(value);
    }

    public String getValue() {
        return value;
    }

}
