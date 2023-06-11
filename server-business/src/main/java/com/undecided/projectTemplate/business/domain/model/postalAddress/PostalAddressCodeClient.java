package com.undecided.projectTemplate.business.domain.model.postalAddress;

import com.undecided.projectTemplate.business.port.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
