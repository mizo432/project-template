package template.modules.security.model.user.statics;

public enum CredentialsNonExpired {
    有効期限内;

    public Boolean isNonExpired() {
        return 有効期限内.equals(this);

    }
}
