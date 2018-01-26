package com.spring.controllers;

import com.spring.db.interfaces.UserStoryDAO;
import com.spring.models.User;
import com.spring.models.UserStory;
import com.spring.util.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserStoryController {
    //ISPISI STORYJE NA STRANICAMA DI IH IMA I ODVOJI OD TEXTOVA STRANICE

    @Autowired
    ApplicationContext ctx;
    
    @RequestMapping(value="/WidgetSubmitUserStory")
    public String widgetSubmitUserStory(@RequestParam int pageId, @RequestParam String userTxt, HttpServletRequest request){
        UserStoryDAO storyDao = ctx.getBean(UserStoryDAO.class);
        
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            UserStory story = new UserStory();
            story.setIdPage(pageId);
            story.setStoryText(userTxt);
            story.setUser(user);

            storyDao.insertNewStory(story);
        }
        
        SessionUtils.setPageForDisplay(pageId, request, ctx);
        return "Index";
    }
    
    @RequestMapping(value="/DeleteUserStory")
    public String deleteUserStory(@RequestParam int id, HttpServletRequest request){
        UserStoryDAO storyDao = ctx.getBean(UserStoryDAO.class);
        
        UserStory story = storyDao.getUserStoryForId(id);
        int pageId = story.getIdPage();
        
        User user = (User)request.getSession().getAttribute("user");
        
        if(user != null && (story.getUser().getUserId() == user.getUserId() || user.isIsAdmin())){
            storyDao.deleteStory(story);
        }
        
        SessionUtils.setPageForDisplay(pageId, request, ctx);
        return "Index";
    }
}