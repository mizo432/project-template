package com.undecided.projectTemplate.modules.example.appl.command.employee;

import com.undecided.primitive.map.Maps2;
import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class EmployeesData {

    private static final Map<SnowflakeId<Employee>, Employee> value = Maps2.newHashMap();

    public void put(SnowflakeId<Employee> key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(SnowflakeId<Employee> key) {
        value.remove(key);
    }

    public Employee get(SnowflakeId<Employee> key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
