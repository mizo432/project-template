package com.undecided.projectTemplate.modules.resource.domain.partyRole.user;

import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UildIdentifier<User>> {

}
