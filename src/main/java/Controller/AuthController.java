package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.AuthService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/*")
public class AuthController extends HttpServlet{
    private AuthService authService = new AuthService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path = request.getPathInfo();
      String view = path.substring(1);
      String jspPath = "/WEB-INF/views/" + view + ".jsp";
      request.getRequestDispatcher(jspPath).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if(path.equals("/signup")){
           String fullName = request.getParameter("name");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           String phone = request.getParameter("phone");
           String role =  request.getParameter("role");

           User user = new User();
           user.setFullName(fullName);
           user.setEmail(email);
           user.setPassword(password);
           user.setPhone(phone);
           user.setRole(role);

           String result = authService.register(user);
           if("Register successful!".equals(result) || "User already registered!".equals(result)) {
               response.sendRedirect(request.getContextPath()+"/auth/login");
           }else {
               request.setAttribute("errorMessage", result);
               System.out.println(result);
               request.getRequestDispatcher("/signup.jsp").forward(request, response);
           }
        }else{
             String email=request.getParameter("email");
             String password=request.getParameter("password");
             User user = authService.login(email,password);
             if(user == null){
                request.setAttribute("errorMessage", "Invalid email or password");
             }else{
                 System.out.println(user);
                 request.getRequestDispatcher("/user").forward(request,response);
                 System.out.println("forwarded to user");
             }
        }
    }
}
