package com.LuoJing.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLEncoder;

@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String txt = URLEncoder.encode(request.getParameter("txt"),"utf-8");
        response.setCharacterEncoding("utf-8");  //设置响应格式编码为utf-8
        response.setHeader("Content-type","text/html;charset=utf-8");  //设置客户端响应内容的头文件，响应类型和响应编码，即告诉浏览器要用utf-8形式解码
        String txt = URLEncoder.encode(request.getParameter("txt"),"utf-8") ;
//        response.setContentType("text/html;charset=utf-8"); //同时设置服务端的编码格式和客户端的响应文件类型及响应编码格式
        String search = request.getParameter("search");

        if (txt == null){
            response.sendRedirect("index.jsp");
        }else {
            if (search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if (search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if (search.equals("google")){
                response.sendRedirect("https://www.google.cn/search?q="+txt);
            }
        }


    }
}
