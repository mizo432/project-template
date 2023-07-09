package com.undefined.template.modules.foo.infra.datasource.foo;

import com.undefined.template.modules.foo.models.foo.Foo;
import com.undefined.template.modules.foo.models.foo.FooRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@Repository
public class FooDataSource implements FooRepository {
    private static List<Foo> movies = new ArrayList<>();

    static {
        movies.add(new Foo("Polar (2019)", 64));
        movies.add(new Foo("Iron Man (2008)", 79));
        movies.add(new Foo("The Shawshank Redemption (1994)", 93));
        movies.add(new Foo("Forrest Gump (1994)", 83));
        movies.add(new Foo("Glass (2019)", 70));
    }

    @Override
    public Flux<Foo> findAll() {
        return Flux.fromIterable(movies).delayElements(Duration.ofSeconds(2));

    }
}
