package com.LuoJing.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet3",value ="/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usernamevalue = request.getParameter("username");
        String passwordvalue = request.getParameter("password");
        String emailvalue = request.getParameter("email");
        String gendervalue = request.getParameter("gender");
        String birthdatevalue = request.getParameter("birthdate");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Username:"+usernamevalue+"</h1>");
        writer.print("<h1>Password:"+passwordvalue+"</h1>");
        writer.print("<h1>Email:"+emailvalue+"</h1>");
        writer.print("<h1>Gender:"+gendervalue+"</h1>");
        writer.print("<h1>Birthdate:"+birthdatevalue+"</h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
