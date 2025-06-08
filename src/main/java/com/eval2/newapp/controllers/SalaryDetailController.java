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

    @GetMapping("/dashboard/filterbydate")
    public String filterdashboardbydate(Model model, @RequestParam("year") int year) throws Exception {
    try {
        List<SalaryDetail> details = salaryDetailService.findAllByYearGroupByMonth(year);
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        model.addAttribute("currency", "EUR");
        model.addAttribute("months", months);
        model.addAttribute("bases", salaryDetailService.exctractBase(details));
        model.addAttribute("earnings", salaryDetailService.extractCompTypeAmount(details, "earnings"));
        model.addAttribute("deductions", salaryDetailService.extractCompTypeAmount(details, "deductions"));
        model.addAttribute("total_base", salaryDetailService.sumSalaryBase(details));
        model.addAttribute("total_earnings", salaryDetailService.sumSalaryComponent(details, "earnings"));
        model.addAttribute("total_deductions", salaryDetailService.sumSalaryComponent(details, "deductions"));
        model.addAttribute("details", details);
        model.addAttribute("year", year);
        model.addAttribute("filter_name", "Date ("+year+")");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "salary/detail/dashboard");
        return "layout";
    }
    
    // @GetMapping("/dashboard")
    // public String dashboard(Model model) throws Exception {
    //     model.addAttribute("filter_name", "No Filter");
    //     model.addAttribute("body", "salary/detail/dashboard");
    //     return "layout";
    // }

    @GetMapping("/filterbyyear")
    public String filterbyyear(Model model, @RequestParam("year") int year) throws Exception {
        try {
            List<SalaryDetail> details = salaryDetailService.findAllByYearGroupByMonth(year);
            List<String> columns = salaryDetailService.getColumns(details);
            // double[] total = salaryDetailService.sum(details);
            
            model.addAttribute("columns", columns);
            model.addAttribute("details", details);
            // model.addAttribute("sum", total);
            model.addAttribute("filter_name", "Date ("+year+")");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "salary/detail/statistics");
        return "layout";
    }
    
    @GetMapping("/statistics")
    public String statistics(Model model) throws Exception {
        model.addAttribute("columns", new ArrayList<>());
        model.addAttribute("details", new ArrayList<>());
        model.addAttribute("sum", new ArrayList<>());
        model.addAttribute("filter_name", "No Filter");
        model.addAttribute("body", "salary/detail/statistics");
        return "layout";
    }

    @GetMapping("/filterbymonth")
    public String filterbymonth(Model model, @RequestParam("date") LocalDate date) throws Exception {
        try {
            List<SalaryDetail> details = salaryDetailService.findAllFilterByMonth(date);
            List<String> columns = salaryDetailService.getColumns(details);
            double[] total = salaryDetailService.sum(details);
            
            model.addAttribute("total_earnings", salaryDetailService.sumSalaryComponent(details, "earnings"));
            model.addAttribute("total_deductions", salaryDetailService.sumSalaryComponent(details, "deductions"));
            model.addAttribute("columns", columns);
            model.addAttribute("details", details);
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
        model.addAttribute("columns", new ArrayList<>());
        model.addAttribute("details", new ArrayList<>());
        model.addAttribute("sum", new ArrayList<>());
        model.addAttribute("filter_name", "No Filter");
        model.addAttribute("body", "salary/detail/list");
        return "layout";
    }
}
