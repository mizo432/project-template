package com.undecided.projectTemplate.modules.example.appl.command.employee;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
