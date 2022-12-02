package org.venusPj.projectTemplate.modules.resource.domain.partyRole.user;

import org.springframework.data.repository.CrudRepository;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

public interface UserRepository extends CrudRepository<User, Identifier<User>> {

}
