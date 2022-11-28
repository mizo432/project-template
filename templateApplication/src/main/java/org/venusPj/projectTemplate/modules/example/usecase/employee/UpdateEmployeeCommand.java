package org.venusPj.projectTemplate.modules.example.usecase.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

@Service
public class UpdateEmployeeCommand {

    private final EmployeesData data;

    public UpdateEmployeeCommand(EmployeesData employeesData) {
        this.data = employeesData;
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        if (Strings2.isEmpty(employee.getFirstName())) {
            ResultMessages resultMessages = ResultMessages.error()
                .add(ResultMessage.fromCode("EAB0001"));
            throw new EntityNotFoundException(resultMessages);
        }
        data.put(employee.getId(), employee);

    }

}
