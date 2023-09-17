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
public class Holiday {

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
    public static Holiday create(LocalDate holiday, String name) {
        return new Holiday(SnowflakeId.newInstance(), holiday, Name.of(name));

    }

    /**
     * ファクトリーメソッド
     *
     * @param holidayId 祝日ID
     * @return 祝日
     */
    public static Holiday create(SnowflakeId holidayId) {
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
    public static Holiday create(Long holidayId, LocalDate holiday, String name) {
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
        public Holidays(List<Holiday> value) {
            super(value);

        }

        public static Holidays reconstruct(List<Holiday> value) {
            return new Holidays(value);
        }

        @Override
        public String asString() {
            return toString();
        }
    }
}
