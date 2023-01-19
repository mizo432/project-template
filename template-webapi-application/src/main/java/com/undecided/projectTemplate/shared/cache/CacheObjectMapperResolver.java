package com.undecided.projectTemplate.shared.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CacheObjectMapperResolver {

    private final ObjectMapper objectMapper;

    public CacheObjectMapperResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectMapper objectMapper() {
        return objectMapper;

    }


}
