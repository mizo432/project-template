package com.undecided.projectTemplate.example.business.query.employee;


import com.undecided.primitive.list.Lists2;
import com.undecided.projectTemplate.example.business.command.employee.EmployeesData;
import com.undecided.projectTemplate.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FetchEmployeeQuery {

    private final EmployeesData data;

    public FetchEmployeeQuery(EmployeesData employeesData) {
        data = employeesData;

    }

    @Transactional
    public List<Employee> selectAllEmployees() {
        return Lists2.newArrayList(data.values());

    }

    @Transactional
    public Employee findEmployeeById(SnowflakeId<Employee> id) {
        return data.get(id);

    }

}
