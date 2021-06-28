package com.howtodoinjava.demo;

import com.howtodoinjava.demo.model.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private IPersonService cityService;

    @RequestMapping("/employees")
    public List<Employee> findCities() {

        return cityService.findAll();
    }

    @RequestMapping("/employee/{firtsName}")
    public Employee findEmployee(@PathVariable String firtsName) {

        return cityService.findByFirstName(firtsName);
    }

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;


    @RequestMapping("/batch")
    public String batch() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
        return "OK";
    }
}