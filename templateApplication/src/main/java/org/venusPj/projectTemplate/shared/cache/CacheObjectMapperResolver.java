package org.venusPj.projectTemplate.shared.cache;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class CacheObjectMapperResolver {

    public ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        FilterProvider filters = new SimpleFilterProvider();

        ObjectMapper resultMapper = builder.filters(filters).build();
        resultMapper.registerModule(new JavaTimeModule());
        resultMapper.activateDefaultTyping(resultMapper.getPolymorphicTypeValidator(),
            DefaultTyping.NON_FINAL, As.PROPERTY);
        resultMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        return resultMapper;

    }


}
