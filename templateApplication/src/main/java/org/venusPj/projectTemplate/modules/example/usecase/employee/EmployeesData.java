package org.venusPj.projectTemplate.modules.example.usecase.employee;

import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.modules.example.domain.employee.EmployeeId;
import org.venusPj.primitive.map.Maps2;

@Component
public class EmployeesData {

    private static final Map<EmployeeId, Employee> value = Maps2.newHashMap();

    public void put(EmployeeId key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(EmployeeId key) {
        value.remove(key);
    }

    public Employee get(EmployeeId key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
