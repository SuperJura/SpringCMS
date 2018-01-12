package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.models.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    
    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/Home", method = RequestMethod.GET)
    public String root(ModelMap model){
        Link l = ctx.getBean(LinkDAO.class).list().get(0);
        model.addAttribute("var", l.getLinkId());
        return "Index";
    }
    
    @RequestMapping(value="/try", method = RequestMethod.GET)
    public String viewIndex(ModelMap model){
        model.addAttribute("var", "some random return");
        return "Index";
    }
}
