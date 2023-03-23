package com.undecided.projectTemplate.resource.domain.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class ProjectCode extends AbstractStringValue {

    private static final ProjectCode EMPTY = new ProjectCode(Strings2.EMPTY);

    ProjectCode(String value) {
        super(value);
    }


    public static ProjectCode empty() {
        return EMPTY;
    }


    public static ProjectCode of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクトコード");
        return new ProjectCode(value);

    }

    public static ProjectCode reconstruct(String value) {
        return new ProjectCode(value);


    }
}
