package org.venusPj.projectTemplate.modules.example.presentation.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;
import org.venusPj.projectTemplate.modules.example.domain.employee.Employee;
import org.venusPj.projectTemplate.modules.example.domain.employee.EmployeeId;
import org.venusPj.projectTemplate.modules.example.usecase.employee.DeleteEmployeeCommand;
import org.venusPj.projectTemplate.modules.example.usecase.employee.EntityNotFoundException;
import org.venusPj.projectTemplate.modules.example.usecase.employee.FetchEmployeeQuery;
import org.venusPj.projectTemplate.modules.example.usecase.employee.InsertEmployeeCommand;
import org.venusPj.projectTemplate.modules.example.usecase.employee.UpdateEmployeeCommand;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

@Controller
@RequestMapping(path = "/employee")
// @TransactionTokenCheck("admin/employee")
public class EmployeeController {

    private final FetchEmployeeQuery fetchEmployeeQuery;

    private final InsertEmployeeCommand insertEmployeeCommand;
    private final UpdateEmployeeCommand updateEmployeeCommand;

    private final DeleteEmployeeCommand deleteEmployeeCommand;

    public EmployeeController(FetchEmployeeQuery fetchEmployeeQuery,
        InsertEmployeeCommand insertEmployeeCommand, UpdateEmployeeCommand updateEmployeeCommand,
        DeleteEmployeeCommand deleteEmployeeCommand) {
        this.fetchEmployeeQuery = fetchEmployeeQuery;

        this.insertEmployeeCommand = insertEmployeeCommand;
        this.updateEmployeeCommand = updateEmployeeCommand;
        this.deleteEmployeeCommand = deleteEmployeeCommand;
    }

    // display list of employees
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", fetchEmployeeQuery.selectAllEmployees());
        return "/employee/index";
    }

    @GetMapping("/showNewEmployeeForm")
//    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/new_employee";
    }

    @PostMapping("/saveEmployee")
//    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String postEmployee(@ModelAttribute("employee") Employee employee) {
        if (Strings2.isEmpty(employee.getFirstName())) {
            ResultMessages resultMessages = ResultMessages.error()
                .add(ResultMessage.fromCode("EAB0001"));
            throw new EntityNotFoundException(resultMessages);
        }
        // save employee to database
        insertEmployeeCommand.saveEmployee(employee);

        return "redirect:/employee/";
    }

    public String putEmployee(@ModelAttribute("employee") Employee employee) {

        // save employee to database
        updateEmployeeCommand.saveEmployee(employee);
        return "redirect:/employee/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
        EmployeeId employeeId = EmployeeId.of(id);
        // get employee from the service
        Employee employee = fetchEmployeeQuery.findEmployeeById(employeeId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "employee/update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
//    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String deleteEmployee(@PathVariable(value = "id") EmployeeId id) {

        // call delete employee method
        this.deleteEmployeeCommand.deleteEmployeeById(id);
        return "redirect:/employee/";
    }

}
