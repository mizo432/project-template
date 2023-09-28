package template.modules.security.model.user.statics;

/**
 * アカウント有効期限
 */
public enum AccountNonExpired {
    有効期限ぎれ, 有効期限内;

    public Boolean isNonExpired() {
        return 有効期限内.equals(this);
    }
}
