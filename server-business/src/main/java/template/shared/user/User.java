package template.shared.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;
import template.shared.user.attribbute.UserAttribute;

import static com.undecided.primitive.object.Objects2.isNull;

@Getter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    protected final SnowflakeId id;

    protected final AuditInfo auditInfo;

    private final UserAttribute attribute;

    protected User(SnowflakeId id, AuditInfo auditInfo, UserAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;

    }

    public static User create(UserAttribute attribute) {
        return new User(SnowflakeId.newInstance(), AuditInfo.empty(), attribute);

    }

    public boolean sameValueAs(User other) {
        return sameIdAs(other)
                && attribute.equals(other.attribute);

    }

    private boolean sameIdAs(User other) {
        if (isNull(other)) {
            return false;
        }

        return id.equals(other.getId());

    }

}
