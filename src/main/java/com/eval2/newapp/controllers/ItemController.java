package com.eval2.newapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eval2.newapp.models.Item;
import com.eval2.newapp.services.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/update_status")
    public String updateStatus(RedirectAttributes redirectAttributes, @RequestParam("name") String name,
    @RequestParam("docstatus") int docstatus, @RequestParam("status") String status, @RequestParam("title") String title,
    @RequestParam("default_status") String default_status) {
        
        try {
            itemService.updateStatus(name, docstatus, status); 
            redirectAttributes.addFlashAttribute("success", "Supplier quotation "+status+".");
            return "redirect:/item/find_all?name=" + name + "&status=" + status + "&title=" + title;
        }
        catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/item/find_all?name=" + name + "&status=" + default_status + "&title=" + title;
    }


    @PostMapping("/update_price")
    public String updatePrice(RedirectAttributes redirectAttributes, @RequestParam("item_code") String item_code, @RequestParam("rate") double rate,
    @RequestParam("quantity") double quantity, @RequestParam("name") String name, @RequestParam("status") String status,
    @RequestParam("title") String title) {

        try {
            itemService.updatePrice(name, item_code, rate, quantity);
            redirectAttributes.addFlashAttribute("success", "Price updated successfuly.");
        }
        catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        // return "redirect:/item/find_all?name=" + name + "&status=" + status + "&title=" + title;
        return "redirect:/supplier_quotation/";
    }


    @GetMapping("/find_all")
    public String findAll(Model model, @RequestParam("name") String name, @RequestParam("status") String status, @RequestParam("title") String title) throws Exception {
        List<Item> items = itemService.findAll(name);
        model.addAttribute("name", name);
        model.addAttribute("status", status);
        model.addAttribute("title", title);
        model.addAttribute("items", items);
        model.addAttribute("sumQty", itemService.getSumQty(items));
        model.addAttribute("sumAmount", itemService.getSumAmount(items));
        model.addAttribute("body", "quotation/item");
        return "layout";
    }
}
