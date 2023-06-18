package template.modules.example.appl.command.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.shared.entity.id.SnowflakeId;

@Service
public class DeleteEmployeeCommand {

    private final EmployeesData data;

    public DeleteEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void deleteEmployeeById(SnowflakeId id) {
        data.remove(id);
    }

}
