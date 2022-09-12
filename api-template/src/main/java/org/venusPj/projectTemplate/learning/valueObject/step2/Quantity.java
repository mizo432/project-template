package org.venusPj.projectTemplate.learning.valueObject.step2;

public class Quantity {

    public Long asLong() {
        return quantity;
    }

    private final Long quantity;

    public Quantity(Long quantity) {
        this.quantity = quantity;
    }
}