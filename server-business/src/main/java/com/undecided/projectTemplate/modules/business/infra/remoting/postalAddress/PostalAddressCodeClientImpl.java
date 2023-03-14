package com.undecided.projectTemplate.modules.business.infra.remoting.postalAddress;

import com.undecided.projectTemplate.modules.business.domain.postalAddress.PostalAddressCodeClient;
import com.undecided.projectTemplate.modules.business.domain.postalAddress.PostalCode;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import javax.net.ssl.SSLException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider.Proxy;

@Component
public class PostalAddressCodeClientImpl implements PostalAddressCodeClient {

    private SslContext sslContext() throws SSLException {
        return SslContextBuilder.forClient()
            .trustManager(InsecureTrustManagerFactory.INSTANCE)
            .build();
    }

    private HttpClient httpClient() {
        return HttpClient.create()
            .proxy(proxy -> proxy.type(Proxy.HTTP).host("145.254.232.51").port(8080))
            .secure(t -> {
                try {
                    t.sslContext(sslContext());
                } catch (SSLException e) {
                    throw new RuntimeException(e);
                }
            });
    }


    private final WebClient webClient = WebClient.builder()
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .clientConnector(new ReactorClientHttpConnector(httpClient())).build();


    @Override
    public Mono<PostalAddress> findOneByPostalCode(PostalCode postalCode) {
        UriComponents uc = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("postcode.teraren.com")
            .path("postcodes/{postalCode}.json")
            .buildAndExpand(postalCode.asString());

        return webClient.get()
            .uri(uc.toUri())
            .retrieve()
            .bodyToMono(PostalAddress.class);

    }
}
