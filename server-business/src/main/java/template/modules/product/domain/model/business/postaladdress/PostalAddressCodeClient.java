package template.modules.product.domain.model.business.postaladdress;

import template.modules.product.port.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
