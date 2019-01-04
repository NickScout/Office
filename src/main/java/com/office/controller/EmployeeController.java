package com.office.controller;

import com.office.entity.Employee;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")

public class EmployeeController extends AController<Employee> { }
