package com.hcyshmily.curd.handler;

import com.hcyshmily.curd.dao.DepartmentDao;
import com.hcyshmily.curd.dao.EmployeeDao;
import com.hcyshmily.curd.entities.Department;
import com.hcyshmily.curd.entities.Employee;
import com.hcyshmily.curd.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    // 下载文件的测试
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/test.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, status);

        return response;
    }

//    testHttpMessageConverter 的测试
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "Nice http request " + new Date();
    }

    @RequestMapping("/emps")
    public  String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "list";
    }


    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            map.put("employee", employeeDao.get(id));
        }
    }


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
    public String save(@Valid Employee employee, BindingResult binder) {
        System.out.println("save: " + employee);
        if (binder.getErrorCount() > 0) {
            for (FieldError error: binder.getFieldErrors()) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
        }
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

    @RequestMapping(value = "/hero", method = RequestMethod.POST)
    @ResponseBody
    public String test(Hero hero) {
        Department s = departmentDao.getDepartment(101);
        System.out.println(s);
        return hero.toString();
    }

    @ResponseBody
    @RequestMapping(value="/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }

    /**
     * 不自动绑定 lastName， 意味着，创建或者修改的 lastName将不会得到赋值.
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setDisallowedFields("lastName");
//    }

}
