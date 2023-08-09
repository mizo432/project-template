package com.undecided.template.modules.foo.web.foo.admin.employees;

import com.undecided.template.modules.foo.models.foo.admin.employees.Employee;
import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class EmployeeForm {
    private String firstName;
    private String lastName;
    private String kanaName;

    public static EmployeeForm createFrom(Mono<Employee> employee) {
        Employee wk = employee.block();
        EmployeeForm result = new EmployeeForm();
        result.setFirstName(wk.getFirstName());
        result.setLastName(wk.getLastName());
        result.setKanaName(wk.getKanaName());
        return result;
    }


    public Employee toEmployee() {
        return Employee.create(firstName, lastName, kanaName);
    }
}
