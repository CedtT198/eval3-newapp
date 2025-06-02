package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.PurchaseOrderService;
import com.eval2.newapp.services.SupplierService;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrderController {
    
    @Autowired
    PurchaseOrderService poService;
    @Autowired
    SupplierService supplierService;

    @GetMapping("/filterbysupplier_and_status")
    public String filterbysupplier_and_status(RedirectAttributes redirectAttributes, @RequestParam("supplierName") String supplierName, @RequestParam("status") String status) throws Exception {
        if (supplierName.equals("All") && status.equals("All")) {
            return "redirect:/purchase_order/";
        }
        else if (supplierName.equals("All") && !status.equals("All")) { // status no filtre
            redirectAttributes.addFlashAttribute("orders", poService.findByStatus(status));
            redirectAttributes.addFlashAttribute("filter_name", "Status: "+status);
        }
        else if (!supplierName.equals("All") && status.equals("All")) { // supplier no filtre
            redirectAttributes.addFlashAttribute("orders", poService.findBySupplierName(supplierName));
            redirectAttributes.addFlashAttribute("filter_name", "Supplier: "+supplierName);
        }
        else {
            redirectAttributes.addFlashAttribute("orders", poService.findBySupplierNameAndStatus(supplierName, status));
            redirectAttributes.addFlashAttribute("filter_name", "Status: "+status+" & Supplier: "+supplierName);
        }
        return "redirect:/purchase_order/index";
    }

    @GetMapping("/")
    public String goToList(RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("orders", poService.findAll());
        redirectAttributes.addFlashAttribute("filter_name", "All");
        return "redirect:/purchase_order/index";
    }
    
    @GetMapping("/index")
    public String index(Model model) throws Exception {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("body", "purchase_order/list");
        return "layout";
    }
}
