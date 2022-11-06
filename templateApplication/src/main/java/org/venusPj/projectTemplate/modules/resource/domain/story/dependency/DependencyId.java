package org.venusPj.projectTemplate.modules.resource.domain.story.dependency;

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
public class DependencyId extends Id<DependencyId> {

    private final String value;

    public static DependencyId newInstance() {
        return new DependencyId(new ULID().nextValue().toString());

    }

    @Override
    public String asString() {
        return value;
    }

}
