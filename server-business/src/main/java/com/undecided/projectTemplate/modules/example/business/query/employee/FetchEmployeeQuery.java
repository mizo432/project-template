package com.undecided.projectTemplate.modules.example.business.query.employee;


import com.undecided.primitive.list.Lists2;
import com.undecided.projectTemplate.modules.example.business.command.employee.EmployeesData;
import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Employee findEmployeeById(UildIdentifier<Employee> id) {
        return data.get(id);

    }

}
