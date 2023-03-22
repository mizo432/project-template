package com.undecided.projectTemplate.teamMember.domain.member;

import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class MemberName extends AbstractValue<String> implements StringValue<MemberName> {

    private final String value;

    public static MemberName reconstruct(String value) {
        return new MemberName(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }

    public static MemberName of(String value) {
        return new MemberName(value);
    }
}
