package org.venusPj.projectTemplate.modules.resource.domain.sprint;

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
public class SprintId extends Id<SprintId> {

    private final String value;

    public static SprintId newInstance() {
        return new SprintId(new ULID().nextValue().toString());

    }

    public static SprintId reconstruct(String value) {
        return new SprintId(value);
    }


    @Override
    public String asString() {
        return value;

    }

}
