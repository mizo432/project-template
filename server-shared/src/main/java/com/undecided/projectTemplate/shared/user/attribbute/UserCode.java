package com.undecided.projectTemplate.shared.user.attribbute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import com.undecided.projectTemplate.shared.value.CodeValue;
import lombok.Getter;

@Getter
public class UserCode extends AbstractStringValue implements CodeValue {


    UserCode(String value) {
        super(value);
    }


    public static UserCode of(String value) {
        StringPreconditions.checkNotEmpty(value, "ユーザーコード");
        return new UserCode(value);

    }

    public static UserCode reconstruct(String value) {
        return new UserCode(value);


    }

}
