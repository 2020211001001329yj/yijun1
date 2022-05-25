<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"</h3>");
}
%>
<form name="login" method="post" action="login">
    Username:<input type="text" name="username"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
