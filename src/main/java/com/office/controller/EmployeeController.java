package com.office.controller;

import com.office.dao.EmployeeDAO;
import com.office.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@RestController("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        employeeDAO.save(employee);
    }

    @RequestMapping("/{id}")
    public Employee find(@PathVariable long id) throws Throwable {
        return employeeDAO.findById(id).orElseThrow(() -> new Exception("Employeee not found!"));

    }

}
