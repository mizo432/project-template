package com.undecided.projectTemplate.resource.domain.partyRole.user;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, SnowflakeIdentifier<User>> {

}
