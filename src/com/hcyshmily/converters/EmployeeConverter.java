package com.hcyshmily.converters;

import com.hcyshmily.curd.entities.Department;
import com.hcyshmily.curd.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {
    // 这是手动配置的转换器
    @Override
    public Employee convert(String source) {
        // GG-gg@163.com-0-105
        if (source != null) {
            String[] strArr = source.split("-");
            if (strArr != null && strArr.length == 4) {
                String lastName = strArr[0];
                String email = strArr[1];
                Integer gender = Integer.parseInt(strArr[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(strArr[3]));

                Employee employee = new Employee(null, lastName, email, gender, department);
                System.out.println( source + "-----" + employee);
                return employee;
            }
        }
        return null;
    }
}
