<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%--week5--%>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>hello</title>--%>
<%--&lt;%&ndash;    <p><%=session.getAttribute("username")%></p>&ndash;%&gt;--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  <a href="hello-servlet">Hello Servlet-week1</a>--%>
<%--  <br/>--%>
<%--  <a href="hello">Student Info Servlet-week2</a>--%>
<%--  <br/>--%>
<%--  <a href="life.jsp">Lise Cycle Servlet</a>--%>
<%--  <br/>--%>
<%--  <a href="register">Register-getParameter-week3</a>--%>
<%--  <br/>--%>
<%--  <a href="config">Config parameter-week4</a>--%>
<%--  <br/>--%>
<%--  <a href="register">Register JDBC</a>--%>
<%--  <br/>--%>
<%--  <a href="index.jsp">include-week5</a>--%>
<%--  <br/>--%>
<%--  <a href="login.jsp">login-week5</a>--%>
<%--  </body>--%>
<%--</html>--%>

<%--week6--%>
  <h2>Welcome to My Online Shop Home Page.</h2> <br>
  <form method="get" target="_blank" action="search">
    <!-- <url-pattern>/search</url-pattern> -->
    <input type="text" name="txt" size="30">
    <select name="search">
      <option value="baidu">Baidu</option>
      <option value="bing">Bing</option>
      <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
  </form>
<%@include file="footer.jsp"%>
