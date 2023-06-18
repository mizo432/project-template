package template.modules.example.appl.command.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.example.domain.employee.Employee;

@Service
public class InsertEmployeeCommand {

    private final EmployeesData data;

    public InsertEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        data.put(employee.getId(), employee);

    }

}
