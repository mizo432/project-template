package com.undecided.projectTemplate.example.business.command.employee;

import com.undecided.primitive.map.Maps2;
import com.undecided.projectTemplate.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class EmployeesData {

    private static final Map<SnowflakeIdentifier<Employee>, Employee> value = Maps2.newHashMap();

    public void put(SnowflakeIdentifier<Employee> key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(SnowflakeIdentifier<Employee> key) {
        value.remove(key);
    }

    public Employee get(SnowflakeIdentifier<Employee> key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
