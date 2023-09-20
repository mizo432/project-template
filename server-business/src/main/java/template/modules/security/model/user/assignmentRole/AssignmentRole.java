package template.modules.security.model.user.assignmentRole;

import com.undecided.primitive.list.Lists2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.modules.security.model.role.Role;
import template.modules.security.model.role.RoleCode;
import template.modules.security.model.user.User;
import template.modules.security.model.user.UserCode;
import template.shared.entity.WhenOccurred;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * ロール割当
 */
@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "assignment_role")
@AllArgsConstructor
@ToString
public class AssignmentRole {
    @Id
    @Column(name = "assignment_role_id")
    private final SnowflakeId assignmentRoleId;

    @Column(name = "user_id")
    private final SnowflakeId userId;
    @Column(name = "role_id")
    private final SnowflakeId roleId;
    @Column(name = "when_occurred")
    private final WhenOccurred whenOccurred;

    /**
     * ファクトリーメソッド
     *
     * @param userId ユーザID
     * @param roleId ロールID
     * @return ロール割当
     */
    public static AssignmentRole create(final SnowflakeId userId, final SnowflakeId roleId) {
        return new AssignmentRole(SnowflakeId.newInstance(), userId, roleId, WhenOccurred.current());

    }

    /**
     * ロール割当ファーストクラスコレクション
     */
    public static class AssignmentsRole extends AbstractListValue<AssignmentRole> {

        /**
         * コンストラクター
         *
         * @param value 値
         */
        /* default */ AssignmentsRole(final Collection<AssignmentRole> value) {
            super(value);
        }

        /**
         * 初期データの作成
         *
         * @param users ユーザー（複数）
         * @param roles ロール（複数）
         * @return ロール割当ファーストクラスコレクション
         */
        public static AssignmentsRole initialize(final User.Users users, final Role.Roles roles) {
            List<AssignmentRole> assignmentRoleList = Lists2.newArrayList();
            final Optional<User> adminOptionalUser = users.findByUserCode(UserCode.of("admin"));
            User adminUser = adminOptionalUser.orElseThrow(RuntimeException::new);
            final Optional<User> standerdOptionalUser = users.findByUserCode(UserCode.of("user"));
            User standerdUser = standerdOptionalUser.orElseThrow(RuntimeException::new);
            final Optional<Role> adminOptionalRole = roles.findByRoleCode(RoleCode.of("ADMIN"));
            Role adminRole = adminOptionalRole.orElseThrow(RuntimeException::new);
            final Optional<Role> standerdOptionalRole = roles.findByRoleCode(RoleCode.of("USER"));
            Role standerdRole = standerdOptionalRole.orElseThrow(RuntimeException::new);

            assignmentRoleList.add(AssignmentRole.create(adminUser.getUserId(), adminRole.getRoleId()));
            assignmentRoleList.add(AssignmentRole.create(adminUser.getUserId(), standerdRole.getRoleId()));
            assignmentRoleList.add(AssignmentRole.create(standerdUser.getUserId(), standerdRole.getRoleId()));
            return of(assignmentRoleList);
        }

        /**
         * ファクトリーメソッド
         *
         * @param value 値
         * @return ロール割当ファーストクラスコレクション
         */
        private static AssignmentsRole of(final Collection<AssignmentRole> value) {
            return new AssignmentsRole(value);

        }

        /**
         * 文字列表現
         *
         * @return 文字列
         */
        @Override
        public String asString() {
            return toString();
        }

        /**
         * すべての要素に処理を行う
         *
         * @param consumer 対象処理
         */
        public void forEach(final Consumer<AssignmentRole> consumer) {
            value.forEach(consumer);
        }
    }
}
