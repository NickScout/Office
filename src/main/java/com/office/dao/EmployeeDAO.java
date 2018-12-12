package com.office.dao;

import com.office.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Long> { }
