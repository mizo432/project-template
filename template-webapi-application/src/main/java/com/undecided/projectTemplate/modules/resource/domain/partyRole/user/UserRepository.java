package com.undecided.projectTemplate.modules.resource.domain.partyRole.user;

import com.undecided.projectTemplate.shared.entity.id.Identifier;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Identifier<User>> {

}
