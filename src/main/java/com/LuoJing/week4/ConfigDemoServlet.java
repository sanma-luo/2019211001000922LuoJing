// ConfigDemoServlet
package com.LuoJing.week4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(
        name = "ConfigDemoServlet",
        urlPatterns = "/config",
        initParams = {
        @WebInitParam(name="Name",value = "LuoJing"),
        @WebInitParam(name="StudentId",value = "2019211001000922"),
        }
    )
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("Name");
        String studentid = getServletConfig().getInitParameter("StudentId");

        PrintWriter pw = response.getWriter();
        pw.print("<h1>Name:"+name+"<h1>");
        pw.print("<h1>StudentId:"+studentid+"<h1>");
    }
}
