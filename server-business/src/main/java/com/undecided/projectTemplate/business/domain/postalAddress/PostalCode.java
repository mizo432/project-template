package com.undecided.projectTemplate.business.domain.postalAddress;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class PostalCode extends AbstractStringValue {


    PostalCode(String value) {
        super(value);
    }

    public static PostalCode of(String value) {
        return new PostalCode(value);
    }

}
