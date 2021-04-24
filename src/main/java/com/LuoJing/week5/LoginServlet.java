package com.LuoJing.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import com.LuoJing.Dao.UserDao;
import com.LuoJing.Model.*;
//LoginServlet
@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    private String driver;
    private String url;
    private String username;
    private String password;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stat = null;
    public void init() throws ServletException {
        super.init();
        conn = (Connection) getServletContext().getAttribute("conn");
//        driver = getServletContext().getInitParameter("driver");
//        url = getServletContext().getInitParameter("url");
//        username = getServletContext().getInitParameter("username");
//        password = getServletContext().getInitParameter("password");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        username = request.getParameter("username");
        password = request.getParameter("password");

        try {
            User user = userDao.findByUsernamePassword(conn,username,password);
            if (user!=null){
                String remeberMe =request.getParameter("remeberMe");
                if (remeberMe!=null && remeberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                    Cookie remeberMeCookie = new Cookie("cRemeberMe",remeberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    remeberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(remeberMeCookie);

                }

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10);
                System.out.println("session id-->"+session.getId());

                Cookie cookie = new Cookie("sessionid",""+user.getId());//sessionid = user id
                cookie.setMaxAge(5*60);
                response.addCookie(cookie);


                session.setAttribute("user",user);
                String encodeURL = response.encodeURL("WEB-INF/Views/userInfo.jsp");
//                request.setAttribute("user",user);
//                System.out.println(user+"我是user");
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                request.getRequestDispatcher(encodeURL).forward(request,response);
            }else {
                request.setAttribute("massage","Username or Password is Error!!");
                request.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        username = request.getParameter("username");
//        password = request.getParameter("password");
//
//        String sql = "select * from usertable where username = ? and password = ?";
//        try {
//            stat = conn.prepareStatement(sql);
//            stat.setString(1,username);
//            stat.setString(2,password);
//
//            rs = stat.executeQuery();
//
//            PrintWriter pw = response.getWriter();
//            if (rs.next()) {
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthDate",rs.getString("birthday"));
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
////                pw.write("<h1>Login Success!!!</h1>");
////                pw.write("<h1>Welcome,"+username+"</h1>");
//            } else {
//                request.setAttribute("message","Username or password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
////                pw.write("<h1>Login Error!</h1>");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

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
