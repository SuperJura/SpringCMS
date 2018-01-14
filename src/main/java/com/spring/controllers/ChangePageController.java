/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.PageDAO;
import com.spring.db.interfaces.TextDAO;
import com.spring.db.interfaces.WidgetDAO;
import com.spring.models.Link;
import com.spring.models.Page;
import com.spring.models.Text;
import com.spring.models.Widget;
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
public class ChangePageController {
    
    @Autowired
    ApplicationContext ctx;
    
    //-------PAGE METHODS---------
    @RequestMapping(value="/ListPages")
    public String listPages(HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        List<Page> pages = dao.getAllPages();
        
        request.getSession().setAttribute("pages", pages);
        return "changePage/ListPages";
    }
    
    @RequestMapping(value="/DeletePage")
    public String deletePage(@RequestParam int pageId, HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        Page page = dao.getPage(pageId);
        dao.deletePage(page);
        
        return listPages(request);
    }
    
    @RequestMapping(value="/CreatePage")
    public String createPage(@RequestParam(value="id", required=false) Integer id, HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        Page p = new Page();
        p.setTitle("New page");
        dao.insertPage(p);
        if(id != null && id == 1){
            setPageToSession(id, request, ctx);
            return "changePage/ChangeMain";
        }
        else{
            request.getSession().setAttribute("pages", dao.getAllPages());
            return "changePage/ListPages";
        }
    }
    
    @RequestMapping(value = "/PageDetails")
    public String PageDetails(@RequestParam int pageId, HttpServletRequest request){
        setPageToSession(pageId, request, ctx);
        return "changePage/ChangeMain";
    }
    
    //-------CONTENT METHODS---------
    @RequestMapping(value="/ChangeTitle")
    public String createPage(@RequestParam int id, @RequestParam String title, HttpServletRequest request){
        PageDAO dao = ctx.getBean(PageDAO.class);
        Page p = dao.getPage(id);
        p.setTitle(title);
        dao.updatePage(p);
        
        setPageToSession(id, request, ctx);
        return "changePage/ChangeMain";
    }
    
    @RequestMapping(value="/ChangeText")
    public String changeText(@RequestParam int textId, @RequestParam String value, HttpServletRequest request){
        TextDAO dao = ctx.getBean(TextDAO.class);
        Text text = dao.getText(textId);
        text.setValue(value);
        dao.updateText(text);
        
        setPageToSession(text.getIdPage(), request, ctx);
        return "changePage/ChangeMain";
    }
    
    @RequestMapping(value="/AddText")
    public String addText(@RequestParam int pageId, @RequestParam String value, HttpServletRequest request){
        TextDAO textDao = ctx.getBean(TextDAO.class);

        Text text = new Text();
        text.setIdPage(pageId);
        text.setValue(value);
        
        textDao.insertNewText(text);
        
        setPageToSession(pageId, request, ctx);
        return "changePage/ChangeMain";
    }
    
    @RequestMapping(value="/DeleteText")
    public String deleteText(@RequestParam int textId, HttpServletRequest request){
        TextDAO textDao = ctx.getBean(TextDAO.class);
        Text text = textDao.getText(textId);
        int pageId = text.getIdPage();
        textDao.deleteText(text);
        
        setPageToSession(pageId, request, ctx);
        return "changePage/ChangeMain";
    }
    
    //-------WIDGET METHODS---------
    @RequestMapping(value="/AddWidget")
    public String addWidget(@RequestParam int pageId, @RequestParam int widgetId, HttpServletRequest request){
        PageDAO pageDao = ctx.getBean(PageDAO.class);
        WidgetDAO widgetDao = ctx.getBean(WidgetDAO.class);
        
        Page page = pageDao.getPage(pageId);
        Widget widget = widgetDao.getWidgetForId(widgetId);

        page.getWidgets().add(widget);
        pageDao.updatePage(page);
        
        setPageToSession(pageId, request, ctx);
        return "changePage/ChangeMain";
    }
    
    @RequestMapping(value="/RemoveWidget")
    public String removeWidget(@RequestParam int pageId, @RequestParam int widgetId, HttpServletRequest request){
        PageDAO pageDao = ctx.getBean(PageDAO.class);
        Page page = pageDao.getPage(pageId);

        for (Widget widget : page.getWidgets()) {
            if(widget.getWidgetId() == widgetId){
                page.getWidgets().remove(widget);
                break;
            }
        }
        pageDao.updatePage(page);
        
        setPageToSession(pageId, request, ctx);
        return "changePage/ChangeMain";
    }
    
    
    public static void setPageToSession(int pageId, HttpServletRequest request, ApplicationContext ctx){
        
        LinkDAO links = ctx.getBean(LinkDAO.class);
        List<Link> l = links.list();
                
        PageDAO pageDao = ctx.getBean(PageDAO.class);
        TextDAO textDao = ctx.getBean(TextDAO.class);
        WidgetDAO widgetDao = ctx.getBean(WidgetDAO.class);
        
        Page page = pageDao.getPage(pageId);
        List<Text> texts = textDao.getAllTextsForPageId(pageId);
        List<Widget> allWidgets = widgetDao.getAllWidgets();
        
        boolean removedWidget = true;
        while(removedWidget){
            removedWidget = false;
            for (Widget pageWidget : page.getWidgets()) {
                for (Widget allWidget : allWidgets) {
                    if(pageWidget.getWidgetId() == allWidget.getWidgetId()){
                        allWidgets.remove(allWidget);
                        removedWidget = true;
                        break;
                    }
                }
                if(removedWidget) break;
            }
        }
        
        request.removeAttribute("page");
        request.removeAttribute("texts");
        request.removeAttribute("widgets");

        request.getSession().setAttribute("page", page);
        request.getSession().setAttribute("texts", texts);
        request.getSession().setAttribute("widgets", allWidgets);
    }
}