package com.undecided.projectTemplate.example.business.command.employee;

import com.undecided.projectTemplate.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteEmployeeCommand {

    private final EmployeesData data;

    public DeleteEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void deleteEmployeeById(SnowflakeIdentifier<Employee> id) {
        data.remove(id);
    }

}
