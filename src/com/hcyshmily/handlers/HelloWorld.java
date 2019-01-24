package com.hcyshmily.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

    /**
     * 1. 使用@RequestMapping来映射请求的URL
     * 2. 返回值会通过试图解析器，解析成物理视图
     *  prefix + returnValue + suffix 得到实际的物理视图位置
     * @return 返回的视图
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("Hello World!");
        return "success";
    }
}
