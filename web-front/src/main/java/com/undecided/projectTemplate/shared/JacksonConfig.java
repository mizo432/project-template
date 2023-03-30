package com.undecided.projectTemplate.shared;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return builder -> builder
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .serializerByType(Date.class, new JsonSerializer<Date>() {
                @Override
                public void serialize(Date date, JsonGenerator jsonGenerator,
                    SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeString(
                        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(date));
                }
            })
            .serializerByType(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                @Override
                public void serialize(LocalDateTime date, JsonGenerator jsonGenerator,
                    SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeString(
                        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(date));
                }
            })
            .serializerByType(Instant.class, new JsonSerializer<Instant>() {
                @Override
                public void serialize(Instant date, JsonGenerator jsonGenerator,
                    SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeString(
                        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(Date.from(date)));
                }
            })
            ;

    }
}
