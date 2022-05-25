<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" name="register" onsubmit="return validation()" method="post">
        <input type="text" name="username" placeholder="Username" onchange="changeusername()"><span id="span1"></span><br>
        <input type="password" name="password" placeholder="password"><br>
        <input type="email" name="email" placeholder="Email"><br>
        Gender<input type="radio" value="1" name="gender">Male
        <input type="radio" value="0" name="gender">Female<br>
        <input type="date" placeholder="Date od Birth(yyyy-mm-dd)" name="date"><br>
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
        }
        function changeusername(){
            document.getElementById("span1").innerHTML=""
        }

    </script>
</body>
</html>
