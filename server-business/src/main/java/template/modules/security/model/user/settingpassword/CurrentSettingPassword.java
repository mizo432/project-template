package template.modules.security.model.user.settingpassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import template.shared.entity.WhenOccurred;
import template.shared.entity.id.SnowflakeId;

@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "current_setting_password")
@AllArgsConstructor
@ToString(exclude = {"encodedPassword"})
public class CurrentSettingPassword {
    @Column(name = "user_id")
    private final SnowflakeId userId;

    @Column(name = "latest_when_occurred")
    private final WhenOccurred whenOccurred;

    @Column(name = "password")
    private final EncodedPassword encodedPassword;

}
