package com.shaojie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaojie.domain.User;
import com.shaojie.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserContorller {

    /**
     * 页面跳转
     * @return
     */

    @RequestMapping(value = "/conn",method = RequestMethod.GET,params = {"username"})//method = RequestMethod.GET只接受此种请求方式，，params必须携带的参数
    public String save(){
        System.out.println("Controller.......");
//        return "redirect:success";//forword默认
        return "success";
    }

    @RequestMapping("/conn2")
    public ModelAndView save2(){
        ModelAndView m=new ModelAndView();

        //设置视图模型数据
        m.addObject("username","shaojie");

        //设置视图名称
        m.setViewName("success");
        return m;
    }

    @RequestMapping("/conn3")
    public ModelAndView save3(ModelAndView m){
        //设置视图模型数据
        m.addObject("username","shaojie");

        //设置视图名称
        m.setViewName("success");
        return m;
    }
    @RequestMapping("/conn4")
    public String save4(Model m){
        //设置模型数据
        m.addAttribute("username","SpringMVC");

        return "success";//跳转页面
    }

    @RequestMapping("/conn5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","泡泡卡丁车");
        return "success";//跳转页面
    }


    /**
     * //回写数据
     * @param response
     * @return
     * @throws IOException
     */

    @RequestMapping("/conn6")
    public String save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello world");
        return "success";//跳转页面
    }


    @RequestMapping("/conn7")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public String save7(){
        return "success";//不是跳转页面
    }

    @RequestMapping("/conn8")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public String save8() throws JsonProcessingException {
        User user=new User();
        user.setName("烧结");
        user.setAge(20);

        //没有配置处理器映射器时
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;//不是跳转页面
    }
    @RequestMapping("/conn9")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public User save9() {
        User user=new User();
        user.setName("烧结");
        user.setAge(20);
        //配置处理器映射器时，直接返回对象，框架会自动装换为json格式，并返回
        return user;//不是跳转页面
    }


    /**
     * 获取请求参数
     */

    @RequestMapping("/conn10")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save10(String name,int age) {//username,age即为请求参数
        System.out.println(name);
        System.out.println(age);
    }

    @RequestMapping("/conn11")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save11(User user) {//POJO封装user实体，前端参数key必须与实体类一致
        System.out.println(user);

    }

    /**
     * 获取数组参数
     */
    @RequestMapping("/conn12")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save12(String[] str) {
        System.out.println(Arrays.asList(str));

    }

    /**
     * 获取集合类型参数
     */
    @RequestMapping("/conn13")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save13(VO vo) {//使用VO来封装到集合中
        System.out.println(Arrays.asList(vo));

    }

    @RequestMapping("/conn14")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save14(@RequestBody List<User> userList) {  //ajax请求直接封装到集合中，使用@RequestBody注解
        System.out.println(Arrays.asList(userList));

    }

    @RequestMapping("/conn15")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save15(@RequestParam(value = "name") String username) {//username,age即为请求参数
        //当请求参数名称与controller业务方法参数不一致时，使用@RequestParam(value="name",required = false,defaultValue = "itcast")
        System.out.println(username);

    }


    /**
     * restful风格请求参数
     */
    //http://localhost:8080/conn16/zhangsan
    @RequestMapping("/conn16/{name}")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save16(@PathVariable(value = "name") String username) {//username,age即为请求参数
        //当请求参数名称与controller业务方法参数不一致时，使用@RequestParam(value="name",required = false,defaultValue = "itcast")
        System.out.println(username);

    }

    /**
     * 自定义类型转换器
     */
    @RequestMapping("/conn17")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save17(Date data) {//username,age即为请求参数
        //当请求参数名称与controller业务方法参数不一致时，使用@RequestParam(value="name",required = false,defaultValue = "itcast")
        System.out.println(data);

    }


    /**
     * 获取相关servlet API,直接注入即可
     */
    @RequestMapping("/conn18")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save18(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        System.out.println(response);
        System.out.println(request);
        System.out.println(session);

    }

    /**
     * 获取请求头信息
     */
    @RequestMapping("/conn19")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save19(@RequestHeader(value = "User-Agent") String user_agent) {
        System.out.println(user_agent);
    }

    /**
     * 获取请求头Cookie
     */
    @RequestMapping("/conn20")
    @ResponseBody//使用该注解表示告知框架，直接响应数据并不是页面跳转
    public void save20(@CookieValue (value = "JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
    }




}

