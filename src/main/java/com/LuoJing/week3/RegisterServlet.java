// RegisterServlet
package com.LuoJing.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.LuoJing.Dao.*;
import com.LuoJing.Model.*;



@WebServlet(name = "Servlet3",urlPatterns ="/register")
public class RegisterServlet extends HttpServlet {

    private String driver;
    private String url;
    private String username;
    private String password;
    Connection conn=null;
//    Statement st = null;
    public void init() throws ServletException {
        super.init();
        conn = (Connection) getServletContext().getAttribute("conn");
//        driver = getServletContext().getInitParameter("driver");
//        url = getServletContext().getInitParameter("url");
//        username = getServletContext().getInitParameter("username");
//        password = getServletContext().getInitParameter("password");
//        System.out.println(driver);
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(password);
//
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 建立数据库连接，获得连接对象conn
//        try {
//            conn = DriverManager.getConnection(url, username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usernamevalue = request.getParameter("username");
        String passwordvalue = request.getParameter("password");
        String emailvalue = request.getParameter("email");
        String gendervalue = request.getParameter("gender");
        String birthdatevalue = request.getParameter("birthdate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date birthdate = null;
//        try {
//            birthdate = dateFormat.parse(birthdatevalue);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
////        int n = 1;
//        User user = new User(usernamevalue,passwordvalue,emailvalue,gendervalue,birthdate);
//        UserDao userDao = new UserDao();
//        try {
//            userDao.saveUser(conn,user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try{

//            System.out.println("init()-->"+conn);

            String sql = "insert into usertable values (null ,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1,n++);
            stmt.setString(1,usernamevalue);
            stmt.setString(2,passwordvalue);
            stmt.setString(3,emailvalue);
            stmt.setString(4,gendervalue);
            stmt.setString(5,birthdatevalue);
            System.out.println(sql);

            stmt.executeUpdate();


        }
        catch (Exception e){
            e.printStackTrace();
        }
//        response.sendRedirect(request.getContextPath()+"/login.jsp");
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void destory(){
        super.destroy();
        try {
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


