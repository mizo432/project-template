package com.undecided.projectTemplate.modules.teamMember.domain.member;

import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class MemberInitial extends AbstractValue<String> implements StringValue<MemberInitial> {

    private final String value;

    public static MemberInitial reconstruct(String value) {
        return MemberInitial.reconstruct(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }

    public static MemberInitial of(String value) {
        return new MemberInitial(value);
        
    }


}
