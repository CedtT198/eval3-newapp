package com.eval2.newapp.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eval2.newapp.models.SalaryDetail;
import com.eval2.newapp.services.SalaryDetailService;

@Controller
@RequestMapping("/salary/detail")
public class SalaryDetailController {
    
    @Autowired
    SalaryDetailService salaryDetailService;

    @GetMapping("/filterbydate")
    public String filterbydate(Model model, @RequestParam("date") LocalDate date) throws Exception {
        try {
            System.out.println("Input Date: "+date.toString());
            List<SalaryDetail> details = salaryDetailService.findAll(date);
            List<Double> total = salaryDetailService.sum(details);
            List<String> columns = salaryDetailService.getLongestColumns(details);
            // System.out.println(details.size());
            // for (SalaryDetail d : details) {
            //     System.out.println(d.getEmploye().getName());
            //     System.out.println(d.getSalaryAssignment().getName());
            // }
            model.addAttribute("details", details);
            model.addAttribute("columns", columns);
            model.addAttribute("sum", total);
            model.addAttribute("filter_name", "Date ("+date.getMonth()+" "+date.getYear()+")");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "salary/detail/list");
        return "layout";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("details", new ArrayList<>());
        model.addAttribute("sum", new ArrayList<>());
        model.addAttribute("columns", new ArrayList<>());
        model.addAttribute("filter_name", "No Filter");
        model.addAttribute("body", "salary/detail/list");
        return "layout";
    }
}
