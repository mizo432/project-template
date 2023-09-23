package template.modules.security.infra.query.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.user.AuthUser;
import template.modules.security.appl.query.user.AuthUserQuery;
import template.modules.security.model.user.User;
import template.modules.security.model.user.UserCode;
import template.modules.security.model.user.UserRepository;
import template.modules.security.model.user.settingpassword.CurrentSettingPassword;
import template.modules.security.model.user.settingpassword.CurrentSettingPasswordRepository;

/**
 * 認証ユーザークエリー実装
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthUserQueryImpl implements AuthUserQuery {

    private final UserRepository userRepository;
    private final CurrentSettingPasswordRepository currentUserPasswordRepository;

    /**
     * ユーザーコードヲ基に認証ユーザーを取得する
     *
     * @param userCode ユーザーコード
     * @return 認証ユーザー
     */
    @Override
    public AuthUser findByUserCode(final UserCode userCode) {
        final User user = userRepository.findOneByUserCode(userCode);
        final CurrentSettingPassword cup = currentUserPasswordRepository.findOneByUserId(user.getUserId());
        AuthUser authUser = AuthUser.reconstruct(user, cup.getEncodedPassword());
        log.debug(authUser.toString());
        return authUser;

    }
}
