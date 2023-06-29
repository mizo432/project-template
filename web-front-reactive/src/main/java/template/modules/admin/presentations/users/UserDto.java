package template.modules.admin.presentations.users;

import lombok.Data;
import lombok.NonNull;
import template.modules.admin.domain.users.User;

@Data
public class UserDto {
    private String name;
    private String login;
    private String email;
    private String avatar;

    public @NonNull User convertToModel(Long userId) {
        return User.create(userId, name, login, email, avatar);

    }
}
