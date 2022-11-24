package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProjectCode implements StringValue<ProjectCode> {

    private final String value;


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
