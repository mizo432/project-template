package template.shared.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.authuser.AuthUser;
import template.modules.security.appl.query.authuser.AuthUserQuery;
import template.modules.security.model.user.UserCode;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthUserQuery authUserQuery;

    @Override
    public SecurityUserDetails loadUserByUsername(final String userCode) throws UsernameNotFoundException {
        final AuthUser authUser = authUserQuery.findByUserCode(UserCode.of(userCode));
        if (authUser.isEmpty())
            throw new UsernameNotFoundException("操作員が見つかりません");
        return SecurityUserDetails.reconstruct(authUser);
    }
}
