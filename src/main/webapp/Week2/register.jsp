<%--
  Created by IntelliJ IDEA.
  User: 13210
  Date: 2021/3/15
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<% String path=request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>



<%@include file="../header.jsp"%>
    <title>Register</title>
    <link rel="stylesheet" href="semantic-ui/semantic.min.css">
    <script type="text/javascript" src="js/jquery3.3.1.js"></script>
    <script type="text/javascript" src="semantic-ui/semantic.min.js"></script>

    <style>

        body{
            font-size:12px;
            font-family:"宋体";
        }
        .bule{
            border-color:#ABFEFE;}
        .font1{
            color:#666;}
        body{
            background-color: rgba(189, 226, 231, 0.605);
        }

    </style>

</head>
<body>

<%--value="${username}"--%>
<%--<form method="post" id="form" action="<%=path%>/index.jsp">--%>
<%--    Name: <input type="text" id="username" name="username" required minlength="8" placeholder="请输入用户名"/><br>--%>
<%--    Password: <input type="password" id="password" name="password" placeholder="请输入密码"/><br>--%>
<%--    email    :<input type="email" name="email" required><br/>--%>
<%--    Gender<input name="sex" type="radio" value="Male"/>Male--%>
<%--    <input name="sex" type="radio" value="Female"/>Female<br/>--%>
<%--    birthdate:<input type="datetime-local" name="yyyy-mm-dd" required><br/>--%>

<%--    <button type="button" name="loginButton" onclick="loginVerify();">登录</button><br>--%>

<%--</form>--%>
<form class="ui form" action="<%=path%>/register" method="post">

<%--    <div style="text-align: center;vertical-align: middle;">--%>
    <table width="400" height="29" border="0" align="center" >
        <tr align="center">
            <a href="http://www.ecjtu.jx.cn/"><h3>Go to ecjtu</h3></a>
        </tr>

<%--        Username:<input type="text" name="username" required><br/>--%>
        <tr>
            <td width="80" bgcolor="#00cccc"><b>Username:</b></td>
            <td><input type="text" name="username" class="bule" required></td>

        </tr>
        <br/>
<%--        Password:&nbsp;<input type="password" name="password" required minlength="8"><br/>--%>
        <tr>
            <td bgcolor="#00cccc"><b>Password:  </b></td>
            <td>
                <input type="password" name="password" size="20" class="bule" required minlength="8">
            </td>
<%--            <td class="font1">最少6个字符，不超过14个字符（数字，字母和下划线）--%>
<%--            </td>--%>
        </tr>
        <br/>
<%--        Email:<input type="email" name="email" required><br/>--%>
        <tr>
            <td bgcolor="#00cccc"><b>Email:</b></td>
            <td><input type="email" name="email" class="bule" required/></td>
        </tr>
        <br/>


<%--        Gender:<input name="sex" type="radio" value="Male"/>Male--%>
<%--        <input name="sex" type="radio" value="Female"/>Female<br/>--%>

        <tr>
            <td bgcolor="#00cccc"><b>Gender:  </b></td>
            <td colspan="2">
                <input type="radio"  name="gender" value="Male" checked="checked"/>Male
                <input type="radio"  name="gender" value="Female"/>Female
            </td>
        </tr>
        <br/>
<%--        Birthdate:<input type="datetime-local" name="yyyy-mm-dd" required><br/><br/>--%>

        <tr>
            <td bgcolor="#00cccc"><strong>Birthdate:</strong></td>
            <td colspan="2">
                <input type="datetime" name="birthdate" required/>
            </td>
        </tr>
        <br/>
    </table>
<%--        <input name="b1" type="submit" id="b1"  value="Registeime-locar"  required><br/>--%>

    <table width="400"  align="center">
        <tr>
            <td align="center">
                <input type="submit" name="sex" value="register">
                <input type="reset" name="sex" value="reset">
            </td>
        </tr>
    </table>
<%--    </div>--%>

</form>


<%@include file="../footer.jsp"%>

<script>
    function loginVerify() {
        var username =document.getElementById("username").value;
        var password =document.getElementById("password").value;

        if(username ==''){
            alert('用户名不能为空！');
            return;
        }
        if(password ==''){
            alert('密码不能为空！');
            return;
        }

        // document.getElementById("form").submit();
    }
</script>