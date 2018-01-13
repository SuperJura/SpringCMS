/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db.interfaces;

import com.spring.models.Text;
import java.util.List;

/**
 *
 * @author JuraLocal
 */
public interface TextDAO {
    
    public List<Text> getAllTextsForPageId(int idPage);
    public Text getText(int textId);
    public void insertNewText(Text text);
    public void updateText(Text text);
    public void deleteText(Text text);
}
