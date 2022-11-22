package org.venusPj.projectTemplate.modules.example.usecase.employee;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.shared.primitive.map.Maps2;

@Service
public class EmployeeService {

    private static final Map<Long, Employee> data = Maps2.newHashMap();

    public List<Employee> getAllEmployees() {
        return newArrayList(data.values());

    }

    public void saveEmployee(Employee employee) {
        data.put(employee.getId(), employee);

    }

    public Employee getEmployeeById(Long id) {
        return data.get(id);

    }

    public void deleteEmployeeById(Long id) {
        data.remove(id);
    }
}
