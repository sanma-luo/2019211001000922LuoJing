<%@ page import="com.LuoJing.Model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13210
  Date: 2021/4/8
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%--<% import com.LuoJing.Model.*;%>--%>
<h1>User Info</h1>
<%--<%--%>
<%--    Cookie[] allCookies = request.getCookies();--%>
<%--    for (Cookie cookie : allCookies) {--%>
<%--//        out.print("<br>" + cookie.getName() + "<br>  value=" + cookie.getValue());--%>
<%--    }--%>
<%--%>--%>
<%
//    request.getAttribute("user");
    User user = (User) session.getAttribute("user");
%>
<table>
<%--    <tr><td>Username:</td><td><%=user.getUername()%></td></tr>--%>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%=user.getBirthday()%></td></tr>
<%--    <tr><td>Username:</td><td><%=user.getAttribute()%></td></tr>--%>
<%--    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>--%>
<%--    <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>--%>
<%--    <tr><td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>--%>
<%--    <tr><td>BirthDate:</td><td><%=request.getAttribute("birthDate")%></td></tr>--%>
</table>

<form action="<%=request.getContextPath()%>/updateUser" method="get">
    <input type="submit" value="Update">
</form>
<%@include file="footer.jsp"%>
