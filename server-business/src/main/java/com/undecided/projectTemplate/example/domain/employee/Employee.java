package com.undecided.projectTemplate.example.domain.employee;

import com.undecided.projectTemplate.example.domain.employee.attribute.EmployeeAttribute;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Employee {

    private final SnowflakeIdentifier<Employee> id;
    private final EmployeeAttribute attribute;
    private final AuditInfo auditInfo;

    public Employee() {
        this(SnowflakeIdentifier.newInstance(), AuditInfo.empty(), EmployeeAttribute.empty());

    }

    private Employee(SnowflakeIdentifier<Employee> id, AuditInfo auditInfo,
        EmployeeAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;

    }


}
