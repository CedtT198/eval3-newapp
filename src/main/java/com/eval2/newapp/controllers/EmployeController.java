package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.EmployeService;
import com.eval2.newapp.services.SalaryAssignmentService;

@Controller
@RequestMapping("/employee")
public class EmployeController {

    @Autowired
    EmployeService employeService;
    @Autowired
    SalaryAssignmentService salaryAssignmentService;
    
    @GetMapping("/details")
    public String details(Model model, @RequestParam("empRef") String empRef) throws Exception {
        model.addAttribute("employee", employeService.findByEmployeeRef(empRef));
        model.addAttribute("salaries", salaryAssignmentService.findAllByEmp(empRef));
        model.addAttribute("body", "employee/fiche");
        return "layout";
    }

    @GetMapping("/filter")
    public String filter(Model model, @RequestParam("name") String name) throws Exception {
        model.addAttribute("employees", employeService.findByName(name));
        model.addAttribute("filter_name", name);
        model.addAttribute("body", "employee/list");
        return "layout";
    }
    
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("employees", employeService.findAll());
        model.addAttribute("filter_name", "All");
        model.addAttribute("body", "employee/list");
        return "layout";
    }
}
