/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.models;

import java.io.Serializable;

/**
 *
 * @author JuraLocal
 */
public class Page implements Serializable {
    
    private int pageId;
    private String title;
    DODAJ WIDGETE MANY TO MANY
    //Bug kada brises page, pobrisi prvo sve Textove i WidgetPages

    /**
     * @return the pageId
     */
    public int getPageId() {
        return pageId;
    }

    /**
     * @param pageId the pageId to set
     */
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
