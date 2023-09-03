package template.modules.security.model.user;

import com.undecided.primitive.list.Lists2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.id.SnowflakeId;
import template.shared.user.attribbute.UserCode;
import template.shared.value.AbstractListValue;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * ユーザー.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "user")
@AllArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    private final SnowflakeId userId;

    private final UserAttribute userAttribute;

    public static User create(final String userCode, final String userName, final String userKanaName, final String email) {
        return new User(SnowflakeId.newInstance(), UserAttribute.create(userCode, userName, userKanaName, email));
    }

    public boolean isEmpty() {
        return userId.isEmpty() && userAttribute.isEmpty();

    }

    public static class Users extends AbstractListValue<User> {

        public Users(final Collection<User> value) {
            super(value);
        }

        public static Users initiaUsers() {
            User adminUser = User.create("admin", "システム管理者", "しすてむかんりしゃ", "dummy@sample.com");
            User standerdUser = User.create("user", "一般ユーザー", "いっぱんゆーざー", "dummy@sample.com");
            return of(Lists2.newArrayList(adminUser, standerdUser));

        }

        public static Users of(Collection<User> value) {
            return new Users(value);
        }

        @Override
        public String asString() {
            return toString();
        }

        public void forEach(final Consumer<User> consumer) {
            value.forEach(consumer);
        }

        public Optional<User> findByUserCode(final UserCode userCode) {
            return value
                    .stream()
                    .filter(user -> user
                            .getUserAttribute()
                            .getUserCode()
                            .equals(userCode))
                    .findFirst();

        }
    }


}
