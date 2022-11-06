package org.venusPj.projectTemplate.modules.tenant.domain.tenant;

import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

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
        if (isNull(value)) {
            throw new IllegalArgumentException("テナントIDがnullです。テナンtIDはnullは許容されません。");
        }
        return new TenantId(value);

    }

}
