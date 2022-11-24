package org.venusPj.projectTemplate.modules.resource.domain.project;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProjectId extends Id<ProjectId> {

    private final String value;

    public static ProjectId newInstance() {
        return new ProjectId(new ULID().nextValue().toString());

    }

    public static ProjectId reconstruct(String value) {
        return new ProjectId(value);
    }


    @Override
    public String asString() {
        return value;

    }
}
