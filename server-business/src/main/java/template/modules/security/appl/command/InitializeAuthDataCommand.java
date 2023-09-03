package template.modules.security.appl.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.security.model.role.Role.Roles;
import template.modules.security.model.role.RoleRepository;
import template.modules.security.model.user.User.Users;
import template.modules.security.model.user.UserRepository;
import template.modules.security.model.user.assignmentRole.AssignmentRole;
import template.modules.security.model.user.assignmentRole.AssignmentRoleRepository;
import template.modules.security.model.user.settingPassword.EncodedPassword;
import template.modules.security.model.user.settingPassword.SettingPassword;
import template.modules.security.model.user.settingPassword.SettingPasswordRepository;

@Service
@AllArgsConstructor
@Slf4j
public class InitializeAuthDataCommand {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final SettingPasswordRepository settingPasswordRepository;
    private final AssignmentRoleRepository assignmentRoleRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute() {
        Roles roles = Roles.of(roleRepository.selectAll());
        if (roles.isEmpty()) {
            log.info("初期データ登録開始");
            Roles initialRoles = Roles.initialRoles();
            initialRoles.forEach(roleRepository::insert);
            Users initialUsers = Users.initiaUsers();
            initialUsers.forEach(userRepository::insert);
            initialUsers.forEach(user -> {
                SettingPassword settingPassword = SettingPassword.initializeFrom(user.getUserId(), EncodedPassword.initialize(passwordEncoder));
                settingPasswordRepository.insert(settingPassword);
            });
            final AssignmentRole.AssignmentsRole initialAssignmentRoles = AssignmentRole.AssignmentsRole.initialize(initialUsers, initialRoles);
            initialAssignmentRoles.forEach(assignmentRoleRepository::insert);


            log.info("初期データ登録完了");
        } else {
            log.info("初期データ登録済み。初期データ登録機能をスキップします");

        }
    }

}
