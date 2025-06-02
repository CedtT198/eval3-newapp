package com.eval2.newapp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.SalaryRegisterService;

@Controller
@RequestMapping("/salary/register")
public class SalaryRegisterController {
    
    @Autowired
    SalaryRegisterService salaryRegisterService;

    @GetMapping("/filterbydate")
    public String exportPDF(Model model, @RequestParam("begin") LocalDate begin, @RequestParam("end") LocalDate end) throws Exception {
        try {
            model.addAttribute("registers", salaryRegisterService.findAllBetweenDate(begin.toString(), end.toString()));
            model.addAttribute("filter_name", "Date ("+begin.toString()+" to "+end.toString()+")");
            // model.addAttribute("success", salRef+" exported successfuly.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "salary/register/list");
        return "layout";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("registers", salaryRegisterService.findAllBetweenDate("2000-01-01", "2064-01-01"));
        model.addAttribute("filter_name", "All");
        model.addAttribute("body", "salary/register/list");
        return "layout";
    }
}
