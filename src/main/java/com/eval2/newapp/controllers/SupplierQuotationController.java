package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.ItemService;
import com.eval2.newapp.services.SupplierQuotationService;
import com.eval2.newapp.services.SupplierService;

@Controller
@RequestMapping("/supplier_quotation")
public class SupplierQuotationController {
    
    @Autowired
    SupplierQuotationService supplierQuotationService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    ItemService itemService;
    

    @GetMapping("/filterbysupplier")
    public String filterbysupplier(RedirectAttributes redirectAttributes, @RequestParam("supplierName") String supplierName) throws Exception {
        redirectAttributes.addFlashAttribute("supplierquotations", supplierQuotationService.findBySupplierName(supplierName));
        redirectAttributes.addFlashAttribute("filter_name", supplierName);
        return "redirect:/supplier_quotation/index";
    }

    @GetMapping("/")
    public String goToList(RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("supplierquotations", supplierQuotationService.findAll());
        redirectAttributes.addFlashAttribute("filter_name", "All");
        return "redirect:/supplier_quotation/index";
    }
    
    @GetMapping("/index")
    public String index(Model model) throws Exception {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("body", "quotation/list");
        return "layout";
    }
}
