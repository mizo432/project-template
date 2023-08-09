package com.undecided.template.modules.foo.web.foo.admin.employees;

import com.undecided.template.modules.foo.appl.command.admin.employees.InsertEmployeeCommand;
import com.undecided.template.modules.foo.appl.query.foo.admin.employees.FetchingEmployeesQuery;
import com.undecided.template.modules.foo.models.foo.admin.employees.Employee;
import com.undecided.template.shared.entity.SnowflakeId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
@RequestMapping("/foo/admin/employees")
public class EmployeeController {

    private final FetchingEmployeesQuery fetchingEmployeesQuery;
    private final InsertEmployeeCommand insertEmployeeCommand;

    @RequestMapping(method = RequestMethod.GET)
    public String index(final Model model) {
        Flux<Employee> employees = fetchingEmployeesQuery.selectAll();
        IReactiveDataDriverContextVariable reactiveDataDrivenModel =
                new ReactiveDataDriverContextVariable(employees, 1);

        model.addAttribute("employees", reactiveDataDrivenModel);


        return "foo/admin/employees/list";
    }

    @RequestMapping(path = "/{employeeId}", method = RequestMethod.GET)
    public String view(@PathVariable Long employeeId, final Model model) {
        Mono<Employee> employees = fetchingEmployeesQuery.findOneBy(SnowflakeId.of(employeeId));
        model.addAttribute("form", EmployeeForm.createFrom(employees));
        return "foo/admin/employees/view";
    }

    @RequestMapping(path = "/insertForm", method = RequestMethod.GET)
    public String insertForm(final Model model) {
        model.addAttribute("form", new EmployeeForm());
        return "foo/admin/employees/insertForm";

    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("form") EmployeeForm employeeForm, final Model model) {
        insertEmployeeCommand.insert(employeeForm.toEmployee());

        return "redirect:/foo/admin/employees";

    }

    @RequestMapping(path = "/{employeeId}/updateForm", method = RequestMethod.GET)
    public String updateForm(@PathVariable Long employeeId, final Model model) {
        return "foo/admin/employees/updateForm";
    }

    @RequestMapping(path = "/{employeeId}/update", method = RequestMethod.POST)
    public String update(@PathVariable Long employeeId, final Model model) {
        return "redirect:/foo/admin/employees";
    }

    @RequestMapping(path = "/{employeeId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Long employeeId, final Model model) {
        return "redirect:/foo/admin/employees";

    }

}
