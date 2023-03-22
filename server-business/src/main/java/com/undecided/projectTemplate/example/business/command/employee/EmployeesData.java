package com.undecided.projectTemplate.example.business.command.employee;

import com.undecided.primitive.map.Maps2;
import com.undecided.projectTemplate.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EmployeesData {

    private static final Map<UlidIdentifier<Employee>, Employee> value = Maps2.newHashMap();

    public void put(UlidIdentifier<Employee> key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(UlidIdentifier<Employee> key) {
        value.remove(key);
    }

    public Employee get(UlidIdentifier<Employee> key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
