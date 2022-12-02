package org.venusPj.projectTemplate.modules.example.domain.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Employee extends AbstractEntity<Employee> {

    private final String firstName;

    private final String lastName;

    private final String email;

    public Employee() {
        this(Identifier.newInstance(), null, null, null);
    }

    private Employee(Identifier<Employee> id, String firstName, String lastName, String email) {
        super(id, AuditInfo.empty());
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
