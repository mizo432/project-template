package template.shared.user.attribbute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;
import template.shared.value.CodeValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
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
