<%@include file="../header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>week3/Register</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/register" name="register" onsubmit="return validation()" method="post">
    <input type="text" name="username" placeholder="Username"><br>
    <input type="password" name="password" placeholder="password"><br>
    <input type="email" name="email" placeholder="Email"><br>
    Gender<input type="radio" value="Male" name="gender">Male
    <input type="radio" value="Female" name="gender">Female<br>
    <input type="date" name="date" placeholder="Date od Birth(yyyy-mm-dd)"><br>
    <input type="submit" value="提交">
  </form>
  <script>
    function validation(){
        let username = document.forms["register"]["username"].value;
        if(username == null || username == ''){
            alert("username must be required")
            document.getElementById("span1").innerHTML="不能为空"
            return false;
        }
        let password = document.forms["register"]["password"].value;
        if(password.length<8){
            alert("at least 8 characters")
            return false;
        }
        const reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        let email = document.forms["register"]["email"].value;
        if(!reg.test(email)){
            alert("Email is wrong")
        }
    }
  </script>
</body>
</html>
<%@include file="../footer.jsp"%>
