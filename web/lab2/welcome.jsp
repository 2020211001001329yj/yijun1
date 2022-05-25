<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome,
    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    <jsp:useBean id="login" scope="request" class="com.yijun.lab2.Login"/>
<%
    if(login.getUsername() != null) {
%>
    <%--todo 10 : use jsp:getProperty to display username --%>
    <jsp:getProperty  name="login" property="username" />
<%
    }else{
        out.print(request.getAttribute("username"));
    }
%>
</h2>
</body>
</html>
