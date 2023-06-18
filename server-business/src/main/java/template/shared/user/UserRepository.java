package template.shared.user;

import org.springframework.data.repository.CrudRepository;
import template.shared.entity.id.SnowflakeId;

public interface UserRepository extends CrudRepository<User, SnowflakeId> {

}
