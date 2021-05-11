<%@ page import="com.LuoJing.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: 13210
  Date: 2021/5/8
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java bean demo</title>
</head>
<body>
<jsp:useBean id="bean" class="com.LuoJing.week10.StringBean"/>
<jsp:setProperty name="bean" property="message" value=""/>
<%
//    StringBean bean = new StringBean();
    bean.setMessage("Hello bean");
%>
<%=bean.getMessage()%>
<jsp:getProperty name="bean" property="message"/>
</body>
</html>
