<%@ page import="com.yijun.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user = (User) session.getAttribute("user");
%>
<h1>User Update</h1>

<form action="updateUser" name="update" onsubmit="return validation()" method="post">
    UserName:<input type="text" name="username" placeholder="Username" value="<%=user.getUsername()%>"><br>
    Password:<input type="password" name="password" placeholder="password" value="<%=user.getPassword()%>"><br>
    Email:<input type="email" name="email" placeholder="Email" value="<%=user.getEmail()%>"><br>
    Gender:<input type="radio" value="1" name="gender" <%=user.getGender()==1?"checked":""%>>Male
    <input type="radio" value="0" name="gender" <%=user.getGender()==0?"checked":""%>>Female<br>
    Birthday:<input type="date" placeholder="Date od Birth(yyyy-mm-dd)" name="date" value="<%=user.getBirthday()%>"><br>
    <input type="submit" value="提交">
</form>

<%@include file="footer.jsp"%>
