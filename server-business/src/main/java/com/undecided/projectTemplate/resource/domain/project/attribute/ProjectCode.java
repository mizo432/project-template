package com.undecided.projectTemplate.resource.domain.project.attribute;

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
public class ProjectCode implements StringValue<ProjectCode>, Serializable {

    private static final ProjectCode EMPTY = new ProjectCode(Strings2.EMPTY);

    private final String value;

    public static ProjectCode empty() {
        return EMPTY;
    }


    @Override
    public String asString() {
        return value;
    }

    public static ProjectCode of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクトコード");
        return new ProjectCode(value);

    }

    public static ProjectCode reconstruct(String value) {
        return new ProjectCode(value);


    }
}
