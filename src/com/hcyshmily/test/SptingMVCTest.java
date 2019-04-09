package com.hcyshmily.test;

import com.hcyshmily.curd.dao.EmployeeDao;
import com.hcyshmily.curd.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SptingMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee")Employee employee) {
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
