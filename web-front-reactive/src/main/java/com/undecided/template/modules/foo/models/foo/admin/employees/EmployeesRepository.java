package com.undecided.template.modules.foo.models.foo.admin.employees;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmployeesRepository extends R2dbcRepository<Employee, Long> {

}
