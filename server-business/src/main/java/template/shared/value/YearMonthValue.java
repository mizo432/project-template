package template.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

import java.time.YearMonth;

public interface YearMonthValue extends SingleValue<YearMonth> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
