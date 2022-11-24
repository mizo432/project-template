package org.venusPj.projectTemplate.modules.example.domain.employee;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class EmployeeId extends Id<EmployeeId> {

    private final String value;

    public static EmployeeId newInstance() {
        return new EmployeeId(new ULID().nextValue().toString());

    }

    public static EmployeeId reconstruct(String value) {
        return new EmployeeId(value);
    }

    public static EmployeeId of(String value) {
        return new EmployeeId(value);
    }


    @Override
    public String asString() {
        return value;

    }

}
