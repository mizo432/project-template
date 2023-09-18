package template.modules.admin.domain.model.holiday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;
import template.shared.value.name.Name;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * プロジェクト.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "admin", name = "holiday")
@AllArgsConstructor
@ToString
public class Holiday implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private final SnowflakeId holidayId;

    @Column(name = "holiday")
    private final LocalDate date;

    private final Name name;

    /**
     * インサートようのファクトリー
     *
     * @param holiday 祝日
     * @param name    祝日名称
     * @return 祝日
     */
    public static Holiday create(final LocalDate holiday, final String name) {
        return new Holiday(SnowflakeId.newInstance(), holiday, Name.of(name));

    }

    /**
     * ファクトリーメソッド
     *
     * @param holidayId 祝日ID
     * @return 祝日
     */
    public static Holiday create(final SnowflakeId holidayId) {
        return new Holiday(holidayId, null, Name.empty());
    }

    /**
     * ファクトリーメソッド
     *
     * @param holidayId 祝日ID
     * @param holiday   祝日日付
     * @param name      祝日名称
     * @return 祝日
     */
    public static Holiday create(final Long holidayId, final LocalDate holiday, final String name) {
        return new Holiday(SnowflakeId.of(holidayId), holiday, Name.of(name));
    }

    /**
     * IDが一致しているかを返却します。
     *
     * @param other 検索対象祝日
     * @return 一致している場合trueを返却する
     */
    public boolean sameIdentifierAs(final Holiday other) {
        return holidayId.equals(other.holidayId);

    }

    /**
     * 祝日ファーストクラスコレクション
     */
    public static class Holidays extends AbstractListValue<Holiday> {
        public Holidays(final List<Holiday> value) {
            super(value);

        }

        /**
         * 再生成
         *
         * @param value 値
         * @return 祝日ファーストクラスコレクション
         */
        public static Holidays reconstruct(final List<Holiday> value) {
            return new Holidays(value);
        }

        /**
         * 文字列表現を取得する
         *
         * @return 文字列
         */
        @Override
        public String asString() {
            return toString();
        }
    }
}
