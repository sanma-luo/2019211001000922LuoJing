
// Test JDBC
package com.LuoJing.week4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "JDBCServlet")
public class JDBCServlet extends HttpServlet {

    Statement stmt=null;
    Connection conn=null;
    ResultSet res=null;


    public void init() throws ServletException {
        super.init();
//        String driver = getServletContext().getInitParameter("drive");
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_user";
        String username = "root";
        String password = "225514";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+conn);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()-->"+conn);
        String sql = "select * from usertable";

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
