package template.modules.security.appl.query.user;


import template.modules.security.model.user.UserCode;

public interface AuthUserQuery {
    AuthUser findByUserCode(UserCode userCode);

}
