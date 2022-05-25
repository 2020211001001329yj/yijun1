<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
//java code here
    public void jspInit(){
        System.out.println("I am in jspInit!");
    }
%>
<html>
<head>
    <title>life cycle JSP</title>
</head>
<body>
<h1><%= "Hello World!"%><%System.out.println("service");%>
    Date and Time:<% out.print(new Date());%>
</h1>
</body>
</html>
<%!
public void jspDestroy(){
    System.out.println("I am in jspDestroy!");
}
%>
