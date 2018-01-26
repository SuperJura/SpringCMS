package com.spring.controllers;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.PageDAO;
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
@RequestMapping(value="/Admin")
public class ChangeLinkController {
    
    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/ChangeLinks")
    public String changeLinks(HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        PageDAO pageDao = ctx.getBean(PageDAO.class);
        
        List<Link> links = linkDao.getAllBaseLinks();
        
        request.getSession().setAttribute("links", links);
        request.getSession().setAttribute("pages", pageDao.getAllPages());
        return "changeHeader/ChangeLinks";
    }
    
    @RequestMapping(value="/AddNewLink")
    public String addNewLink(@RequestParam int parentLinkId, HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        
        Link link = new Link();
        link.setLinkTitle("New Link");
        link.setDesPageId(-1);
        if(parentLinkId != -1){
            link.changeParent(linkDao.getLinkForId(parentLinkId));
        }

        linkDao.insert(link);
        List<Link> links = linkDao.getAllBaseLinks();
        
        request.getSession().setAttribute("links", links);
        request.getSession().setAttribute("changeLink", link);
        return "changeHeader/ChangeLinks";
    }
    
    @RequestMapping(value="/ChangeLink")
    public String changeLink(@RequestParam int linkId, HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        
        request.getSession().setAttribute("changeLink", linkDao.getLinkForId(linkId));
        return "changeHeader/ChangeLinks";
    }
    
    @RequestMapping(value="/ChangeLinkTitle")
    public String changeLinkTitle(@RequestParam int linkId, @RequestParam String linkTitle, HttpServletRequest request){
        if(linkTitle.equals("")){
            linkTitle = "Default link";
        }
        
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        Link link = linkDao.getLinkForId(linkId);
        link.setLinkTitle(linkTitle);
        
        linkDao.update(link);
        
        request.getSession().setAttribute("changeLink", link);
        
        List<Link> links = (List<Link>)request.getSession().getAttribute("links");
        Link[] linkArray = new Link[links.size()];
        links.toArray(linkArray);
        changeTitle(linkArray, linkId, linkTitle);
        
        return "changeHeader/ChangeLinks";
    }
    
    @RequestMapping(value="/ChangeLinkPage")
    public String ChangeLinkPage(@RequestParam int linkId, @RequestParam int pageId, HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        Link link = linkDao.getLinkForId(linkId);
        link.setDesPageId(pageId);
        linkDao.update(link);
        
        request.getSession().setAttribute("changeLink", link);
        request.getSession().setAttribute("links", linkDao.getAllBaseLinks());
        return "changeHeader/ChangeLinks";
    }
    
    @RequestMapping(value="DeleteLink")
    public String deleteLink(@RequestParam int linkId, HttpServletRequest request){
        LinkDAO linkDao = ctx.getBean(LinkDAO.class);
        Link link = linkDao.getLinkForId(linkId);
        linkDao.delete(link);
        
        
        request.getSession().removeAttribute("changeLink");
        request.getSession().setAttribute("links", linkDao.getAllBaseLinks());
        return "changeHeader/ChangeLinks";
    }
    
    private void changeTitle(Link[] links, int linkId, String newTitle){
        for (int i = 0; i < links.length; i++) {
            if(links[i].getLinkId() == linkId){
                links[i].setLinkTitle(newTitle);
            }
            for (int j = 0; j < links[i].getChildLinks().size(); j++) {
                Link[] linkArray = new Link[links[i].getChildLinks().size()];
                links[i].getChildLinks().toArray(linkArray);
                changeTitle(linkArray, linkId, newTitle);
            }
        }
    }
}