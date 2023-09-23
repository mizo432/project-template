package template.shared.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.user.AuthUser;
import template.modules.security.appl.query.user.AuthUserQuery;
import template.modules.security.appl.query.user.role.CurrentAssignmentRole;
import template.modules.security.appl.query.user.role.CurrentAssignmentRoleQuery;
import template.modules.security.model.user.UserCode;

@AllArgsConstructor
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthUserQuery authUserQuery;

    private final CurrentAssignmentRoleQuery currentAssignmentRoleQuery;

    @Override
    public UserDetails loadUserByUsername(final String userCode) throws UsernameNotFoundException {
        final AuthUser authUser = authUserQuery.findByUserCode(UserCode.of(userCode));
        if (authUser.isEmpty()) {
            throw new UsernameNotFoundException("操作員が見つかりません");
        }
        CurrentAssignmentRole.AssignmentRoles roles = currentAssignmentRoleQuery.selectByUserId(authUser.userId());
        UserDetails user = User.withUsername(authUser.getUser().getUserAttribute().getUserCode().asString())
                .password(authUser.getEncodedPassword().asString())
                .roles(roles.roleStringArray())
                .build();

        log.debug(user.toString());
        return user;
    }
}
