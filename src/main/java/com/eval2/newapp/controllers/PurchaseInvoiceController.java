package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.PurchaseInvoiceService;

@Controller
@RequestMapping("/purchase_invoice")
public class PurchaseInvoiceController {
    
    @Autowired
    PurchaseInvoiceService piService;
    
    @PostMapping("/submit")
    public String submit(RedirectAttributes redirectAttributes, @RequestParam("name") String name, @RequestParam("docstatus") String docstatus,
    @RequestParam("status") String status) throws Exception {
        try {
            piService.submit(name, docstatus, status);
            redirectAttributes.addFlashAttribute("success", "Purchase invoice "+name+" submitted successfuly.");
        } catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/purchase_invoice/update_submission?name="+name;
    }

    @GetMapping("/update_submission")
    public String update_submission(Model model, @RequestParam("name") String name) throws Exception {
        model.addAttribute("invoice", piService.find(name));
        model.addAttribute("body", "purchase_invoice/submission");
        return "layout";
    }

    @GetMapping("/filter")
    public String filter(RedirectAttributes redirectAttributes, @RequestParam("status") String status) throws Exception {
        if (status.equals("All")) {
            return "redirect:/purchase_invoice/";
        }
        else { 
            redirectAttributes.addFlashAttribute("invoices", piService.findByStatus(status));
            redirectAttributes.addFlashAttribute("filter_name", "Status: "+status);
        }
        return "redirect:/purchase_invoice/index";
    }

    @GetMapping("/")
    public String goToList(RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("invoices", piService.findAll());
        redirectAttributes.addFlashAttribute("filter_name", "All");
        return "redirect:/purchase_invoice/index";
    }
    
    @GetMapping("/index")
    public String index(Model model) throws Exception {
        model.addAttribute("body", "purchase_invoice/list");
        return "layout";
    }
}
