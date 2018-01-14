package com.spring.models;

/**
 *
 * @author JuraLocal
 */
public class UserStory {
    private int userStoryId;
    private String storyText;
    private int idPage;
    private User user;

    /**
     * @return the userStoryId
     */
    public int getUserStoryId() {
        return userStoryId;
    }

    /**
     * @param userStoryId the userStoryId to set
     */
    public void setUserStoryId(int userStoryId) {
        this.userStoryId = userStoryId;
    }

    /**
     * @return the storyText
     */
    public String getStoryText() {
        return storyText;
    }

    /**
     * @param storyText the storyText to set
     */
    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    /**
     * @return the idPage
     */
    public int getIdPage() {
        return idPage;
    }

    /**
     * @param idPage the idPage to set
     */
    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}