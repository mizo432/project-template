package com.undecided.projectTemplate.modules.example.usecase.employee;


import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.primitive.list.Lists2;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

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
    public Employee findEmployeeById(Identifier<Employee> id) {
        return data.get(id);

    }

}
