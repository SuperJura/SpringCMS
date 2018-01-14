package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.models.Link;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JuraLocal
 */
@Controller
public class ChangeHeaderController {
    
    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/ChangeHeader")
    public String changeHeader(HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        
        List<Link> links = linkDao.getAllBaseLinks();
        
        request.getSession().setAttribute("links", links);
        return "changeHeader/ChangeHeader";
    }
    
    @RequestMapping(value="/AddBaseLink")
    public String addBaseLink(@RequestParam String linkTitle, HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        
        Link link = new Link();
        link.setLinkTitle(linkTitle);

        linkDao.insert(link);
        List<Link> links = linkDao.getAllBaseLinks();
        
        request.getSession().setAttribute("links", links);
        return "changeHeader/ChangeHeader";
    }
}
