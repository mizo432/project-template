package template.modules.project.domain.model.member;

import lombok.Getter;
import template.shared.value.AbstractStringValue;

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
