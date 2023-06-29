package template.modules.admin.command.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import template.modules.admin.domain.users.User;
import template.modules.admin.domain.users.UserRepository;

@Service
@AllArgsConstructor
public class AddUserCommand {
    private final UserRepository repo;

    public Mono<User> execute(User user) {
        return repo.save(user);

    }

}
