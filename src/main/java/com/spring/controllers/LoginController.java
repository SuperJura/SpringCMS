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
    public String login(@RequestParam String name, @RequestParam String pass, HttpServletRequest request){
        
        UserDAO dao = ctx.getBean(UserDAO.class);
        User user = dao.getUser(name, pass);
        if(user == null){
            Map<String, String> output = new HashMap<String, String>();
            request.getSession().setAttribute("headerMsg", "No user found for that username and password combination.");
        }
        else{
            request.getSession().setAttribute("user", user);
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
