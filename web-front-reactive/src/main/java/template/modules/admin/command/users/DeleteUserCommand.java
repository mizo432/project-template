package template.modules.admin.command.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import template.modules.admin.domain.users.User;
import template.modules.admin.domain.users.UserRepository;

@Service
@AllArgsConstructor
public class DeleteUserCommand {
    private final UserRepository repo;

    public Boolean execute(Long id) {
        Mono<User> existingUser = findById(id);
        if (existingUser != null) {
            repo.deleteById(id);
            return true;
        } else
            return false;
    }

    private Mono<User> findById(Long id) {
        return repo.findById(id);

    }
}
