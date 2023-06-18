package template.modules.product.domain.model.business.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import template.shared.entity.id.SnowflakeId;

import java.util.Optional;

class ModelEntityRepositoryTest {

    @Nested
    @SpringBootTest
    @Disabled
    class SpringTest {

        @Autowired
        ModelEntityRepository modelEntityRepository;

        @Nested
        class findOneBy {

            @Test
            @Transactional
            void success() {
                SnowflakeId id = SnowflakeId.of(1L);
                Optional<ModelEntity> actual = modelEntityRepository.findOneById(id);
                System.out.println(actual.orElseGet(ModelEntity::empty));
            }

        }

    }

}