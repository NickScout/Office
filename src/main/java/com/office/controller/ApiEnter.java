package com.office.controller;

import com.office.entity.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiEnter {

    @RequestMapping("/login")
    public String loign(Model model) {
        model.addAttribute("employee", new Employee());
        return "redirect:/index";
    }
}
