package org.venusPj.projectTemplate.modules.tenant.domain.tenant;

import static org.venusPj.primitive.object.Objects2.isNull;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.entity.id.Id;
import org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class TenantId extends Id<TenantId> {

    /**
     * テナントIDの値を格納する
     */
    private final String value;

    public static @NotNull TenantId of(@NotNull String value) {
        StringPreconditions.checkNotEmpty(value, "テナントID");
        return new TenantId(value);

    }

    @Override
    public String asString() {
        if (isNull(value)) {
            return null;
        }

        return ULID.parseULID(value).toString();
    }

    public static TenantId newInstance() {
        return new TenantId(new ULID().nextValue().toString());

    }

    public boolean isEmpty() {
        return isNull(value);

    }
}
