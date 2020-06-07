package com.shaojie.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //将spring应用上下文对象存储到ServletContext域中
        ServletContext servletContext = servletContextEvent.getServletContext();

        //从域中获取全局参数
        String applicationContext = servletContext.getInitParameter("applicationContext");

        //读取配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext(applicationContext);

        servletContext.setAttribute("app",app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
