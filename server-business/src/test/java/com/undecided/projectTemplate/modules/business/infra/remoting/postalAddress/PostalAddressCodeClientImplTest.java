package com.undecided.projectTemplate.modules.business.infra.remoting.postalAddress;

import static org.assertj.core.api.Assertions.assertThat;

import com.undecided.projectTemplate.modules.business.domain.postalAddress.PostalCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {PostalAddressCodeClientImpl.class})
@ExtendWith(SpringExtension.class)
class PostalAddressCodeClientImplTest {

    private static final Logger logger = LoggerFactory.getLogger(
        PostalAddressCodeClientImplTest.class);
    @Autowired
    private PostalAddressCodeClientImpl postalAddressClientImpl;

    /**
     * Method under test: {@link PostalAddressCodeClientImpl#findOneByPostalCode(PostalCode)}
     */
    @Test
    void testFindOneByPostalCode() {
        // given
        PostalCode postalCode = PostalCode.of("2720014");

        // when
        Mono<PostalAddress> actualMono = postalAddressClientImpl.findOneByPostalCode(postalCode);

        // then
        assertThat(actualMono).isNotNull();
        PostalAddress actual = actualMono.block();
        System.out.println("actual:" + actual);

    }

    /**
     * Method under test: {@link PostalAddressCodeClientImpl#findOneByPostalCode(PostalCode)}
     */
    @Test
    void testFindOneByPostalCode2() {
        // given
        PostalCode postalCode = PostalCode.of("3770893");

        // when
        Mono<PostalAddress> actualMono = postalAddressClientImpl.findOneByPostalCode(postalCode);

        // then
        assertThat(actualMono).isNotNull();
        PostalAddress actual = actualMono.block();
        System.out.println("actual:" + actual);

    }

    /**
     * Method under test: {@link PostalAddressCodeClientImpl#findOneByPostalCode(PostalCode)}
     */
    @Test
    void testFindOneByPostalCode3() {
        // given
        PostalCode postalCode = PostalCode.of("3770801");

        // when
        Mono<PostalAddress> actualMono = postalAddressClientImpl.findOneByPostalCode(postalCode);

        // then
        assertThat(actualMono).isNotNull();
        PostalAddress actual = actualMono.block();
        System.out.println("actual:" + actual);

    }

    /**
     * Method under test: {@link PostalAddressCodeClientImpl#findOneByPostalCode(PostalCode)}
     */
    @Test
    void testFindOneByPostalCode4() {
        // given
        PostalCode postalCode = PostalCode.of("1066190");
        Mono<PostalAddress> actualMono = null;
        // when
        for (int i = 0; i < 10; i++) {
            actualMono = postalAddressClientImpl.findOneByPostalCode(postalCode);
            logger.warn("actual: " + actualMono.block());

        }

        // then
        assertThat(actualMono).isNotNull();
        PostalAddress actual = actualMono.block();
        logger.warn("actualAtLast: " + actual);

    }
}

