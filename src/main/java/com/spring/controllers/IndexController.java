package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.PageDAO;
import com.spring.models.Link;
import com.spring.models.Page;
import javax.servlet.http.HttpServletRequest;
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
    
    @RequestMapping(value={"/Home", "/"}, method = RequestMethod.GET)
    public String root(ModelMap model){
        return "Index";
    }
    
    @RequestMapping(value="/ChangeMain")
    public String viewIndex(HttpServletRequest request){
        setPageToSession(request, 1);
        return "changePage/ChangeMain";
    }
    
    private void setPageToSession(HttpServletRequest request, int pageId){
        PageDAO dao = (PageDAO)ctx.getBean(PageDAO.class);
        Page page = dao.getPage(pageId);
        request.getSession().setAttribute("page", page);
    }
}
