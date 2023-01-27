package com.undecided.projectTemplate.modules.example.presentation.web.employee;

import com.undecided.projectTemplate.modules.example.business.command.employee.DeleteEmployeeCommand;
import com.undecided.projectTemplate.modules.example.business.command.employee.InsertEmployeeCommand;
import com.undecided.projectTemplate.modules.example.business.command.employee.UpdateEmployeeCommand;
import com.undecided.projectTemplate.modules.example.business.query.employee.FetchEmployeeQuery;
import com.undecided.projectTemplate.modules.example.domain.employee.Employee;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
//    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String postEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        insertEmployeeCommand.saveEmployee(employee);

        return "redirect:/employee";
    }

    public String putEmployee(@ModelAttribute("employee") Employee employee) {

        // save employee to database
        updateEmployeeCommand.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Identifier<Employee> employeeId,
        Model model) {
        // get employee from the service
        Employee employee = fetchEmployeeQuery.findEmployeeById(employeeId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "employee/update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
//    @TransactionTokenCheck(type = TransactionTokenType.CHECK)
    public String deleteEmployee(@PathVariable(value = "id") Identifier<Employee> id) {
        // call delete employee method
        this.deleteEmployeeCommand.deleteEmployeeById(id);
        return "redirect:/employee";

    }

}
