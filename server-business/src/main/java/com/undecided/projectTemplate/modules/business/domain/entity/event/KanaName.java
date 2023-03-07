package com.undecided.projectTemplate.modules.business.domain.entity.event;

import com.undecided.projectTemplate.shared.value.StringValue;

public class KanaName implements StringValue<KanaName> {

    private final String value;

    KanaName(String value) {
        this.value = value;
    }

    public static KanaName of(String value) {
        return new KanaName(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }
    
}
