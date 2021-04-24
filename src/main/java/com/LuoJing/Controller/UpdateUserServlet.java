package com.LuoJing.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.LuoJing.Dao.*;

import com.LuoJing.Model.*;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Views/updateUser.jsp").forward(request,response);
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        int id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String birthday = request.getParameter("birthdate");
//        System.out.println(conn);
//        System.out.println(id);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(email);
//        System.out.println(birthday);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(birthday);
            user.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        UserDao userDao = new UserDao();
        try {
//            int count = userDao.updateUser(conn,user);
            userDao.updateUser(conn,user);
            request.getRequestDispatcher("WEB-INF/Views/userInfo.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
