package template.modules.admin.query.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import template.modules.admin.domain.users.User;
import template.modules.admin.domain.users.UserRepository;

@Service
@AllArgsConstructor
public class UserFetcher {
    private UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> findByEmail(String email) {
        return userRepository.findByEmail(email).elementAt(0);
    }

}
