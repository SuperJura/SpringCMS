/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db.interfaces;

import com.spring.models.Link;
import java.util.List;

/**
 *
 * @author JuraLocal
 */
public interface LinkDAO {
    public List<Link> list();
    public void insert(Link link);
}
