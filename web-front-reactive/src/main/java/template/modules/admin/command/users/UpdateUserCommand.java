package template.modules.admin.command.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import template.modules.admin.domain.users.User;
import template.modules.admin.domain.users.UserRepository;

@Service
@AllArgsConstructor
public class UpdateUserCommand {
    private UserRepository userRepository;

    public Mono<User> execute(User user) {
        Mono<User> existingUser = findById(user.getId());
        if (existingUser != null) {
            userRepository.save(user);
            return Mono.just(user);
        } else {
            return Mono.empty();
        }
    }

    private Mono<User> findById(Long id) {
        return userRepository.findById(id);

    }

}
