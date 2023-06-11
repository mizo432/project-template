package com.undecided.projectTemplate.modules.product.domain.model.business.postalAddress;

import com.undecided.projectTemplate.modules.product.port.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
