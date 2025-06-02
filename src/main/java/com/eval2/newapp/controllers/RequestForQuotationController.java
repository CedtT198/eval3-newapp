package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eval2.newapp.models.Payment;
import com.eval2.newapp.services.RequestForQuotationService;
import com.eval2.newapp.services.SupplierService;

@Controller
@RequestMapping("/rfq")
public class RequestForQuotationController {
    
    @Autowired
    RequestForQuotationService rfqService;
    @Autowired
    SupplierService supplierService;
    
    // @PostMapping("/save")
    // public String save(Model model, @ModelAttribute Payment payment, @RequestParam("reference_name") String reference_name) {
    //     try {
    //             payment = paymentService.save(reference_name, payment);
    //             model.addAttribute("success", payment.getName()+" paid successfuly.");
    //     }
    //     catch (Exception e) {
    //         System.out.println("Error message: "+e.getMessage());
    //         e.printStackTrace();
    //         model.addAttribute("error", e.getMessage());
    //     }

    //     model.addAttribute("payment", payment);
    //     model.addAttribute("body", "payment/insert");
    //     return "layout";
    // }

    @GetMapping("/")
    public String goToList(RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("rfq", rfqService.findAll());
        return "redirect:/rfq/index";
    }
    
    @GetMapping("/index")
    public String index(Model model) throws Exception {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("body", "rfq/list");
        return "layout";
    }
}
