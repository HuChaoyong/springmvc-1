package com.hcyshmily.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//如果RequestMapping是加在类上，那么里面的参数就是前缀
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private  static final  String SUCCESS = "success";

    /**
     * 使用参数形式， 并配置RequestParam获取
     * @param un username
     * @param age age
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam: username:" + un + ",age:" + age);
        return SUCCESS;
    }

    /**
     * Rest 风格的 URL
     * 以 CRUD 为例， (Create Read Update Delete)
     * 新增: /order   post
     * 修改： /order/1     put
     * 获取: /order/1     get
     * 删除： /order/1     delete
     *
     * 如何发送put请求和delete请求？
     * 1. 配置 HiddenHttpMethodFilter(在 web.xml中)
     * 2. 需要发送 POST请求
     * 3. 需要在发送 POST请求时，携带一个 name="_method" 的隐藏域， 值为 DELETE 或 PUT
     * 注意： Tomcat8 不支持 put 和 delete !
     */


    /**
     * 接收delete请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest put: " + id);
        return SUCCESS;
    }

    /**
     * 接收delete请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest delete: " + id);
        return SUCCESS;
    }

    /**
     * @PathVariable  可以来映射URL中的占位符到目标方法的的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable:" + id);
        return SUCCESS;
    }

    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解使用params 和 headers 来更加精确的映射请求， 支持简单的表达式
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username", "age!=10"}, headers = {"Accept-Language=zh,zh-CN;q=0.8"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 常用： 使用 method指定请求方式，这里是指定post
     * @return
     */
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
