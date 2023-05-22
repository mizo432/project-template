package com.undecided.projectTemplate.modules.teamMember.domain.member;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class MemberInitial extends AbstractStringValue {

    MemberInitial(String value) {
        super(value);
    }

    public static MemberInitial reconstruct(String value) {
        return new MemberInitial(value);
    }

    public static MemberInitial of(String value) {
        return new MemberInitial(value);

    }


}
