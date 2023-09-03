package template.modules.security.model.user.settingPassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.id.SnowflakeId;

@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "current_setting_password")
@AllArgsConstructor
@ToString
public class CurrentSettingPassword {
    @Id
    private final SnowflakeId userId;

    private final EncodedPassword encodedPassword;

}
