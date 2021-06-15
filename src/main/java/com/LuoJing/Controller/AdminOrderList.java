package com.LuoJing.Controller;

import com.LuoJing.Dao.OrderDao;
import com.LuoJing.Model.Order;
import com.LuoJing.Model.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderList",value = "/admin/orderList")
public class AdminOrderList extends HttpServlet {
    private Connection con = null;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypeList = Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao = new OrderDao();
        List<Order> orderList = orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        String path = "/WEB-INF/Views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
