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
