<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String aClass = request.getParameter("aClass");
        String id = request.getParameter("myid");
    %>
    <h1>java code</h1>
    <table>
        <tr><td>name:<%=request.getParameter("name")%></td></tr>
        <tr><td>class:<%=request.getParameter("aClass")%></td></tr>
        <tr><td>id:<%=request.getParameter("myid")%>></td></tr>
    </table>
<%--    EL--%>
    <h1>EL</h1>
    <table>
        <tr><td>name:${param.name}</td></tr>
        <tr><td>class:${param.aClass}</td></tr>
        <tr><td>id:${param.myid}</td></tr>
    </table>
</body>
</html>
