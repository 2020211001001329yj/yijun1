<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="register.jsp">
    Username <input type="text" name="username"><br/>
    Password <input type="password" name="password"><br/>
    Email <input type="text" name="email"><br/>
    Gender <input type="radio" name="email"><br/>
    Date Of Birth <input type="text" name="birthDate"><br/>
    <input type="submit" value="Register">
</form>

<!--add tag lib file-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--create connection-->
<sql:setDataSource var="myDs" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC"
                   user="root"
                   password="123456"/>
<!--insert-->
<c:if test="${!empty param.username}">
    <sql:update var="newUser" dataSource="${mtDs}">
        insert into usertable value(?,?,?,?,?);
        <sql:param value="${param.username}" />
        <sql:param value="${param.password}" />
        <sql:param value="${param.email}" />
        <sql:param value="${param.gender}" />
        <sql:param value="${param.birthday}" />
    </sql:update>
</c:if>
<!--select-->
<sql:query var="selectUsers" dataSource="${myDs}">
    Select * from usertable
</sql:query>

<table>
    <tr>

    </tr>
    <c:forEach var="row" items="${selectUsers.rows}">
        <tr>
            <td><c:out value="${row.id}" /> </td>
            <td><c:out value="${row.username}" /> </td>
            <td><c:out value="${row.Password}" /> </td>
            <td><c:out value="${row.Email}" /> </td>
            <td><c:out value="${row.gender}" /> </td>
            <td><c:out value="${row.birthday}" /> </td>
        </tr>
    </c:forEach>
</table>

<hr>
<h1>13.Demo#3-fmt:formatNumber</h1>
<c:set var="accountBalance" value="9500.60" />
<h3>max. integer digits 3: <fmt:formatNumber type="number" maxIntegerDigits="3" value="${accountBalance}"/> </h3>
<h3>max. fraction digits 1:<fmt:formatNumber type="number" maxFractionDigits="3" value="${accountBalance}"/> </h3>
<h3>no grouping:<fmt:formatNumber type="number" groupingUsed="false" value="${accountBalance}"/> </h3>
<h3>percent with max.integer digits 3:<fmt:formatNumber type="percent" maxIntegerDigits="3" value="${accountBalance}"/> </h3>
<h3>percent with min.fraction digits 10:<fmt:formatNumber type="percent" maxIntegerDigits="10" value="${accountBalance}"/> </h3>
<h3>pattern ###.###E0:<fmt:formatNumber type="number" pattern="###.###E0" value="${accountBalance}"/> </h3>
<h3>Account Balance in USA :
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${accountBalance}"/>
</h3>
<h3>Account Balance in Canada:
    <fmt:setLocale value="zh_CN"/>
    <fmt:formatNumber value="${accountBalance}"/>
</h3>

<hr/>
<h1>13.Demo#4 -JSTL Function Tags</h1>
<c:set var="productDescription">
    About this item
    TWS Airdopes 443 offers true wireless exeperience with latest Bluetiith v5.0.
</c:set>
<h3>length:<c:out value="${fn:length(productDescription)}"/></h3>
<h3>substringAfter 443:</h3>${fn:substringAfter(productDescription, "443")}<br>
<h3>substringBefore v5.0:</h3>${fn:substringBefore(productDescription, "v5.0")}<br>

<h3>indexof this :<c:out value="${fn:indexOf(productDescription, 'this')}"/></h3>

<h3>   substring: ${fn:substring(productDescription, fn:indexOf(productDescription, "433"), fn:indexOf(productDescription, "v5.0"))}</h3>
<c:forEach var="q" items="${fn:split(productDescription, '433')}">
    <h3>split :${q}</h3>
</c:forEach>

<%@include file="footer.jsp"%>
