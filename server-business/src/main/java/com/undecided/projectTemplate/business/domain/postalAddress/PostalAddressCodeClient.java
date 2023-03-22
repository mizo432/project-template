package com.undecided.projectTemplate.business.domain.postalAddress;

import com.undecided.projectTemplate.business.infra.remoting.postalAddress.PostalAddress;
import reactor.core.publisher.Mono;

public interface PostalAddressCodeClient {

    Mono<PostalAddress> findOneByPostalCode(PostalCode PostalCode);

}
