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
public class Text implements Serializable {
    
    private int textId;
    private String value;
    private int idPage;

    /**
     * @return the textId
     */
    public int getTextId() {
        return textId;
    }

    /**
     * @param textId the textId to set
     */
    public void setTextId(int textId) {
        this.textId = textId;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
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
}
