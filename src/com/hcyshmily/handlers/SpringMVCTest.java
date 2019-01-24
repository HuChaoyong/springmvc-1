package com.hcyshmily.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//如果RequestMapping是加在类上，那么里面的参数就是前缀
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private  static final  String SUCCESS = "success";

    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 1.@RequestMapping 除了修饰方法，还可以来修饰类
     * 2. 类定义处的，就是方法定义的路径前置， 方法定义处的，就一定是结尾部分的
     * @return
     */
    @RequestMapping("testRequestMapping")
    public String testRequestMapping() {
        System.out.println("23333");
        return SUCCESS;
    }
}
