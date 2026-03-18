<%--
  Created by IntelliJ IDEA.
  User: DARYWISE
  Date: 3/18/2026
  Time: 7:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
 <h1>Signup is here 🎉 input your credentials</h1>
 <form action ="${pageContext.request.contextPath}/auth/signup" method="POST">
     Full Name:<input type="text" name="name" required/> <br><br>
     Email:<input type="email" name="email" required/> <br><br>
     Password:<input type="text" name="password" required/> <br><br>
     Phone Number:<input type="text" name="phone" required/> <br><br>
     Role: <select name="role" >
              <option>User</option>
              <option>Admin</option>
           </select><br><br>
     <input type="submit" value="signUp">
 </form>
</body>
</html>
