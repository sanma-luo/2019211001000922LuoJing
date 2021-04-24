<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 13210
  Date: 2021/4/3
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<body>
<h1>Login</h1>
<%
    if ((request.getAttribute("massage")!=null)){
        out.print("<h3>"+request.getAttribute("massage")+"</h3>");
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",remeberMeValue="";
    if (allCookies!=null){
        for (Cookie c :allCookies){
            if (c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if (c.getName().equals("cRemeberMe")){
                remeberMeValue = c.getValue();
            }
        }
    }
%>
<form action="<%=request.getContextPath()%>/login" method="post">
Username:<input type="text" name="username" value="<%=username%>" required/><br>
Password:&nbsp;<input type="password" name="password" value="<%=password%>" minlength="8" required/><br>
    <input type="checkbox" value="1" name="remeberMe" <%=remeberMeValue.equals("1") ?"checked":""%> checked/>RemeberMe <br>
<input type="submit" value="Login"/>
<input type="reset" value="reset"/>

</form>
</body>
<%@include file="footer.jsp"%>
</html>
