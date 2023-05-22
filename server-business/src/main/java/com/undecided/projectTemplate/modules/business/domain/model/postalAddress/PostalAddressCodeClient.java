package com.undecided.projectTemplate.modules.business.domain.model.postalAddress;

import com.undecided.projectTemplate.modules.business.port.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
