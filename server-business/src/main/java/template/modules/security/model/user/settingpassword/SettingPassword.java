package template.modules.security.model.user.settingpassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.WhenOccurred;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "setting_password")
@AllArgsConstructor
@ToString(exclude = {"encodedPassword"})
public class SettingPassword {
    @Id
    @Column(name = "setting_password_id")
    private final SnowflakeId settingPasswordId;

    @Column(name = "user_id")
    private final SnowflakeId userId;

    @Column(name = "when_occurred")
    private final WhenOccurred whenOccurred;

    @Column(name = "password")
    private final EncodedPassword encodedPassword;

    public static SettingPassword initializeFrom(final SnowflakeId userId, final EncodedPassword encodedPassword) {
        return new SettingPassword(SnowflakeId.newInstance(), userId, WhenOccurred.current(), encodedPassword);
    }

    public boolean isEmpty() {
        return settingPasswordId.isEmpty()
                && userId.isEmpty()
                && whenOccurred.isEmpty()
                && encodedPassword.isEmpty();
    }

    public static class SettingsPassword extends AbstractListValue<SettingPassword> {

        @Override
        public String asString() {
            return toString();
        }
    }

}
