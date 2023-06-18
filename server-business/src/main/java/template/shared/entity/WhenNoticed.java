package template.shared.entity;

import com.undecided.primitive.localDate.StaticDateProvider;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractDateTimeValue;

import java.time.LocalDateTime;

@Getter
@Domain(valueType = LocalDateTime.class, factoryMethod = "reconstruct")
public class WhenNoticed extends AbstractDateTimeValue {

    private static final WhenNoticed EMPTY = new WhenNoticed(null);

    WhenNoticed(LocalDateTime value) {
        super(value);
    }

    public static WhenNoticed reconstruct(LocalDateTime value) {
        return new WhenNoticed(value);

    }

    public static WhenNoticed now() {
        return new WhenNoticed(StaticDateProvider.currentLocalDateTime());

    }

    public static WhenNoticed empty() {
        return EMPTY;
    }
}
