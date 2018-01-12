/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.models;

/**
 *
 * @author JuraLocal
 */
public class Link {
    
    private int linkId;
    private String destination;
    private boolean subLink;
    private int[] subLinkIds;

    protected Link() {
    }

    public Link(String destination, boolean subLink, int[] subLinkIds) {
        this.destination = destination;
        this.subLink = subLink;
        this.subLinkIds = subLinkIds;
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
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the subLink
     */
    public boolean isSubLink() {
        return subLink;
    }

    /**
     * @param subLink the subLink to set
     */
    public void setSubLink(boolean subLink) {
        this.subLink = subLink;
    }

    /**
     * @return the subLinkIds
     */
    public int[] getSubLinkIds() {
        return subLinkIds;
    }

    /**
     * @param subLinkIds the subLinkIds to set
     */
    public void setSubLinkIds(int[] subLinkIds) {
        this.subLinkIds = subLinkIds;
    }
}
