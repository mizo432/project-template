package template.modules.example.appl.query.employee;


import com.undecided.primitive.list.Lists2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.example.appl.command.employee.EmployeesData;
import template.modules.example.domain.employee.Employee;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

@Service
public class FetchEmployeeQuery {

    private final EmployeesData data;

    public FetchEmployeeQuery(EmployeesData employeesData) {
        data = employeesData;

    }

    @Transactional
    public List<Employee> selectAllEmployees() {
        return Lists2.newArrayList(data.values());

    }

    @Transactional
    public Employee findEmployeeById(SnowflakeId id) {
        return data.get(id);

    }

}
