package com.undecided.projectTemplate.business.domain.postalAddress;

import com.undecided.projectTemplate.business.infra.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
