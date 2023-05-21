package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.business.domain.model.entity.ModelEntity;
import com.undecided.projectTemplate.business.domain.model.entity.ModelEntityRepository;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
                SnowflakeIdentifier<ModelEntity> id = SnowflakeIdentifier.of(1L);
                Optional<ModelEntity> actual = modelEntityRepository.findOneById(id);
                System.out.println(actual.orElseGet(ModelEntity::empty));
            }

        }

    }

}