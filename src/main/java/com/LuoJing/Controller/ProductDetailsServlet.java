package com.LuoJing.Controller;

import com.LuoJing.Dao.ProductDao;
import com.LuoJing.Model.Category;
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

@WebServlet(name = "ProductDetailsServlet",value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id")!=null?Integer.parseInt(request.getParameter("id")):0;
        ProductDao productDao = new ProductDao();
        if (id==0){
            return;
        }
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Product product = productDao.findById(id,con);
            request.setAttribute("p",product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String path = "/WEB-INF/Views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
