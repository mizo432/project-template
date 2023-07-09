package com.undefined.template.modules.foo.appl.query.foo;

import com.undefined.template.modules.foo.models.foo.Foo;
import com.undefined.template.modules.foo.models.foo.FooRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Service
public class FetchingFoo {
    private final FooRepository fooRepository;

    public Flux<Foo> selectAll() {
        return fooRepository.findAll();

    }
}
