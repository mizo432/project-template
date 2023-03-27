package com.undecided.projectTemplate.example.business.command.employee;

import com.undecided.projectTemplate.example.domain.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateEmployeeCommand {

    private final EmployeesData data;

    public UpdateEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
        
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        data.put(employee.getId(), employee);

    }

}
