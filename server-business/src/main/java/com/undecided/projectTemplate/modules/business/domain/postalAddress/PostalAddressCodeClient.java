package com.undecided.projectTemplate.modules.business.domain.postalAddress;

import com.undecided.projectTemplate.modules.business.infra.remoting.postalAddress.PostalAddress;
import reactor.core.publisher.Mono;

public interface PostalAddressCodeClient {

    Mono<PostalAddress> findOneByPostalCode(PostalCode PostalCode);

}
