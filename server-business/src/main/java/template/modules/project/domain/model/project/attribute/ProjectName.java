package template.modules.project.domain.model.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class ProjectName extends AbstractStringValue {

    private static final ProjectName EMPTY = new ProjectName(Strings2.EMPTY);

    public ProjectName(String value) {
        super(value);

    }


    public static ProjectName empty() {
        return EMPTY;
    }

    public static ProjectName of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクト名");
        return new ProjectName(value);

    }

    public static ProjectName reconstruct(String value) {
        if (Strings2.isEmpty(value))
            return EMPTY;
        return new ProjectName(value);


    }
}
