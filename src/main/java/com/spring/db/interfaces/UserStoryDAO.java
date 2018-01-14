package com.spring.db.interfaces;

import com.spring.models.UserStory;
import java.util.List;

/**
 *
 * @author JuraLocal
 */
public interface UserStoryDAO {
    public List<UserStory> getAllStoriesForPage(int pageId);
    public void insertNewStory(UserStory story);
}
