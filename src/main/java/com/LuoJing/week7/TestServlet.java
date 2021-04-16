package com.LuoJing.week7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.LuoJing.Dao.*;
import com.LuoJing.Model.*;

@WebServlet(name = "TestServlet",value = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<com.LuoJing.Model.User> list = new ArrayList<>();
        UserDao userDao = new UserDao();
        Connection conn = null;
        User user = new User();
        conn = (Connection) getServletContext().getAttribute("conn");
        System.out.println(conn);
//        String email = request.getParameter("");
        PrintWriter pw = response.getWriter();
        try {
            list = userDao.findByEmail(conn,"ncvbc@s");
            pw.write("userDao.findByEmail:"+String.valueOf(list));
            pw.write("=========");
            list = userDao.findAllUser(conn);
            pw.write("userDao.findAllUser:"+String.valueOf(list));
            pw.write("=========");
            list = userDao.findByGender(conn,"Male");
            pw.write("userDao.findByGender:"+String.valueOf(list));
            pw.write("=========");
            user = userDao.findByUsernamePassword(conn,"admin","sdadsadssa");
            pw.write("userDao.findByUsernamePassword:"+user);
            pw.write("=========");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
