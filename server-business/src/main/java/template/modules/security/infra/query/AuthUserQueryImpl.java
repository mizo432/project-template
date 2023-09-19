package template.modules.security.infra.query;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.authuser.AuthUser;
import template.modules.security.appl.query.authuser.AuthUserQuery;
import template.modules.security.model.user.User;
import template.modules.security.model.user.UserCode;
import template.modules.security.model.user.UserRepository;
import template.modules.security.model.user.settingpassword.CurrentSettingPassword;
import template.modules.security.model.user.settingpassword.CurrentSettingPasswordRepository;

@Service
@AllArgsConstructor
@Slf4j
public class AuthUserQueryImpl implements AuthUserQuery {

    private final UserRepository userRepository;
    private final CurrentSettingPasswordRepository currentUserPasswordRepository;


    @Override
    public AuthUser findByUserCode(final UserCode userCode) {
        final User user = userRepository.findOneByUserCode(userCode);
        final CurrentSettingPassword cup = currentUserPasswordRepository.findOneByUserId(user.getUserId());
        AuthUser authUser = AuthUser.reconstruct(user, cup.getEncodedPassword());
        log.debug(authUser.toString());
        return authUser;
    }
}
