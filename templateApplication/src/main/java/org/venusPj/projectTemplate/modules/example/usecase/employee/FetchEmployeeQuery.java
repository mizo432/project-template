package org.venusPj.projectTemplate.modules.example.usecase.employee;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.modules.example.domain.employee.EmployeeId;

@Service
public class FetchEmployeeQuery {

    private final EmployeesData data;

    public FetchEmployeeQuery(EmployeesData employeesData) {
        data = employeesData;

    }

    @Transactional
    public List<Employee> selectAllEmployees() {
        return newArrayList(data.values());

    }

    @Transactional
    public Employee findEmployeeById(EmployeeId id) {
        return data.get(id);

    }

}
