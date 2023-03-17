package com.undecided.projectTemplate.modules.example.business.command.employee;

import com.undecided.primitive.map.Maps2;
import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EmployeesData {

    private static final Map<UildIdentifier<Employee>, Employee> value = Maps2.newHashMap();

    public void put(UildIdentifier<Employee> key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(UildIdentifier<Employee> key) {
        value.remove(key);
    }

    public Employee get(UildIdentifier<Employee> key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
