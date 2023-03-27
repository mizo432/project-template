package com.undecided.projectTemplate.example.domain.employee;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Employee extends AbstractEntity<Employee> {

    private final String firstName;

    private final String lastName;

    private final String email;

    public Employee() {
        this(SnowflakeIdentifier.newInstance(), null, null, null);

    }

    private Employee(SnowflakeIdentifier<Employee> id, String firstName, String lastName, String email) {
        super(id, AuditInfo.empty());
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
