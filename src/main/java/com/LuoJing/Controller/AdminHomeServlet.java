package com.LuoJing.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.LuoJing.Model.*;

@WebServlet(name = "AdminHomeServlet",value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!=null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())){
                request.getRequestDispatcher("../WEB-INF/Views/admin/index.jsp").forward(request,response);
            }else {
                session.invalidate();
                request.setAttribute("message","Unauthorized Access Admin Module!!!");
                request.getRequestDispatcher("../WEB-INF/Views/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("message","Please login as admin!!!");
            request.getRequestDispatcher("../WEB-INF/Views/login.jsp").forward(request,response);
        }
    }
}
