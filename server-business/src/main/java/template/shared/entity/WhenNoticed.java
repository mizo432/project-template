package template.shared.entity;

import com.undecided.primitive.localDate.StaticDateProvider;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractDateTimeValue;

import java.time.LocalDateTime;

@Getter
@Domain(valueType = LocalDateTime.class, factoryMethod = "reconstruct")
public class WhenNoticed extends AbstractDateTimeValue {

    public static final WhenNoticed EMPTY_VALUE = new WhenNoticed();

    WhenNoticed(LocalDateTime value) {
        super(value);
    }

    public WhenNoticed() {
        super();
    }

    public static WhenNoticed reconstruct(LocalDateTime value) {
        return new WhenNoticed(value);

    }

    public static WhenNoticed now() {
        return new WhenNoticed(StaticDateProvider.currentLocalDateTime());

    }

}
