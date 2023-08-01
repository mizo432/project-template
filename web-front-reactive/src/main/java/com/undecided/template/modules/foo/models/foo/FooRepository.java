package com.undecided.template.modules.foo.models.foo;

import reactor.core.publisher.Flux;

public interface FooRepository {

    Flux<Foo> findAll();

}
