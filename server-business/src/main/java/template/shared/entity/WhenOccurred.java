package template.shared.entity;

import com.undecided.primitive.localDate.StaticDateProvider;
import com.undecided.primitive.object.Objects2;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractDateTimeValue;

import java.time.LocalDateTime;

/**
 * 発生日時.
 * <pre>
 *   データベースに書かれた日時を示す。
 *   基本的に、未来日時はありえない。その用途は適用日付が担う
 * </pre>
 */
@Getter
@Domain(valueType = LocalDateTime.class, factoryMethod = "reconstruct")
public class WhenOccurred extends AbstractDateTimeValue {

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default*/WhenOccurred(final LocalDateTime value) {
        super(value);
    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 発生日時
     */
    public static WhenOccurred reconstruct(final LocalDateTime value) {
        return new WhenOccurred(value);

    }

    /**
     * 現在を指し示す発生日時
     *
     * @return 発生日時
     */
    public static WhenOccurred current() {
        return new WhenOccurred(StaticDateProvider.currentLocalDateTime());

    }

    /**
     * 文字列表現を示す
     *
     * @return 文字列
     */
    @Override
    public String asString() {
        return Objects2.ifPresent(value, Object::toString);

    }
}
