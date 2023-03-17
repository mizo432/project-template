package com.undecided.projectTemplate.modules.example.domain.employee;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Employee extends AbstractEntity<Employee> {

    private final String firstName;

    private final String lastName;

    private final String email;

    public Employee() {
        this(UildIdentifier.newInstance(), null, null, null);
    }

    private Employee(UildIdentifier<Employee> id, String firstName, String lastName, String email) {
        super(id, AuditInfo.empty());
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
