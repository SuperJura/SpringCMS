package com.spring.models;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JuraLocal
 */
public class Link {
    
    private int linkId;
    private int desPageId;
    private String linkTitle;
    private Set<Link> parentLink = new HashSet<Link>();
    private Set<Link> childLinks = new HashSet<Link>();

    protected Link() {
    }

    /**
     * @return the linkId
     */
    public int getLinkId() {
        return linkId;
    }

    /**
     * @param linkId the linkId to set
     */
    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    /**
     * @return the desPageId
     */
    public int getDesPageId() {
        return desPageId;
    }

    /**
     * @param desPageId the desPageId to set
     */
    public void setDesPageId(int desPageId) {
        this.desPageId = desPageId;
    }

    /**
     * @return the childLinks
     */
    public Set<Link> getChildLinks() {
        return childLinks;
    }

    /**
     * @param childLinks the childLinks to set
     */
    public void setChildLinks(Set<Link> childLinks) {
        this.childLinks = childLinks;
    }

    /**
     * @return the parentLink
     */
    public Set<Link> getParentLink() {
        return parentLink;
    }

    /**
     * @param parentLink the parentLink to set
     */
    public void setParentLink(Set<Link> parentLink) {
        this.parentLink = parentLink;
    }

    /**
     * @return the linkTitle
     */
    public String getLinkTitle() {
        return linkTitle;
    }

    /**
     * @param linkTitle the linkTitle to set
     */
    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }
    
    public void changeParent(Link link){
        this.parentLink.clear();
        this.parentLink.add(link);
    }
}