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
public class ProjectName implements StringValue<ProjectName> {

    private final String value;


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
