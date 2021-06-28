package com.howtodoinjava.demo;

import com.howtodoinjava.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{
    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Employee> findAll() {

        String sql = "SELECT * FROM EMPLOYEE";

        List<Employee> cities = jtm.query(sql, new BeanPropertyRowMapper(Employee.class));

        return cities;
    }

    @Override
    public Employee findByFirstName(String firstName) {

        String sql = "SELECT * FROM EMPLOYEE WHERE firstName = ?";

        Employee employee = (Employee) jtm.queryForObject(sql, new Object[]{firstName},
                new BeanPropertyRowMapper(Employee.class));

        return employee;
    }
}
