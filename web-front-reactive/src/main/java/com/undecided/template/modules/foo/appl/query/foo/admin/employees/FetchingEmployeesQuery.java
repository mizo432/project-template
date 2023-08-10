package com.undecided.template.modules.foo.appl.query.foo.admin.employees;

import com.undecided.template.modules.foo.models.foo.admin.employees.Employee;
import com.undecided.template.modules.foo.models.foo.admin.employees.EmployeesRepository;
import com.undecided.template.shared.entity.SnowflakeId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class FetchingEmployeesQuery {
    private final EmployeesRepository employeesRepository;

    public Flux<Employee> selectAll() {
        return employeesRepository.findAll();
    }

    public Mono<Employee> findOneBy(SnowflakeId id) {
        return employeesRepository.findById(id.getValue());

    }
}
