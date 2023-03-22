package com.undecided.projectTemplate.example.domain.employee;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
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
        this(UlidIdentifier.newInstance(), null, null, null);
    }

    private Employee(UlidIdentifier<Employee> id, String firstName, String lastName, String email) {
        super(id, AuditInfo.empty());
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}