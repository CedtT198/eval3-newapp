package com.eval2.newapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eval2.newapp.models.ApiResponse;
import com.eval2.newapp.services.DatabaseService;

@Controller
@RequestMapping("/database_management")
public class DatabaseController {

    @Autowired
    public DatabaseService dbService;
    
    @PostMapping("/importCSV")
    public String settings(Model model, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3) {
        try {
            ApiResponse response = dbService.importCSV(file1, file2, file3);
            model.addAttribute(response.getMessage().getStatus(), response.getMessage().getContent());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "database/database");
        return "layout";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("body", "database/database");
        return "layout";
    }

    @GetMapping("/resetDb")
    public String resetDb(Model model) {
        System.out.println("API CALLED");
        try {       
            ApiResponse response = dbService.resetDatabase();
            model.addAttribute(response.getMessage().getStatus(), response.getMessage().getContent());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("body", "database/database");
        return "layout";
    }
}
