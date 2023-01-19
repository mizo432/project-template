package com.undecided.projectTemplate.modules.example.usecase.employee;

import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.venusPj.primitive.map.Maps2;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

@Component
public class EmployeesData {

    private static final Map<Identifier<Employee>, Employee> value = Maps2.newHashMap();

    public void put(Identifier<Employee> key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(Identifier<Employee> key) {
        value.remove(key);
    }

    public Employee get(Identifier<Employee> key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
