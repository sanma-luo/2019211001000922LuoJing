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

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        try {
            List<Category> categoryList = category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductDao productDao = new ProductDao();
        List<Product> productList = null;

        try {
            if (request.getParameter("categoryId")==null){
                productList = productDao.findAll(con);
            }else {
                int categoryID = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryID,con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("productList",productList);
        String path = "/WEB-INF/Views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
