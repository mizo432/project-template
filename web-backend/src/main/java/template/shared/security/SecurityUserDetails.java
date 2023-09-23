package template.shared.security;

import com.undecided.primitive.object.Objects2;
import com.undecided.primitive.set.Sets2;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import template.modules.security.appl.query.user.AuthUser;
import template.modules.security.appl.query.user.role.CurrentAssignmentRole.AssignmentRoles;
import template.modules.security.model.user.User;
import template.modules.security.model.user.settingpassword.EncodedPassword;
import template.modules.security.model.user.statics.AccountNonExpired;
import template.modules.security.model.user.statics.AccountNonLocked;
import template.modules.security.model.user.statics.CredentialsNonExpired;
import template.modules.security.model.user.statics.UserEnabled;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@ToString(exclude = "password")
public class SecurityUserDetails implements UserDetails, Serializable {
    private String username;
    @Getter
    private String name;
    private String password;
    private String mailAddress;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private final Set<String> roles = Sets2.newHashSet();

    public SecurityUserDetails() {
        super();

    }

    /* default */ SecurityUserDetails(final String username, final String name, final String password, final String mailAddress, final Boolean accountNonExpired, final Boolean accountNonLocked, final Boolean credentialsNonExpired, final Boolean enabled, final Collection<String> roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.mailAddress = mailAddress;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.roles.addAll(roles);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    public static SecurityUserDetails reconstruct(final AuthUser user, final AssignmentRoles roles) {
        return reconstruct(user.getUser(), user.getEncodedPassword(), roles);
    }

    private static SecurityUserDetails reconstruct(final User user, final EncodedPassword encodedPassword, final AssignmentRoles roles) {
        return reconstruct(user,
                encodedPassword,
                AccountNonExpired.有効期限内,
                AccountNonLocked.非ロック,
                CredentialsNonExpired.有効期限内,
                UserEnabled.有効,
                roles);
    }

    private static SecurityUserDetails reconstruct(final User user, final EncodedPassword encodedPassword, AccountNonExpired accountNonExpired, AccountNonLocked accountNonLocked, CredentialsNonExpired credentialsNonExpired, UserEnabled userEnabled, final AssignmentRoles roles) {
        return reconstruct(user.getUserAttribute().getUserCode().asString()
                , user.getUserAttribute().getName().asString()
                , encodedPassword.asString(),
                user.getUserAttribute().getEmailAddress().asString(),
                accountNonExpired.isNonExpired(),
                accountNonLocked.isNonLocked(),
                credentialsNonExpired.isNonExpired(),
                userEnabled.isEnabled(), roles.roleStringSet());

    }

    private static SecurityUserDetails reconstruct(final String username, final String name, final String password, final String mailAddress, final Boolean accountNonExpired, final Boolean accountNonLocked, final Boolean credentialsNonExpired, final Boolean enabled, final Collection<String> roles) {
        return new SecurityUserDetails(username, name, password, mailAddress, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, roles);
    }

    @Override
    public String getPassword() {
        return password;

    }

    @Override
    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return Objects2.ifNull(accountNonExpired, true);

    }

    public boolean isAccountNonLocked() {
        return Objects2.ifNull(accountNonLocked, true);

    }

    public boolean isCredentialsNonExpired() {
        return Objects2.ifNull(credentialsNonExpired, true);

    }

    public boolean isEnabled() {
        return Objects2.ifNull(enabled, true);

    }


}
