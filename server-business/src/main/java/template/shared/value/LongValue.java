package template.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

/**
 * Longちインターフェイス
 */
public interface LongValue extends SingleValue<Long> {


    String asString();

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}

