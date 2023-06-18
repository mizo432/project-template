package template.modules.example.appl.command.employee;

import com.undecided.primitive.map.Maps2;
import org.springframework.stereotype.Component;
import template.modules.example.domain.employee.Employee;
import template.shared.entity.id.SnowflakeId;

import java.util.Collection;
import java.util.Map;

@Component
public class EmployeesData {

    private static final Map<SnowflakeId, Employee> value = Maps2.newHashMap();

    public void put(SnowflakeId key, Employee employee) {
        value.put(key, employee);

    }

    public void remove(SnowflakeId key) {
        value.remove(key);
    }

    public Employee get(SnowflakeId key) {
        return value.get(key);

    }

    public Collection<Employee> values() {
        return value.values();
    }
}
