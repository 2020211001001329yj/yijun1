<%@ page import="com.yijun.week10.StringBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo-2-week 10</title>
</head>
<body>
<h1>use java code to access String bean class</h1>
<jsp:useBean id="bean" class="com.yijun.week10.StringBean"/>
<%
//    com.yijun.week10.StringBean bean = new StringBean();//can change with useBean--step- 6
    //step-4
//    bean.setMessage("Hello Mr bean - from java code ");//change -step7
%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>
Message(using java code) : <%=bean.getMessage()%>
<h2>use usebean to access StringBean class in jsp</h2>
message(using getProperty) : <jsp:getProperty name="bean" property="message"/>
</body>
</html>
