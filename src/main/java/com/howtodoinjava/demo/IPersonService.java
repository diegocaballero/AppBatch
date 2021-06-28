package com.howtodoinjava.demo;

import com.howtodoinjava.demo.model.Employee;

import java.util.List;

public interface IPersonService {
    public List<Employee> findAll();
    public Employee findByFirstName(String firstNameLong );
}
