package org.venusPj.projectTemplate.modules.tenant.domain.tenant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions;

@Getter
@AllArgsConstructor
@lombok.EqualsAndHashCode
@ToString
public class TenantId {

    /**
     * テナントIDの値を格納する
     */
    private final String value;

    public static @NotNull TenantId of(@NotNull String value) {
        StringPreconditions.checkNotEmpty(value, "テナントID");
        return new TenantId(value);

    }

}
