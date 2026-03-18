package service;

import DAO.UserDAO;
import model.User;

public class AuthService {
    private UserDAO userDAO = new   UserDAO();
    public String register(User user){
       User existingUser = userDAO.getUserByEmail(user.getEmail());
       if(existingUser!=null){
           return "User already registered!";
       }
       boolean success = userDAO.saveUser(user);
       if(success){
           return "Register successful!";
       }else{
           return "Register failed!";
       }
    }
    public User login(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        return user;
    }
}
