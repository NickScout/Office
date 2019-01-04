package com.office.controller;

import com.office.entity.Employee;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiEnter {
    @PostMapping("/login")
    public void loign(@RequestBody Employee employee) {
        System.out.println(employee.toString());

    }
}
