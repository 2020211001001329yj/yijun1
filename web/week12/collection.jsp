<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //array
    String[] firstName = {"Bill","Scott","Larry"};
    //list
    List<String> lastName = new ArrayList<String>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
    //map
    Map<String,String> companyName = new HashMap<String, String>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","Microsoft");

    //set in any one scope
    pageContext.setAttribute("first",firstName);
    pageContext.setAttribute("last",lastName);
    pageContext.setAttribute("company",companyName);
%>

<ul>
    <li>${first[0]}  ${last[0]}--->${company["Ellison"]}--->${company.Ellison}</li>
    <li>${first[1]}  ${last[1]}--->${company["Gates"]}--->${company.Gates}</li>
    <li>${first[2]}  ${last[2]}--->${company["McNealy"]}--->${company.McNealy}</li>
</ul>
<hr />
<h3>Use JSTL c:forEach to get array elements</h3>
<ul>
    <c:forEach var="a" items="${first}">
        <li>${a}</li>
    </c:forEach>
</ul>
<h3>Use JSTL c:forEach to get list elements</h3>
<ul>
    <c:forEach var="a" items="${last}">
        <li>${a}</li>
    </c:forEach>
</ul>
<h3>Use JSTL c:forEach to get elements</h3>
<ul>
    <c:forEach var="a" items="${company}">
        <li>${a.key}--->${a.value}</li>
    </c:forEach>
</ul>
</body>
</html>
