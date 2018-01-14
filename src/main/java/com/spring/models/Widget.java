package com.spring.models;

import java.util.HashSet;
import java.util.Set;

public class Widget {
    
    public static final int WIDGET_USER_STORY = 1;
    public static final int WIDGET_PICTURE = 2;

    
    private int widgetId;
    private String widgetName;
    private Set<Page> pages = new HashSet<Page>();

    /**
     * @return the widgetId
     */
    public int getWidgetId() {
        return widgetId;
    }

    /**
     * @param widgetId the widgetId to set
     */
    public void setWidgetId(int widgetId) {
        this.widgetId = widgetId;
    }

    /**
     * @return the widgetName
     */
    public String getWidgetName() {
        return widgetName;
    }

    /**
     * @param widgetName the widgetName to set
     */
    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    /**
     * @return the pages
     */
    public Set<Page> getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }
}
