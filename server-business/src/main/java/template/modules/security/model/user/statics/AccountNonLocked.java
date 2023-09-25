package template.modules.security.model.user.statics;

public enum AccountNonLocked {
    非ロック;

    public Boolean isNonLocked() {
        return 非ロック.equals(this);
    }
}
