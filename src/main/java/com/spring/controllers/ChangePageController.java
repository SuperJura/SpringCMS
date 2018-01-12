/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controllers;

import com.spring.db.interfaces.PageDAO;
import com.spring.models.Page;
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
public class ChangePageController {
    
    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/CreatePage")
    public String createPage(@RequestParam(value="id", required=false) Integer id, HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        if(id == 1){
            Page p = new Page();
            p.setTitle("Main page");
            dao.insertPage(p);
            System.out.println("ID: " + p.getPageId());
            request.getSession().setAttribute("page", p);
            return "ChangeMain";
        }
        return "Index";
    }
    
    @RequestMapping(value="/ChangeTitle")
    public String createPage(@RequestParam int id, @RequestParam String title, HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        Page p = dao.getPage(id);
        p.setTitle(title);
        dao.updatePage(p);
        
        request.removeAttribute("page");
        request.setAttribute("page", p);
        return "changePage/ChangeMain";
    }
}
