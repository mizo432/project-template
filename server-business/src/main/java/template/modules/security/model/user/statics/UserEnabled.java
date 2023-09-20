package template.modules.security.model.user.statics;

public enum UserEnabled {
    有効;

    public Boolean isEnabled() {
        return 有効.equals(this);
    }
}
