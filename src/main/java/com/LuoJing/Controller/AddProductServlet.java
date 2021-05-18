package com.LuoJing.Controller;

import com.LuoJing.Dao.ProductDao;
import com.LuoJing.Model.Category;
import com.LuoJing.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16771215)
public class AddProductServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path = "/WEB-INF/Views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String productName = request.getParameter("productName");
    double price = request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
    int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):8;
    String productDescription = request.getParameter("productDescription");

    InputStream inputStream = null;
    Part fileParts = request.getPart("picture");
    if (fileParts!=null)
    {
        inputStream = fileParts.getInputStream();
    }
    Product product = new Product();
    product.setProductName(productName);
    product.setProductDescription(productDescription);
    product.setPicture(inputStream);
    product.setPrice(price);
    product.setCategoryID(categoryId);

    ProductDao productDao = new ProductDao();
    int n = 0;
    try {
        n = productDao.save(product,con);
        System.out.println("=========================="+con);
        System.out.println(n);
        if(n > 0)
        {
            response.sendRedirect("productList");
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }

}


}
