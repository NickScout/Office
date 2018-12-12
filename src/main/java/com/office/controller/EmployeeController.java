package com.office.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.office.dao.EmployeeDAO;
import com.office.entity.Employee;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired

    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        return "Hello woeld!";
    }

    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        employeeDAO.save(employee);
    }

    @RequestMapping("/get")
    public Employee find(@RequestParam("id") long id) throws Throwable {
        return employeeDAO.findById(id).orElseThrow(() -> new Exception("Employeee not found!"));

    }

}
