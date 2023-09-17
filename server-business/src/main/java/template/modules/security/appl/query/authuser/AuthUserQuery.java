package template.modules.security.appl.query.authuser;


import template.modules.security.model.user.UserCode;

public interface AuthUserQuery {
    AuthUser findByUserCode(UserCode userCode);

}
