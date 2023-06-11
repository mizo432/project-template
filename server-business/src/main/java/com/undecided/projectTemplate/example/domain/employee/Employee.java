package com.undecided.projectTemplate.example.domain.employee;

import com.undecided.projectTemplate.example.domain.employee.attribute.EmployeeAttribute;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Employee {

    private final SnowflakeId id;
    private final EmployeeAttribute attribute;
    private final AuditInfo auditInfo;

    public Employee() {
        this(SnowflakeId.newInstance(), AuditInfo.empty(), EmployeeAttribute.empty());

    }

    private Employee(SnowflakeId id, AuditInfo auditInfo,
                     EmployeeAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;

    }


}
