package com.LuoJing.week6;

import com.sun.corba.se.pept.transport.ListenerThread;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    private String driver;
    private String url;
    private String username;
    private String password;
    Connection conn = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("i am contextInitialized()");
        ServletContext Context = sce.getServletContext();
        driver = Context.getInitParameter("driver");
        url = Context.getInitParameter("url");
        username = Context.getInitParameter("username");
        password = Context.getInitParameter("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 建立数据库连接，获得连接对象conn
        try {
            conn = DriverManager.getConnection(url, username,password);
            Context.setAttribute("conn",conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am contextDestroyed()");
        try {
            conn.close();
            sce.getServletContext().removeAttribute("conn");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
