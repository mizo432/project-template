package com.undecided.projectTemplate.shared.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CacheObjectMapperResolver {

    private final ObjectMapper objectMapper;

    public CacheObjectMapperResolver() {
        this.objectMapper = createObjectMapper();
    }

    private ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }

    public ObjectMapper objectMapper() {
        return objectMapper;

    }


}
