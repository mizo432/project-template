package com.undecided.projectTemplate.modules.example.domain.employee;

import com.undecided.projectTemplate.modules.example.domain.employee.attribute.EmployeeAttribute;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Employee {

    private final SnowflakeId<Employee> id;
    private final EmployeeAttribute attribute;
    private final AuditInfo auditInfo;

    public Employee() {
        this(SnowflakeId.newInstance(), AuditInfo.empty(), EmployeeAttribute.empty());

    }

    private Employee(SnowflakeId<Employee> id, AuditInfo auditInfo,
                     EmployeeAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;

    }


}
