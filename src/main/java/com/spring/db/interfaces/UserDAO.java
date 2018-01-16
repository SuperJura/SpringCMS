/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db.interfaces;

import com.spring.models.User;

/**
 *
 * @author JuraLocal
 */
public interface UserDAO {
    public User getUser(String username, String password);
    public boolean existUsername(String username);
    public void insert(User user);
}
