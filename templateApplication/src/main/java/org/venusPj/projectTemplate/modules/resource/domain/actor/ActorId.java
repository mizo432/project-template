package org.venusPj.projectTemplate.modules.resource.domain.actor;

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
public class ActorId extends Id<ActorId> {

    private final String value;

    public static ActorId newInstance() {
        return new ActorId(new ULID().nextValue().toString());

    }

    public static ActorId reconstruct(String value) {
        return new ActorId(value);
    }


    @Override
    public String asString() {
        return value;

    }

}
