package com.undecided.projectTemplate.teamMember.domain.member;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class MemberName extends AbstractStringValue {


    MemberName(String value) {
        super(value);
    }

    public static MemberName reconstruct(String value) {
        return new MemberName(value);
    }

    public static MemberName of(String value) {
        return new MemberName(value);
    }
}
