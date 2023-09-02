package template.shared.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import template.modules.security.appl.query.authUser.AuthUser;
import template.modules.security.appl.query.authUser.AuthUserQuery;
import template.shared.user.attribbute.UserCode;

@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthUserQuery authUserQuery;

    @Override
    public SecurityUserDetails loadUserByUsername(final String userCode) throws UsernameNotFoundException {
        final AuthUser authUser = authUserQuery.findByUserCode(UserCode.of(userCode));
        if (authUser.isEmpty())
            throw new UsernameNotFoundException("操作員が見つかりません");
        return SecurityUserDetails.createFrom(authUser);
    }
}
