package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JuraLocal
 */
@Controller
public class ChangeHeaderController {
    
    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/GetHeader")
    public String getHeader(HttpServletRequest request){
        System.out.println("HERE");
        return "changeHeader/DisplayHeader";
    }
}
