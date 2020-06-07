package com.shaojie.web;

import com.shaojie.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        //        ApplicationContext a=new ClassPathXmlApplicationContext("applicationContext.xml");

        //ServletContext servletContext1 = this.getServletContext();
        //ApplicationContext app = (ApplicationContext)servletContext.getAttribute("app");

        //WebApplicationContextUtils是spring封装好的直接调用，但是要在web.xml中配置全局参数和监听器
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService service=app.getBean(UserService.class);
        service.save();
    }
}
