package com.hcyshmily.curd.handler;

import com.hcyshmily.curd.dao.DepartmentDao;
import com.hcyshmily.curd.dao.EmployeeDao;
import com.hcyshmily.curd.entities.Employee;
import com.hcyshmily.curd.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public  String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }


//    @ModelAttribute
//    public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
//        if (id != null) {
//            map.put("employee", employeeDao.get(id));
//        } else {
//
//        }
//    }


    // 保证在更新时，未编辑的属性不更新，需要用到 ModelAttribute

    // 这个是获取空的时候！ 新建时使用的
    @RequestMapping(value = "/emp/edit/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "edit";
    }

    // 保存后， 跳转到list界面
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 新增employee
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String add(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "add";
    }

    // 删除
    @RequestMapping(value = "/emp/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

//    @RequestMapping(value = "/testPojo", method = RequestMethod.POST)
    @RequestMapping(value = "/hero", method = RequestMethod.POST)
    @ResponseBody
    public String test(Hero hero) {
        return hero.toString();
    }



}
