// SelectServlet
package com.LuoJing.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "SelectServlet" ,value = "/Select")
public class SelectServlet extends HttpServlet {
    private String driver;
    private String url;
    private String username;
    private String password;
    ResultSet rs = null;
    Connection conn=null;
    Statement stat = null;
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

        try{

            System.out.println("init()-->"+conn);

            String sql = "select * from usertable";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            PrintWriter pw = response.getWriter();
            pw.write("<table border='1' style='text-align:center;'>");
            pw.write("<td>ID</td>");
            pw.write("<td>username</td>");
            pw.write("<td>password</td>");
            pw.write("<td>email</td>");
            pw.write("<td>gender</td>");
            pw.write("<td>birthdate</td>");

            while(rs.next()){
                int IDvalue = rs.getInt("id");
                String usernamevalue = rs.getString("username");
                String passwordvalue = rs.getString("password");
                String emailvalue = rs.getString("email");
                String gendervalue = rs.getString("gender");
                Date birthdatevalue = rs.getDate("birthday");

                pw.write("<tr>");
                pw.write("<td>"+IDvalue+"</td>");
                pw.write("<td>"+usernamevalue+"</td>");
                pw.write("<td>"+passwordvalue+"</td>");
                pw.write("<td>"+emailvalue+"</td>");
                pw.write("<td>"+gendervalue+"</td>");
                pw.write("<td>"+birthdatevalue+"</td>");
                pw.write("</tr>");

            }
                pw.write("</table>");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void destory(){
        super.destroy();
        try {
            conn.close();
            stat.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
