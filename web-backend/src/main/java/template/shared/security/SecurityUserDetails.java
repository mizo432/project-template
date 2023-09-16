package template.shared.security;

import com.undecided.primitive.object.Objects2;
import com.undecided.primitive.set.Sets2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import template.modules.security.appl.query.authUser.AuthUser;
import template.modules.security.model.user.User;
import template.modules.security.model.user.settingPassword.EncodedPassword;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "reconstruct")
@ToString
public class SecurityUserDetails implements UserDetails, Serializable {
    private final Set<String> roles = Sets2.newHashSet("ADMIN", "USER");
    private String username;
    private String password;
    private String mailAddress;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    public SecurityUserDetails() {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    public static SecurityUserDetails reconstruct(final AuthUser user) {
        return reconstruct(user.getUser(), user.getEncodedPassword());
    }

    private static SecurityUserDetails reconstruct(final User user, final EncodedPassword encodedPassword) {
        return reconstruct(user.getUserAttribute().getEmailAddress().asString()
                , encodedPassword.asString(),
                user.getUserAttribute().getEmailAddress().asString(),
                Boolean.TRUE,
                Boolean.TRUE,
                Boolean.TRUE,
                Boolean.TRUE);
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
