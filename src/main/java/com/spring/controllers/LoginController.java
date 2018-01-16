/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.UserDAO;
import com.spring.models.Link;
import com.spring.models.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JuraLocal
 */
@Controller
public class LoginController {
    
    @Autowired
    ApplicationContext ctx;
    
    @PostMapping(value={"/Login"})
    public String login(@RequestParam(value = "login", required =  false) String login,
                        @RequestParam(value = "register", required =  false) String register,
                        @RequestParam String name, 
                        @RequestParam String pass, 
                        HttpServletRequest request){
        
        UserDAO dao = ctx.getBean(UserDAO.class);
        if(login!= null){
            User user = dao.getUser(name, pass);
            if(user == null){
                Map<String, String> output = new HashMap<String, String>();
                request.getSession().setAttribute("headerMsg", "No user found for that username and password combination.");
            }
            else{
                request.getSession().setAttribute("user", user);
            }
        }
        else if(register != null){
            if(name.equals("")){
                request.getSession().setAttribute("headerMsg", "Username cannot be empty!");
            }
            else if(dao.existUsername(name)){
                request.getSession().setAttribute("headerMsg", "Username is in use!");
            }
            else if(pass.length() < 4){
                request.getSession().setAttribute("headerMsg", "Password should be min 4 characters!");
            }
            else{
                User newUser = new User();
                newUser.setName(name);
                newUser.setPassword(pass);
                newUser.setIsAdmin(false);
                dao.insert(newUser);
                request.getSession().setAttribute("headerMsg", "User successfully added, try to log in!");
            }
        }
        return "Index";
    }
    
    @RequestMapping(value="Logout")
    public String logout (HttpServletRequest request){
        User loggedUser = (User)request.getSession().getAttribute("user");
        if(loggedUser != null){
            request.getSession().removeAttribute("user");
        }
        
        return "Index";
    }
}
