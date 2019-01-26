 Spring MVC 学习
> 在idea中新建的时候，初次运行，如果遇到 java.lang.ClassNotFoundException:org.springframework.web.context.ContextLoaderListener 错误
解决办法： 将 Project Structure 打开，选择Artifacts ， 在Output Layout –> Web-INF查看是否有lib目录， 如果没有，就在 右边Available Elements 窗口，
右键 Put into Output Root， 这样就OK了。
![avator](./images/error1.png)

# HelloWorld
1. 在idea中新建 spring mvc 项目
2. 配置xml文件， 默认的配置文件在  /WEB-INF/<servlet-name>-servlet.xml， 这里的<servlet-name>是在 web.xml中
<servlet-name>标签的值， 如果自己配置的话，可以这样写,如下就把配置放在了  src/springmvc.xml 中
    ```xml
        <servlet>
            <servlet-name>dispatcher</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:springmvc.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
    ```
3. 然后在servlet的xml配置文件中，添加扫描和前后缀配置
    ```xml
        <!--配置自定义扫描包-->
        <context:component-scan base-package="com.hcyshmily"></context:component-scan>
    
        <!--配置视图解析器 如何把handler返回值解析为实际的物理视图 -->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/views/"></property>
            <property name="suffix" value=".jsp"></property>
        </bean>
    ```
4. 然后，添加控制器类
    ```java
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
    ```
5. 添加视图， 在 /WEB-INF/views目录中，
    ```
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Success</title>
    </head>
    <body>
        <h4>Success</h4>
    </body>
    </html>
    ```
6. 启动（需要一些简单配置，在右上方配置到tomca即可)

# @RequestMapping 注解
 * 这个注解为控制器指定可以处理哪些URL请求
 * 在类和方法中都可以标注，但是，却有所不同
    1. 类定义处： 提供初步的映射信息，相对于根目录，也就是方法处注解路径的前置路径部分
    2. 方法处： 提供进一步的细分映射信息，相对于定义出的URL，若方法定义处没有标注注解，则默认使用类定义处的

 * 一个基本的http请求会有这些东西
![avator](./images/requestHeader.png)

* @RequestMapping的value、method、params以及header分别表示请求URL，请求方法，参数，以及
请求头的映射条件，它们之间的关系，联合使用可以让请求更加精确化.
> 如下代码，指定方法 POST， url地址 /testMethod  返回视图 success
```
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return “success”;
    }
```
> params 和 headers 支持简单的表达式
----
    1. param1   :表示请求必须包含名为param1的请求参数
    2. !param1  ：表示，请求不能包含名为param1的请求参数
    3. paramm1!=value  : 表示请求包含名为param1的请求参数，但其值不能为 value1
    4. {"param1=value1", param2} : 表示请求必须包含名为param1和param2的两个请求参数，且 param1的参数的值必须为value1
----
* Ant 风格资源地址支持3种匹配符
    1. ? :匹配一个字符   /user/create?   => user/createA,  user/createB
    2. \* : 匹配一个段的字符   /user/*/create  => /user/jack/create  , /user/yang/create
    3. \*\*: 匹配任意个段,  /user/**/create  => /user/create   , /user/aa/create , /user/aa/bb/cc/create

* @PathVariable  可以来映射URL中的占位符到目标方法的的参数中
```
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
```

* HiddenHttpMethodFilter 可以将POST请求转成 delete 和 put 请求（tomcat8不支持！）

* @RequestParam 请求参数获取
    1. value 参数名
    2. required 是否必须，默认是
    3. defaultValue 默认值
```
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam: username:" + un + ",age:" + age);
        return SUCCESS;
    }
```









 


