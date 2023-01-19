package com.undecided.projectTemplate.modules.resource.domain.partyRole.user.attribbute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.CodeValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserCode implements CodeValue<UserCode> {

    private final String value;


    @Override
    public String asString() {
        return value;
    }

    public static UserCode of(String value) {
        StringPreconditions.checkNotEmpty(value, "ユーザーコード");
        return new UserCode(value);

    }

    public static UserCode reconstruct(String value) {
        return new UserCode(value);


    }

}
