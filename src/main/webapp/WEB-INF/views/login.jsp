<%--
  Created by IntelliJ IDEA.
  User: DARYWISE
  Date: 3/18/2026
  Time: 7:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
 <h1>Login is here: 🎉</h1>
 <form action ="${pageContext.request.contextPath}/auth/login" method="POST">
     Full Name:<input type="text" name="name" required/> <br><br>
     Email:<input type="email" name="email" required/> <br><br>
     Password:<input type="text" name="password" required/> <br><br>
     <input type="submit" value="Enter">
 </form>
</body>
</html>
