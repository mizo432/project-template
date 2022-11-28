package org.venusPj.projectTemplate.modules.example.usecase.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.example.domain.employee.EmployeeId;

@Service
public class DeleteEmployeeCommand {

    private final EmployeesData data;

    public DeleteEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void deleteEmployeeById(EmployeeId id) {
        data.remove(id);
    }

}
