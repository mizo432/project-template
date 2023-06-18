package template.modules.example.domain.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.modules.example.domain.employee.attribute.EmployeeAttribute;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;

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
