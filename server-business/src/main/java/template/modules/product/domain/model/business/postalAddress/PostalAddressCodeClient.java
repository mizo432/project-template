package template.modules.product.domain.model.business.postalAddress;

import template.modules.product.port.remoting.postalAddress.PostalAddress;

public interface PostalAddressCodeClient {

    PostalAddress findOneByPostalCode(PostalCode PostalCode);

}
