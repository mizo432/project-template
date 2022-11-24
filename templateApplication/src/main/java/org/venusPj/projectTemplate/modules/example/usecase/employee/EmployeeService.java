package org.venusPj.projectTemplate.modules.example.usecase.employee;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.modules.example.domain.employee.EmployeeId;
import org.venusPj.projectTemplate.shared.primitive.map.Maps2;

@Service
public class EmployeeService {

    private static final Map<EmployeeId, Employee> data = Maps2.newHashMap();

    @Transactional
    public List<Employee> getAllEmployees() {
        return newArrayList(data.values());

    }

    @Transactional
    public void saveEmployee(Employee employee) {
        data.put(employee.getId(), employee);

    }

    @Transactional
    public Employee getEmployeeById(EmployeeId id) {
        return data.get(id);

    }

    @Transactional
    public void deleteEmployeeById(EmployeeId id) {
        data.remove(id);
    }
}
