package template.modules.admin.domain.users;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    @Query("SELECT u.* FROM users u WHERE u.email = :email")
    Flux<User> findByEmail(String email);

}
