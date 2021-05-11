<%--
  Created by IntelliJ IDEA.
  User: 13210
  Date: 2021/4/24
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.LuoJing.Model.User" %>
<%@include file="header.jsp"%>

<h1>User Update</h1>
<%
    User user = (User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=user.getId()%>">
    Username: <input type="text" id="username" name="username" value="<%=user.getUsername()%>" required minlength="8" placeholder="请输入用户名"/><br>
    Password: <input type="password" id="password" name="password" placeholder="请输入密码" value="<%=user.getPassword()%>"/><br>
    Email   :<input type="email" name="email" required value="<%=user.getEmail()%>"><br/>
    Gender  :<input name="sex" type="radio" value="Male" <%="Male".equals(user.getGender())?"checked":""%>/>Male
    <input name="sex" type="radio" value="Female" <%="Female".equals(user.getGender())?"checked":""%> />Female<br/>
    Birthday:<input type="datetime" name="birthdate" value="<%=user.getBirthday()%>" required/><br>
    <input type="submit" value="Save Changes"/>
    <input type="reset" value="reset"/>
</form>
<%@include file="footer.jsp"%>