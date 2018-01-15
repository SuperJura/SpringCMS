/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.util;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.PageDAO;
import com.spring.db.interfaces.TextDAO;
import com.spring.db.interfaces.UserStoryDAO;
import com.spring.db.interfaces.WidgetDAO;
import com.spring.models.Link;
import com.spring.models.Page;
import com.spring.models.Text;
import com.spring.models.UserStory;
import com.spring.models.Widget;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author JuraLocal
 */
public class SessionUtils {
        
    public static void setPageForEdit(int pageId, HttpServletRequest request, ApplicationContext ctx){
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
    
    public static void setPageForDisplay(int pageId, HttpServletRequest request, ApplicationContext ctx){
        PageDAO pageDao = ctx.getBean(PageDAO.class);
        TextDAO textDao = ctx.getBean(TextDAO.class);
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        
        Page page = pageDao.getPage(pageId);
        List<Text> texts = textDao.getAllTextsForPageId(pageId);
        boolean hasUserStories = false;
        for (Widget widget : page.getWidgets()) {
            if(widget.getWidgetId() == Widget.WIDGET_USER_STORY){
                hasUserStories = true;
                break;
            }
        }
        
        if(hasUserStories){
            UserStoryDAO storiesDao = ctx.getBean(UserStoryDAO.class);
            request.getSession().setAttribute("userStories", storiesDao.getAllStoriesForPage(pageId));
        }
        
        List<Link> links = linkDao.getAllBaseLinks();
        
        request.removeAttribute("page");
        request.removeAttribute("texts");
        request.removeAttribute("widgets");
        request.removeAttribute("links");

        request.getSession().setAttribute("page", page);
        request.getSession().setAttribute("texts", texts);
        request.getSession().setAttribute("links", links);
    }
}