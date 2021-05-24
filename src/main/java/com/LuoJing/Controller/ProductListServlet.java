package com.LuoJing.Controller;

import com.LuoJing.Dao.ProductDao;
import com.LuoJing.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //week12
        try {
            Connection con = null;
            con = (Connection) getServletContext().getAttribute("conn");
            ProductDao productDao = new ProductDao();
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList",productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String path = "/WEB-INF/Views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
