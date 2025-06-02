package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eval2.newapp.models.Payment;
import com.eval2.newapp.services.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // @PostMapping("/cancel")
    // public String cancel(Model model, @ModelAttribute Payment payment) {
    //     try {
    //        payment = paymentService.cancel(payment);
    //         model.addAttribute("success", payment.getName()+" updated successfuly.");
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

    // @PostMapping("/submit")
    // public String submit(Model model, @ModelAttribute Payment payment) {
    //     try {
    //         payment = paymentService.submit(payment);
    //         model.addAttribute("success", payment.getName()+" updated successfuly.");
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
    
    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Payment payment, @RequestParam("reference_name") String reference_name) {
        try {
                payment = paymentService.save(reference_name, payment);
                model.addAttribute("success", payment.getName()+" paid successfuly.");
        }
        catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("payment", payment);
        model.addAttribute("body", "payment/insert");
        return "layout";
    }

    @GetMapping("/")
    public String goToList(Model model) throws Exception {
        model.addAttribute("payments", paymentService.findAll());
        model.addAttribute("body", "payment/list");
        return "layout";
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam("name") String name, @RequestParam("posting_date") String posting_date,
    @RequestParam("supplier_name") String supplier_name, @RequestParam("grand_total") double amount, @RequestParam("status") String status) throws Exception {
        Payment payment = new Payment();
        payment.setTitle(supplier_name);
        payment.setStatus(status);
        payment.setNaming_series("ACC-PAY-.YYYY.-");
        payment.setPosting_date(posting_date);
        payment.setParty_type("Supplier");
        payment.setParty_name(supplier_name);
        payment.setParty(supplier_name);
        payment.setPaid_amount(amount);
        payment.setReceived_amount(amount);
        payment.setTotal_allocated_amount(amount);
        payment.setPaid_to_account_type("Payable");
        payment.setPaid_from_account_currency("EUR");
        payment.setPaid_to_account_currency("EUR");
        payment.setReference_date(posting_date);
        model.addAttribute("reference_name", name);
        model.addAttribute("payment", payment);
        model.addAttribute("body", "payment/insert");
        return "layout";
    }
}
