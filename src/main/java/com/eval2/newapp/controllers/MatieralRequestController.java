package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.services.MaterialRequestService;

@Controller
@RequestMapping("/matieral_request")
public class MatieralRequestController {
    
    @Autowired
    MaterialRequestService mrs;

    @GetMapping("/")
    public String goToList(RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("materials", mrs.findAll());
        return "redirect:/rfq/index";
    }
    
    @GetMapping("/index")
    public String index(Model model) throws Exception {
        model.addAttribute("body", "rfq/list");
        return "layout";
    }
}
