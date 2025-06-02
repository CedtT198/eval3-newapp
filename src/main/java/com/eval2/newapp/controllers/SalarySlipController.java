package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.ExportService;
import com.eval2.newapp.services.SalarySlipService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/salary/slip")
public class SalarySlipController {

    @Autowired
    SalarySlipService salarySlipService;
    @Autowired
    ExportService exportService;
    
    @GetMapping("/exportPDF")
    public String exportPDF(RedirectAttributes redirectAttributes, @RequestParam("salRef") String salRef, HttpServletResponse response) throws Exception {
        try {
            exportService.printToPdfSalarySlip(salRef, response);
            // redirectAttributes.addFlashAttribute("success", salRef+" exported successfuly.");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/salary/slip/list";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("salaries", salarySlipService.findAll());
        model.addAttribute("body", "salary/slip/list");
        return "layout";
    }
}
