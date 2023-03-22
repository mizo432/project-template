package com.undecided.projectTemplate.modules.resource.domain.partyRole.user;

import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UlidIdentifier<User>> {

}
