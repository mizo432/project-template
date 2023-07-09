package com.undefined.template.modules.foo.web.foo;

import com.undefined.template.modules.foo.appl.query.foo.FetchingFoo;
import com.undefined.template.modules.foo.models.foo.Foo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
@AllArgsConstructor
@RequestMapping("/foo")
public class FooController {
    private final FetchingFoo fetchingFoo;

    @RequestMapping
    public String index(final Model model) {
        Flux<Foo> foos = fetchingFoo.selectAll();
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(foos, 1);

        model.addAttribute("movies", reactiveDataDrivenMode);

        return "foo/index";
    }

}
