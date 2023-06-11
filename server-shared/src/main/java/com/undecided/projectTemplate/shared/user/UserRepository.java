package com.undecided.projectTemplate.shared.user;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, SnowflakeId> {

}
