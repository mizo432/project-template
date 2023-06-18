package template.shared.value;

import com.undecided.primitive.object.Objects2;

import java.time.LocalDateTime;

/**
 * 日時値インターフェイス
 */
public interface DateTimeValue extends SingleValue<LocalDateTime> {

    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
