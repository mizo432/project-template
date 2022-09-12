package org.venusPj.projectTemplate.learning.valueObject.step2;

public class SourceClass {

    private final Long price;
    private final Quantity quantity;

    public SourceClass(Long quantity, Long price) {
        this.quantity = new Quantity(quantity);
        this.price = price;
    }

    public Long amount() {
        return getPrice() * quantity.asLong();
    }

    private Long getPrice() {
        return price;
    }


}
