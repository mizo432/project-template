package org.venusPj.projectTemplate.learning.valueObject.step1;

public class SourceClass {

    private final Long quantity;

    private final Long price;

    public SourceClass(Long quantity, Long price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Long amount() {
        return price * quantity;
    }

}
