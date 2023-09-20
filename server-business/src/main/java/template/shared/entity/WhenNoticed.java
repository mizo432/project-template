package template.shared.entity;

import com.undecided.primitive.localDate.StaticDateProvider;
import com.undecided.primitive.object.Objects2;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractDateTimeValue;

import java.time.LocalDateTime;

/**
 * 適用日時
 * <pre>
 *   未来日時、過去日時もありえる
 * </pre>
 */
@Getter
@Domain(valueType = LocalDateTime.class, factoryMethod = "reconstruct")
public class WhenNoticed extends AbstractDateTimeValue {

    public static final WhenNoticed EMPTY_VALUE = new WhenNoticed();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default*/WhenNoticed(final LocalDateTime value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public WhenNoticed() {
        super();
    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 適用日時
     */
    public static WhenNoticed reconstruct(final LocalDateTime value) {
        if (Objects2.isNull(value)) {
            return EMPTY_VALUE;
        }
        return new WhenNoticed(value);

    }

    /**
     * 現在を指し示す適用日時
     *
     * @return 適用日時
     */

    public static WhenNoticed current() {
        return new WhenNoticed(StaticDateProvider.currentLocalDateTime());

    }

}
