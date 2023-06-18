package template.modules.project.domain.model.member;

import lombok.Getter;
import template.shared.value.AbstractStringValue;

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
