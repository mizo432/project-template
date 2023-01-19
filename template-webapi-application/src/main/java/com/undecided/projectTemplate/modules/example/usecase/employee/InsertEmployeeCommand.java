package com.undecided.projectTemplate.modules.example.usecase.employee;

import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
