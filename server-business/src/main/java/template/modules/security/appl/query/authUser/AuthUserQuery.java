package template.modules.security.appl.query.authUser;

import template.shared.user.attribbute.UserCode;

public interface AuthUserQuery {
    AuthUser findByUserCode(UserCode userCode);

}
