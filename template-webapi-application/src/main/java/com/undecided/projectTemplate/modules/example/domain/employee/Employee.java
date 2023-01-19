package com.undecided.projectTemplate.modules.example.domain.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

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
