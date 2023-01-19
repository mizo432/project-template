package com.undecided.projectTemplate.modules.example.usecase.employee;

import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

@Service
public class DeleteEmployeeCommand {

    private final EmployeesData data;

    public DeleteEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void deleteEmployeeById(Identifier<Employee> id) {
        data.remove(id);
    }

}
