package com.eval2.newapp.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.models.Employe;
import com.eval2.newapp.models.SalaryAssignment;
import com.eval2.newapp.models.SalaryDetailDTO;
import com.eval2.newapp.models.SalarySlip;
import com.eval2.newapp.models.SalaryStructure;
import com.eval2.newapp.services.EmployeService;
import com.eval2.newapp.services.ExportService;
import com.eval2.newapp.services.SalaryAssignmentService;
import com.eval2.newapp.services.SalaryComponentsService;
import com.eval2.newapp.services.SalaryDetailService;
import com.eval2.newapp.services.SalarySlipService;
import com.eval2.newapp.services.SalaryStructureService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/salary/slip")
public class SalarySlipController {

    @Autowired
    SalarySlipService salarySlipService;
    @Autowired
    EmployeService employeService;
    @Autowired
    ExportService exportService;
    @Autowired
    SalaryAssignmentService salaryAssignmentService;
    @Autowired
    SalaryStructureService salaryStructureService;
    @Autowired
    SalaryComponentsService salaryComponentsService;
    @Autowired
    SalaryDetailService salaryDetailService;
    
    @PostMapping("/filtreremp")
    public String filtreremp(Model model, @RequestParam("comp") String comp, @RequestParam("condition") String condition, @RequestParam("amount") double amount) throws Exception { 
        List<SalaryDetailDTO> salaryDTO = salaryDetailService.findAllFilterByComponentCondition(comp, amount, condition);
        List<SalarySlip> salarySlips = new ArrayList<>();
        if (salaryDTO.size() != 0) {
            salarySlips = salarySlipService.findSalarySlipFromDetails(salaryDTO);
            model.addAttribute("success", "Filtered successfuly.");
        }
        else {
            model.addAttribute("warning", "No employee(s) with <strong>`Salary Slip`</strong> found within <strong>`Salary Component`='"+comp+"' "+condition+" "+amount+"</strong>.");    
        }
        System.out.println("\nFINAL SALARY SLIPS"+salarySlips+"\n");
        model.addAttribute("components", salaryComponentsService.findAll());
        model.addAttribute("slips", salarySlips);
        model.addAttribute("body", "salary/slip/search");
        return "layout";
    }

    @GetMapping("/search")
    public String search(Model model) throws Exception { 
        model.addAttribute("components", salaryComponentsService.findAll());
        model.addAttribute("slips", new ArrayList<>());
        model.addAttribute("body", "salary/slip/search");
        return "layout";
    }
    
    @PostMapping("/updateMultiple")
    // public String updateMultiple(RedirectAttributes redirectAttributes, @RequestParam("comp") String comp, @RequestParam("condition") String condition,
    // @RequestParam("amount") double amount, @RequestParam("new_amount") double new_amount, @RequestParam("start_date") LocalDate start_date, @RequestParam("end_date") LocalDate end_date) throws Exception { 
    public String updateMultiple(RedirectAttributes redirectAttributes, @RequestParam("comp") String comp, @RequestParam("condition") String condition,
    @RequestParam("amount") double amount, @RequestParam("new_amount") double new_amount, @RequestParam("choice") String choice, @RequestParam("value") double value) throws Exception { 
        // List<SalaryDetailDTO> salaryDTO = salaryDetailService.findAllFilterByComponentCondition(comp, amount, condition, start_date, end_date);
        List<SalaryDetailDTO> salaryDTO = salaryDetailService.findAllFilterByComponentCondition(comp, amount, condition);
        if (salaryDTO.size() != 0) {
            List<SalarySlip> salarySlips = salarySlipService.findSalarySlipFromDetails(salaryDTO);
            int[] record = salarySlipService.updateSalary(salarySlips, new_amount, choice, value);
            redirectAttributes.addFlashAttribute("success", record[0]+" <strong>`Salary Structure Assignment`</strong> successfuly updated.<br>"+record[1]+" <strong>`Salary Slip`</strong> successfuly updated.");
        }
        else {
            redirectAttributes.addFlashAttribute("warning", "No employee(s) with <strong>`Salary Slip`</strong> found within <strong>`Salary Component`='"+comp+"' "+condition+" "+amount+"</strong>.");    
        }
        return "redirect:/salary/slip/filterByComponents";
    }

