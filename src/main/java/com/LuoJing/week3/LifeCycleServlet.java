package com.LuoJing.week3;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="life",value="/life")
public class LifeCycleServlet extends HttpServlet {
    
    public LifeCycleServlet(){
        System.out.println("i am in LifeServlet");
    }

    public void init() throws ServletException {
        System.out.println("i am in init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service()--->doGet()");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>hello servlet Cycle</h1>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void destory(){
        System.out.println("i am in dsetory()");
    }
}
