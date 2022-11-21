package org.venusPj.projectTemplate.shared.responsibility.layer;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value = CLASS)
@Target(value = {TYPE})
@Documented
public @interface Layer {

    LayerType value();
}
