<%@include file="header.jsp"%>

<h1><%="Welcome my home page!"%></h1>
<form action="search" target="_blank" method="get">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<%--<a href="MyJsp.jsp"><h2>Hello Sevlet-Week1</h2></a>--%>
<%--<a href="me"><h2>Student Info Sevlet-Week2</h2></a>--%>
<%--<a href="life"><h2>Life Cycle Servlet-Week3</h2></a>--%>
<%--<a href="Week2/register.jsp"><h2>Register-getParameter-Week3</h2></a>--%>
<%--<a href="config"><h2>Config.parameter-Week4</h2></a>--%>
<%--<a href="Week2/register.jsp"><h2>Register-JDBC-Week4</h2></a>--%>
<%--<a href="index.jsp"><h2>include-Week5</h2></a>--%>
<%--<a href="login.jsp"><h2>Login-Week5</h2></a>--%>
<%@include file="footer.jsp"%>