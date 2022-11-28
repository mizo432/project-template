package org.venusPj.projectTemplate.modules.resource.domain.partyRole.user;

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
public class UserId extends Id<UserId> {

    private final String value;

    public static UserId newInstance() {
        return new UserId(new ULID().nextValue().toString());

    }

    public static UserId reconstruct(String value) {
        return new UserId(value);
    }

    @Override
    public String asString() {
        return value;

    }


}
