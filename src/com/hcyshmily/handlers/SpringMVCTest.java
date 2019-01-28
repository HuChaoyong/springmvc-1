package com.hcyshmily.handlers;

import com.hcyshmily.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//如果RequestMapping是加在类上，那么里面的参数就是前缀
@RequestMapping("/springmvc")
@Controller
@SessionAttributes(value = {"user"}, types = {Integer.class})
public class SpringMVCTest {

    private  static final  String SUCCESS = "success";

    /**
     * 把数据对象存放在 session中，
     * 1. 需要在类上添加 @SessionAttributes (只能放在类上！)
     * 2. 并指定属性名(value属性)，或对象类型类(types属性)
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("Jack", "pass", "Jack@233.com");
        map.put("user", user);
        map.put("age", 25);
        return "SessionAttributes";
    }

    /**
     * 目标方法可以添加 Map 类型，（实际上也可以是 Model类型或 ModelMap 类型）的参数
     * @param map
     * @return
     */
    @RequestMapping("testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("AAA", "bbb", "CCC"));
        return "Map";
    }

    /**
     * 目标方法返回的值可以是 ModelAndView类型，
     * 其中可以包含视图和模型信息
     * Spring MVC会把ModelAndView的model中的数据放入到 request域对象中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 小插曲， 引包不要引错了。是这个  import org.springframework.web.servlet.ModelAndView;
        String viewname = "ModelAndView";
        ModelAndView modelAndView = new ModelAndView(viewname);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }


    /**
     * 可以使用 Servlet 原生的 API 作为目标方法的参数， 具体支持以下类型
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * Java.security.Principal
     * Locale InputStream
     * OutputStream
     * Reader
     * Writer
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI, request: " + request + ", " + response);
        return SUCCESS;
    }

    /**
     * Spring mvc 会按照请求参数名和POJO属性名进行自动匹配
     * 自动为该对象填充属性值，支持级联属性， 如  user.address.province
     *
     * 传入pojo属性，就会自动生成对象, 这个在开发的时候用的会很多
     * @return
     */
    @RequestMapping(value = "/testPojo", method = RequestMethod.POST)
    public String testPojo(User user) {
        System.out.println("testPojo, user: " + user);
        return SUCCESS;
    }


    /**
     * 获取cookie属性值
     * @CookieValue 映射一个cookie值
     * @param j
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String j) {
        System.out.println("testCookieValue, JSESSIONID: " + j);
        return SUCCESS;
    }

    /**
     * 获取请求头
     * @param al
     * @return
     */
    @RequestMapping(value = "/testRequestHeader", method = RequestMethod.GET)
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, Accept-Language: " + al);
        return SUCCESS;
    }

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
