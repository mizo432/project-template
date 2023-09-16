package template.modules.security.infra.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.authUser.AuthUser;
import template.modules.security.appl.query.authUser.AuthUserQuery;
import template.modules.security.model.user.User;
import template.modules.security.model.user.UserCode;
import template.modules.security.model.user.UserRepository;
import template.modules.security.model.user.settingPassword.CurrentSettingPassword;
import template.modules.security.model.user.settingPassword.CurrentSettingPasswordRepository;

@Service
@AllArgsConstructor
public class AuthUserQueryImpl implements AuthUserQuery {

    private final UserRepository userRepository;
    private final CurrentSettingPasswordRepository currentUserPasswordRepository;


    @Override
    public AuthUser findByUserCode(final UserCode userCode) {
        final User user = userRepository.findOneByUserCode(userCode);
        final CurrentSettingPassword cup = currentUserPasswordRepository.findOneById(user.getUserId());
        return AuthUser.reconstruct(user, cup.getEncodedPassword());
    }
}
