package com.undecided.projectTemplate.business.domain.postalAddress;

import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class PostalCode implements StringValue<PostalCode> {

    private final String value;

    public static PostalCode of(String value) {
        return new PostalCode(value);
    }

    @Override
    public String asString() {
        return value;
    }
}
