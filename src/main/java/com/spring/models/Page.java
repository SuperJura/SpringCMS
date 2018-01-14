/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JuraLocal
 */
public class Page implements Serializable {
    
    private int pageId;
    private String title;
    private Set<Widget> widgets = new HashSet<Widget>();

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

    /**
     * @return the widgets
     */
    public Set<Widget> getWidgets() {
        return widgets;
    }

    /**
     * @param widgets the widgets to set
     */
    public void setWidgets(Set<Widget> widgets) {
        this.widgets = widgets;
    }
}
