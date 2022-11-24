package org.venusPj.projectTemplate.modules.example.domain.employee;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Employee {

    public Employee() {
        this(EmployeeId.newInstance(), null, null, null);
    }

    private EmployeeId id;

    private String firstName;

    private String lastName;

    private String email;

}
