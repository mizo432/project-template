package template.shared.security;

import com.undecided.primitive.set.Sets2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import template.modules.security.appl.model.user.UserAttribute;
import template.modules.security.appl.query.authUser.AuthUser;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "reconstruct")
@ToString
public class SecurityUserDetails implements UserDetails {
    private AuthUser user;

    private final Set<String> roles = Sets2.newHashSet("ADMIN");

    public static SecurityUserDetails createFrom(final AuthUser user) {
        return SecurityUserDetails.reconstruct(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return user.getEncodedPassword().asString();

    }

    UserAttribute getUserAttribute() {
        return user.getUser().getUserAttribute();
    }

    @Override
    public String getUsername() {
        return getUserAttribute().getUserCode().asString();
    }

    public boolean isAccountNonExpired() {
        return true;

    }

    public boolean isAccountNonLocked() {
        return true;

    }

    public boolean isCredentialsNonExpired() {
        return true;

    }

    public boolean isEnabled() {
        return true;

    }


}
