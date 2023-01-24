package com.undecided.projectTemplate.modules.resource.domain.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.StringValue;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProjectName implements StringValue<ProjectName>, Serializable {

    private static final ProjectName EMPTY = new ProjectName(Strings2.EMPTY);

    private final String value;

    public static ProjectName empty() {
        return EMPTY;
    }


    @Override
    public String asString() {
        return value;
    }

    public static ProjectName of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクト名");
        return new ProjectName(value);

    }

    public static ProjectName reconstruct(String value) {
        return new ProjectName(value);


    }
}
