package template.modules.security.appl.query.authUser;


import template.modules.security.model.user.UserCode;

public interface AuthUserQuery {
    AuthUser findByUserCode(UserCode userCode);

}