    @GetMapping("/filterByComponents")
    public String filterByComponents(Model model) throws Exception { 
        model.addAttribute("components", salaryComponentsService.findAll());
        model.addAttribute("body", "salary/slip/update_multiple");
        return "layout";
    }

    @PostMapping("/generateMultipleWithOption")
    public String generateMultiple(RedirectAttributes redirectAttributes, @RequestParam("start_date") LocalDate start_date, @RequestParam("end_date") LocalDate end_date,
    @RequestParam("emp") String emp, @RequestParam("amount") Double amount, @RequestParam("ecrase") String ecrase, @RequestParam("avg") String avg) throws Exception { 
        System.out.println("ecraser ="+ecrase);
        System.out.println("avg = "+avg);
        try {
            List<SalaryAssignment> assignment = salaryAssignmentService.findLastBefore(start_date.toString(), emp);
            System.out.println(assignment.toString());
            SalaryStructure salaryStructure = salaryStructureService.findAll().get(0); 
            System.out.println(salaryStructure.getName());
            if (assignment.size() != 0) {   
                if (amount == null || amount <= 0) {
                    redirectAttributes.addFlashAttribute("error", "Please enter a valid new amount != null and != 0.");
                }
                else {
                    System.out.println("Misy salary assignment");

                    Double salary = assignment.get(0).getBase();
                    if (avg.equals("oui")) {
                        System.out.println("Mampiasa moyenne");
                        if (salaryAssignmentService.getAvgBefore(start_date) != null) {
                            salary = salaryAssignmentService.getAvgBefore(start_date);
                        }
                    }
                    
                    int record = salarySlipService.generateWithAssignment(start_date, end_date, emp, salary, salaryStructure, ecrase);
                    // int record = salarySlipService.generate(start_date, end_date, emp, assignment.get(0).getBase(), salaryStructure, ecrase);
                    redirectAttributes.addFlashAttribute("success", record+" salary slip generated succesfuly.");
                }
            }
            else {
                System.out.println("tsy misy salary assignment");

                double salary = amount;
                if (avg.equals("oui")) {
                    System.out.println("Mampiasa moyenne");
                    if (salaryAssignmentService.getAvgBefore(start_date) != null) {
                        salary = salaryAssignmentService.getAvgBefore(start_date);
                    }
                }
                // salaryAssignmentService.save(start_date, emp, amount, salaryStructure.getName());
                int record = salarySlipService.generateWithAssignment(start_date, end_date, emp, amount, salaryStructure, ecrase);
                redirectAttributes.addFlashAttribute("success", record+" <strong>`Salary Slip`</strong> and <strong>`Salary Structure Assignment`<strong/> generated succesfuly.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/salary/slip/generate";
    }
    
    // @PostMapping("/generateMultipleWithOption")
    // public String generateMultiple(RedirectAttributes redirectAttributes, @RequestParam("start_date") LocalDate start_date, @RequestParam("end_date") LocalDate end_date,
    // @RequestParam("emp") String emp, @RequestParam("amount") Double amount, @RequestParam("ecrase") String ecrase) throws Exception { 
    //     System.out.println(ecrase);
    //     try {
    //         List<SalaryAssignment> assignment = salaryAssignmentService.findLastBefore(start_date.toString(), emp);
    //         System.out.println(assignment.toString());
    //         SalaryStructure salaryStructure = salaryStructureService.findAll().get(0); 
    //         System.out.println(salaryStructure.getName());
    //         if (assignment.size() != 0) {   
    //             if (amount == null || amount <= 0) {
    //                 redirectAttributes.addFlashAttribute("error", "Please enter a valid new amount != null and != 0.");
    //             }
    //             else {
    //                 System.out.println("Misy salary assignment");
    //                 int record = salarySlipService.generateWithAssignment(start_date, end_date, emp, assignment.get(0).getBase(), salaryStructure, ecrase);
    //                 // int record = salarySlipService.generate(start_date, end_date, emp, assignment.get(0).getBase(), salaryStructure, ecrase);
    //                 redirectAttributes.addFlashAttribute("success", record+" salary slip generated succesfuly.");
    //             }
    //         }
    //         else {
    //             System.out.println("tsy misy salary assignment");
    //             // salaryAssignmentService.save(start_date, emp, amount, salaryStructure.getName());
    //             int record = salarySlipService.generateWithAssignment(start_date, end_date, emp, amount, salaryStructure, ecrase);
    //             redirectAttributes.addFlashAttribute("success", record+" <strong>`Salary Slip`</strong> and <strong>`Salary Structure Assignment`<strong/> generated succesfuly.");
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         redirectAttributes.addFlashAttribute("error", e.getMessage());
    //     }
    //     return "redirect:/salary/slip/generate";
    // }

    @PostMapping("/generateMultiple")
    public String generateMultiple(RedirectAttributes redirectAttributes, @RequestParam("start_date") LocalDate start_date, @RequestParam("end_date") LocalDate end_date,
    @RequestParam("emp") String emp, @RequestParam("amount") Double amount) throws Exception { 
        try {
            List<SalaryAssignment> assignment = salaryAssignmentService.findLastBefore(start_date.toString(), emp);
            System.out.println(assignment.toString());
            SalaryStructure salaryStructure = salaryStructureService.findAll().get(0); 
            System.out.println(salaryStructure.getName());
            if (assignment.size() != 0) {   
                if (amount == null || amount <= 0) {
                    redirectAttributes.addFlashAttribute("error", "Please enter a valid new amount != null and != 0.");
                }
                else {
                    System.out.println("Misy salary assignment");
                    int record = salarySlipService.generate(start_date, end_date, emp, assignment.get(0).getBase(), salaryStructure);
                    redirectAttributes.addFlashAttribute("success", record+" salary slip generated succesfuly.");
                }
            }
            else {
                System.out.println("tsy misy salary assignment");
                // salaryAssignmentService.save(start_date, emp, amount, salaryStructure.getName());
                int record = salarySlipService.generateWithAssignment(start_date, end_date, emp, amount, salaryStructure);
                redirectAttributes.addFlashAttribute("success", record+" <strong>`Salary Slip`</strong> and <strong>`Salary Structure Assignment`<strong/> generated succesfuly.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/salary/slip/generate";
    }

    @GetMapping("/generate")
    public String generate(Model model) throws Exception { 
        model.addAttribute("employees", employeService.findAll());
        model.addAttribute("body", "salary/slip/generate");
        return "layout";
    }
    
    @PostMapping("/insert")
    public String insert(RedirectAttributes redirectAttributes, @RequestParam("empRef") String empRef, @RequestParam("salStruct") String salStruct, @RequestParam("postingDate") LocalDate postingDate) {
        try {
            Employe emp = employeService.findByEmployeeRef(empRef);
            
            postingDate = postingDate.plusDays(1);

            SalarySlip salarySlip = new SalarySlip();
            salarySlip.setEmployee(emp.getEmployee());
            // salarySlip.setEmployee_name(emp.getEmployee_name());
            // salarySlip.setCompany(emp.getCompany());
            // salarySlip.setCurrency(emp.getSalary_currency());
            salarySlip.setPosting_date(postingDate);
            salarySlip.setPayroll_frequency("Monthly"); 
            salarySlip.setSalary_structure(salStruct);
            salarySlip.setStart_date(postingDate);
            salarySlip.setEnd_date(postingDate.plusMonths(1));
            salarySlip.setExchange_rate(1);
            salarySlip.setDocstatus(1);

            redirectAttributes.addFlashAttribute("salaries", salarySlipService.save(salarySlip));
            redirectAttributes.addFlashAttribute("success", "Salary Slip inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/employee/details?empRef="+empRef;
    }

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
