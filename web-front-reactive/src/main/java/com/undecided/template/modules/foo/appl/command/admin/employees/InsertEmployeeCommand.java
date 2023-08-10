package com.undecided.template.modules.foo.appl.command.admin.employees;

import com.undecided.template.modules.foo.models.foo.admin.employees.Employee;
import com.undecided.template.modules.foo.models.foo.admin.employees.EmployeesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InsertEmployeeCommand {
    private final EmployeesRepository employeesRepository;

    public void insert(Employee employee) {
        log.debug(employee.toString());

        employeesRepository.save(employee);

    }
}
