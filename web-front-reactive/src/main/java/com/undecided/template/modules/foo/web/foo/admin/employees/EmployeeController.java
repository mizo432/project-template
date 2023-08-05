package com.undecided.template.modules.foo.web.foo.admin.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
@RequestMapping("/foo/admin/employees")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(final Model model) {
        return "foo/admin/employees/list";
    }

    @RequestMapping(path = "/{employeeId}", method = RequestMethod.GET)
    public String view(@PathVariable Long employeeId, final Model model) {
        return "foo/admin/employees/view";
    }

    @RequestMapping(path = "/insertForm", method = RequestMethod.GET)
    public String insertForm(final Model model) {
        return "foo/admin/employees/insertForm";

    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public String insert(final Model model) {
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
